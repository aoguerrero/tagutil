package io.github.aoguerrero;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws Exception {
		try {
			Params params = new Params(args);
			logger.info("Processing: " + params.getFile().getCanonicalPath());
			SongInfo songInfo = new SongInfo(params.getFile());
			logger.info("Song information from the file name " + songInfo);
			TagWriter.writeTag(params.getFile(), songInfo);
			FileNameUtils.rename(params.getFile(), songInfo);
		} catch (TagUtilException tue) {
			logger.error("Error: " + tue.getMessage());
		}
	}
}
