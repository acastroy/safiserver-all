package com.safi.workshop.audio.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyFileOutputStream extends FileOutputStream {

  private int currentLen;

  public MyFileOutputStream(File file) throws FileNotFoundException {
    super(file);
    currentLen = 0;
  }

  @Override
  public void write(byte[] b) throws IOException {
    super.write(b);
    currentLen++;
  }

  @Override
  public void write(byte[] b, int off, int len) throws IOException {
    super.write(b, off, len);
    int start = currentLen;
    currentLen += len;
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
