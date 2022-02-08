package io.github.aoguerrero;

public class Main {

	public static void main(String[] args) throws Exception {
		try {
			Params params = new Params(args);
			System.out.println("Processing: " + params.getFile().getCanonicalPath());
			SongInfo songInfo = new SongInfo(params.getFile());
			System.out.println("Song information from the file name " + songInfo);
			TagWriter.writeTag(params.getFile(), songInfo);
			FileNameUtils.rename(params.getFile(), songInfo);
		} catch (TagUtilException tue) {
			System.out.println("Error: " + tue.getMessage());
		}
	}
}
