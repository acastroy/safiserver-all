package com.safi.workshop.audio.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MyByteArrayOutputStream extends OutputStream {
  private ByteArray byteArray;

  public MyByteArrayOutputStream(byte[] myArray) {
    super();
    byteArray = new ByteArray(myArray);
  }

  public MyByteArrayOutputStream(ByteArray byteArray) {
    this.byteArray = byteArray;
  }

  @Override
  public void write(int b) throws IOException {
    byteArray.add((byte) b);
  }

  @Override
  public void write(byte[] b, int off, int len) throws IOException {
    int start = byteArray.length();
    byteArray.add(b, off, len);

    // currentOffset = currentOffset + len;
    // System.arraycopy(b, off, buf, start, len);

    notify(start, len);

  }

  private void notify(int offset, int length) {
    for (NewDataListener l : mListeners) {
      l.newData(offset, length);
    }
  }

  private List<NewDataListener> mListeners = new ArrayList<NewDataListener>();

  public void addListener(NewDataListener l) {
    mListeners.add(l);
  }
  public static interface NewDataListener {
    public void newData(int offset, int length);
  }

}
