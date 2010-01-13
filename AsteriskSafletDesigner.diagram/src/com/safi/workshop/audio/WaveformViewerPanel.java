package com.safi.workshop.audio;

import javax.sound.sampled.DataLine;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import com.safi.workshop.audio.utils.RecordableClip;
import com.safi.workshop.audio.utils.RecordableClip.ClipListener;

/**
 * A panel that displays the waveform of an audio file.
 * 
 * 
 */
public class WaveformViewerPanel extends Composite {
  private final WaveformCanvas canvas;

  public WaveformViewerPanel(Composite parent) {
    super(parent, SWT.NONE);
    GridLayout gridLayout = new GridLayout();
    gridLayout.marginLeft = 0;
    gridLayout.marginRight = 0;
    setLayout(gridLayout);
    canvas = new WaveformCanvas(this);
    canvas.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
  }

  public void showClip(final RecordableClip c) {
    canvas.setClip(c);
    // mClipInfo.setText("Length: " + c.getLengthInSeconds() + " seconds.");
    //
    // c.addClipListener(new ClipListener() {
    // public void newData(int offset, int length) {
    // getDisplay().asyncExec(new Runnable() {
    // @Override
    // public void run() {
    // if (!mClipInfo.isDisposed())
    // mClipInfo.setText("Length: " + c.getLengthInSeconds()
    // + " seconds.");
    // }
    // });
    //				
    // }
    //
    // public void newPlayHead(int playhead) {
    // }
    // });
  }

  @Override
  public void addMouseListener(MouseListener listener) {
    if (canvas != null)
      canvas.addMouseListener(listener);
    else
      super.addMouseListener(listener);
  }

  @Override
  public void removeMouseListener(MouseListener listener) {
    if (canvas != null)
      canvas.removeMouseListener(listener);
    else
      super.removeMouseListener(listener);
  }
  private static final class WaveformCanvas extends Canvas {
    private static final int SAMPLES_PER_PIXEL = 50;
    int playHeadPixel;
    private RecordableClip clip;

    public WaveformCanvas(Composite parent) {
      super(parent, SWT.DOUBLE_BUFFERED);
      setBackground(getDisplay().getSystemColor(SWT.COLOR_BLACK));
      addPaintListener(new PaintListener() {
        long lastPaint = -1;

        @Override
        public void paintControl(PaintEvent evt) {
          // if (lastPaint >= 0 && evt.time - lastPaint < 100)
          // return;
          lastPaint = evt.time;
          paint(evt.gc);
        }
      });
    }

    public void setClip(RecordableClip c) {
      c.addClipListener(new ClipListener() {
        public void newData(int offset, int length) {
          if (isDisposed())
            return;
          getDisplay().asyncExec(new Runnable() {
            @Override
            public void run() {
              // TODO Auto-generated method stub
              if (!isDisposed())
                redraw();
            }
          });
        }

        public void newPlayHead(final long playhead) {
          if (isDisposed())
            return;
          getDisplay().syncExec(new Runnable() {
            @Override
            public void run() {
              if (!isDisposed()) {
                moveBar((int) playhead);
                redraw();
              }
            }
          });
        }

        @Override
        public void playerCreated(DataLine player) {
          // TODO Auto-generated method stub

        }

        @Override
        public void playerDisposed(DataLine player) {
          // TODO Auto-generated method stub

        }

        @Override
        public void playerStopped(DataLine player) {
          // TODO Auto-generated method stub

        }
      });
      clip = c;
    }

    void drawBar(GC g) {
      if (g != null) {
        // g.setForeground(getDisplay().getSystemColor(SWT.COLOR_BLACK));
        // g.setXORMode(true);
        g.drawLine(playHeadPixel, 0, playHeadPixel, getClientArea().height);
      }
    }

    public void moveBar(int php) {
      // drawBar(g);
      playHeadPixel = php;
      // drawBar(g);
    }

    private int getScaledSampleHeight(Rectangle clientArea, int max_sample_height, int sample) {
      double scaleFactor = clientArea.height / (max_sample_height * 0.8d);
      return (int) Math.round(sample * scaleFactor);
    }

    public void paint(GC g) {
      int lengthInSamples = -1;
      if (clip == null || (lengthInSamples = clip.getLengthInSamples()) == 0) {
        return;
      }
      g.setBackground(getDisplay().getSystemColor(SWT.COLOR_BLACK));
      g.setForeground(getDisplay().getSystemColor(SWT.COLOR_GREEN));
      Rectangle clientArea = getClientArea();
      // int samplesPerPixel = lengthInSamples / clientArea.width;
      float average_ct = 0;
      int max_sample_height = clip.getMaxSampleHeight();

      int midY = clientArea.height / 2;
      // g.setColor(Color.BLACK);

      boolean recording = clip.isRecording();
      if (recording) {
        int pixel = clientArea.x + clientArea.width;
        int lastx = pixel;
        int lasty = 0;
        for (int i = lengthInSamples - 1; i >= 0; i--) {
          int sample = clip.getSample(i);
          average_ct++;
          if (average_ct % SAMPLES_PER_PIXEL == 0) {
            int height = getScaledSampleHeight(clientArea, max_sample_height, sample);
            // float average = average_sum / average_ct;
            // int height = Math.round((average / max_sample_height) * clientArea.height);
            int x = pixel;
            int y = midY - height;
            g.drawLine(lastx, lasty, x, y);
            lastx = x;
            lasty = y;
            --pixel;
            average_ct = 0;
            if (pixel <= clientArea.x)
              break;
          }

        }
      } else {
        int lasty = midY;
        int pixel = 0;
        int lastx = 0;

        int head = (int) clip.getPlayHead();
        int pixelLoc = (int) (head / (float) SAMPLES_PER_PIXEL);
        int samplesPerZone = SAMPLES_PER_PIXEL * clientArea.width;

        int zone = (int) (pixelLoc / (float) clientArea.width);
        int startSample = zone * samplesPerZone;

        for (int i = startSample; i < lengthInSamples; i++) {
          int sample = clip.getSample(i);
          average_ct++;
          if (average_ct % SAMPLES_PER_PIXEL == 0) {
            int height = getScaledSampleHeight(clientArea, max_sample_height, sample);
            //            
            // float average = average_sum / average_ct;
            // int height = Math.round((average / max_sample_height) * clientArea.height);
            int x = pixel;
            int y = midY - height;
            g.drawLine(lastx, lasty, x, y);
            lastx = x;
            lasty = y;
            pixel++;
            average_ct = 0;

            if (pixel >= clientArea.width)
              break;
          }

        }
        playHeadPixel = (head - (samplesPerZone * zone)) / SAMPLES_PER_PIXEL;
        // System.out.println("zamples perzone "+samplesPerZone+" so start is "+startSample+" with zone "+zone);
        drawBar(g);
        // mClip.getPlayHead() / SAMPLES_PER_PIXEL;
      }
      // g.drawRect(0, 10, 1, -10);

      g.setForeground(getDisplay().getSystemColor(SWT.COLOR_GRAY));
      g.drawLine(0, midY, clientArea.width, midY);
    }
  }
}
