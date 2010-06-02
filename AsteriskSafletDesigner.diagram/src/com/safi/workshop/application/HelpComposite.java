package com.safi.workshop.application;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;

import com.safi.workshop.util.BrowserControl;

public class HelpComposite extends Composite {

  private static final String SAFI_HELP_URL = "http://www.safisystems.com/index.cfm?pageMode=help";
  private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

  /**
   * Create the composite
   * 
   * @param parent
   * @param style
   */
  public HelpComposite(Composite parent, int style) {
    super(parent, style);
    BrowserControl.init();
    toolkit.adapt(this);
    toolkit.paintBordersFor(this);

    final Label helpDocumentationIsLabel = new Label(this, SWT.NONE);
    toolkit.adapt(helpDocumentationIsLabel, true, true);
    helpDocumentationIsLabel.setText("For the latest help updates, please visit our website:");
    helpDocumentationIsLabel.setBounds(26, 21, 254, 13);

    final Hyperlink httpswhelpsafisystemscomHyperlink = toolkit.createHyperlink(this,
        SAFI_HELP_URL, SWT.NONE);
    httpswhelpsafisystemscomHyperlink.addHyperlinkListener(new IHyperlinkListener() {
      public void linkActivated(HyperlinkEvent e) {
        try {
          BrowserControl.displayURL(SAFI_HELP_URL);
        } catch (IOException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
      }

      public void linkEntered(HyperlinkEvent e) {
      }

      public void linkExited(HyperlinkEvent e) {
      }
    });
    httpswhelpsafisystemscomHyperlink.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
      }
    });
    httpswhelpsafisystemscomHyperlink.setBounds(26, 49, 254, 15);
    //
  }

}
