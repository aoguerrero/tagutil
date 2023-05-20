package io.github.aoguerrero;

import java.io.File;

public class Params {

  private final File file;
  private final static String currentDirectory = System.getProperty("user.dir");
  private final String album;

  public Params(String[] args) throws TagUtilException {
    if (args.length > 2) {
      throw new TagUtilException("Invalid number or arguments");
    }
    String fileName = args[0];
    this.file = validatePath(fileName);
    if (args.length > 1)
      this.album = args[1];
    else
      this.album = null;
  }

  private File validatePath(String fileName) throws TagUtilException {
    File tmpFile = new File(fileName);
    if (!tmpFile.exists()) {
      tmpFile = new File(currentDirectory + File.separatorChar + fileName);
      if (!tmpFile.exists()) {
        throw new TagUtilException("File not found");
      }
      if (!tmpFile.isFile() || !tmpFile.canWrite()) {
        throw new TagUtilException("Error reading file");
      }
    }
    return tmpFile;
  }

  public File getFile() {
    return file;
  }
  
  public String getAlbum() {
    return this.album;
  }

}
