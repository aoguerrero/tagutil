package io.github.aoguerrero;

import java.io.File;

public class Params {

  private final File file;
  private final static String currentDirectory = System.getProperty("user.dir");

  public Params(String[] args) throws TagUtilException {
    if (args.length != 1) {
      throw new TagUtilException("Invalid number or arguments");
    }
    String fileName = args[0];
    file = validatePath(fileName);
  }

  public File getFile() {
    return file;
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
}
