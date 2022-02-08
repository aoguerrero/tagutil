package io.github.aoguerrero;

import java.io.File;

public class FileNameUtils {

	public static void rename(File file, SongInfo songInfo) {
		String newName = file.getParent() + File.separator + songInfo.getArtist() + " - " + songInfo.getTitle()
				+ file.getName().substring(file.getName().lastIndexOf('.'));
		file.renameTo(new File(newName));
	}

}
