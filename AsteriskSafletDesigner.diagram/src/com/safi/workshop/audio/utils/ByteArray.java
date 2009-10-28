package com.safi.workshop.audio.utils;

/**
 * Dynamic byte array.
 */
public class ByteArray {
  private byte[] data;
  private int alloc, used;
  private int grow_size = 1024;
  private static final int def_initsize = 100;

  /**
   * Initializes the ByteArray with size 100
   */
  public ByteArray() {
    initialize(def_initsize);
  }

  /**
   * Initialized the ByteArray with given size
   * 
   * @param init_size
   *          Initial size for the array.
   */
  public ByteArray(int init_size) {
    initialize(init_size);
  }

  public ByteArray(byte[] data) {
    this.data = data;
    this.used = data.length;
    this.alloc = used;
  }

  public ByteArray(ByteArray array) {
    this.used = array.used;
    this.alloc = array.alloc;
    data = new byte[array.data.length];
    System.arraycopy(array.data, 0, data, 0, data.length);
  }

  public void setGrowSize(int size) {
    this.grow_size = size;
  }

  /**
   * Clear this array
   */
  public void reset() {
    used = 0;
  }

  /**
   * Returns the lenght of this array
   */
  public int length() {
    return used;
  }

  /**
   * Returns this array
   */
  public byte[] get() {
    return data;
  }

  /**
   * Add a byte to this array.
   * 
   * @param b
   *          byte to add
   */
  public ByteArray add(byte b) {
    data[used++] = b;
    if (used == alloc)
      grow(grow_size);
    return this;
  }

  /**
   * Add a byte to this array is specified position.
   * 
   * @param b
   *          byte to add
   * @param pos
   *          position
   */
  public ByteArray addToPos(byte b, int pos) {
    if (pos >= alloc)
      grow(pos + 1);
    if (pos > used)
      used = pos + 1;
    data[pos] = b;
    return this;
  }

  public ByteArray addToPos(byte[] b, int pos) {
    if (pos + b.length >= alloc)
      grow(pos + b.length);
    if (pos > used)
      used = pos + b.length;
    System.arraycopy(b, 0, data, pos, b.length);
    return this;
  }

  /**
   * Add a array of bytes to this array
   * 
   * @param b
   *          Byte array to add
   * @param len
   *          Lenght of byte array to add.
   */
  public ByteArray add(byte[] b, int len) {
    if (used + len >= alloc)
      grow(len + grow_size);
    System.arraycopy(b, 0, data, used, len);
    used += len;
    return this;
  }

  public ByteArray add(byte[] b, int off, int len) {
    if (used + len >= alloc)
      grow(len + grow_size);
    System.arraycopy(b, off, data, used, len);
    used += len;
    return this;
  }

  /**
   * Add a ByteArray to this array
   * 
   * @param b
   *          ByteArray to add
   */
  public ByteArray add(ByteArray b) {
    return add(b.get(), b.length());
  }

  private void grow(int x) {
    alloc += x;
    byte[] n = new byte[alloc];
    System.arraycopy(data, 0, n, 0, used);
    data = n;
  }

  private void initialize(int sz) {
    data = new byte[sz];
    alloc = sz;
    used = 0;
  }

}
