package io.github.aoguerrero;

import java.io.File;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

public class TagWriter {

	public static void writeTag(File file, SongInfo songInfo) throws Exception {
		AudioFile af = AudioFileIO.read(file);
		af.delete();
		Tag tag = af.getTagOrCreateAndSetDefault();
		tag.setField(FieldKey.ARTIST, songInfo.getArtist());
		tag.setField(FieldKey.TITLE, songInfo.getTitle());
		tag.setField(FieldKey.ALBUM, songInfo.getArtist());
		af.commit();
	}

}
