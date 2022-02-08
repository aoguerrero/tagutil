package io.github.aoguerrero;

import java.io.File;
import java.io.IOException;

public class FileNameUtils {

	public static String rename(File file, SongInfo songInfo) throws IOException {
		String newName = file.getAbsoluteFile().getParentFile().getCanonicalPath() + File.separator + songInfo.getArtist() + " - " + songInfo.getTitle()
				+ file.getName().substring(file.getName().lastIndexOf('.'));
		File newFile = new File(newName); 
		file.renameTo(newFile);
		return newFile.getName();
	}

}
