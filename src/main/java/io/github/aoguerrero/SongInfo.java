package io.github.aoguerrero;

import java.io.File;
import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongInfo {

	private final String artist;
	private final String title;

	public SongInfo(File file) throws TagUtilException {
		String fileName = file.getName();
		Matcher matcher = Pattern.compile("([0-9]+ )?(.*) - (.*)\\..*").matcher(fileName);
		if (matcher.matches()) {
			this.artist = capitalize(cleanUp(matcher.group(2)));
			this.title = capitalize(cleanUp(matcher.group(3)));
		} else {
			if(file.getParent() == null)
				throw new TagUtilException("Can't determine the artist name");
			this.artist = capitalize(cleanUp(file.getParentFile().getName()));
			this.title = capitalize(cleanUp(file.getName().substring(0, file.getName().lastIndexOf('.'))));
		}
	}

	private String cleanUp(String name) {
		return Normalizer.normalize(name, Normalizer.Form.NFKD).replaceAll("[^0-9a-zA-Z ]", "").replaceAll(" +", " ").trim();
	}
	
    private String capitalize(final String str) {
        if (str == null || str.trim().length() == 0) {
            return str;
        }
        final char[] buffer = str.toCharArray();
        boolean capitalizeNext = true;
        for (int i = 0; i < buffer.length; i++) {
            final char ch = buffer[i];
            if (ch == ' ') {
                capitalizeNext = true;
            } else if (capitalizeNext) {
                buffer[i] = Character.toTitleCase(ch);
                capitalizeNext = false;
            }
        }
        return new String(buffer);
    }

	public String getArtist() {
		return artist;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return String.format("{artist %s: , title : %s}", artist, title);
	}

	
	
}
