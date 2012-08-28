package org.flatland.drip;
import java.io.*;

public class DelayedFileOutputStream extends OutputStream implements Openable {
  final String path;
  private FileOutputStream fs;

  DelayedFileOutputStream(String path) {
    this.path = path;
  }

  public void forceOpen() {
    fs();
  }

  private synchronized FileOutputStream fs() {
    if (fs == null) {
      try {
        this.fs = new FileOutputStream(path);
      } catch (FileNotFoundException e) {
      }
    }
    return fs;
  }

  public void write(int b) throws IOException {
    fs().write(b);
  }

  public void write(byte[] b) throws IOException {
    fs().write(b);
  }

  public void write(byte[] b, int off, int len) throws IOException {
    fs().write(b, off, len);
  }

  public void close() throws IOException {
    fs().close();
  }
}
