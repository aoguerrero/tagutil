package io.github.aoguerrero;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

  public static void main(String[] args) throws Exception {
    try {
      Logger.getLogger("org.jaudiotagger").setLevel(Level.OFF);

      Params params = new Params(args);
      System.out.print(params.getFile().getCanonicalPath() + " -> ");
      SongInfo songInfo = new SongInfo(params.getFile());
      System.out.print(songInfo.toString() + " -> ");
      TagWriter.writeTag(params.getFile(), songInfo);
      System.out.println(FileNameUtils.rename(params.getFile(), songInfo));
    } catch (TagUtilException tue) {
      System.out.println("Error: " + tue.getMessage());
    }
  }
}
