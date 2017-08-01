/**
 * @author msezer
 * Jul 25, 2017
 * 
 * BookReaderUrl class reads a file which contains URLs,
 * parses them and returns an arraylist.
 */

package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class BookReaderUrl {

	public static BookReaderUrl instance = null;
	private String fileName;

	private static ArrayList<String> allUrls = null;

	/**
	 * @param fileName
	 */
	public BookReaderUrl(String fileName) {
		super();
		this.fileName = fileName;
	}

	public ArrayList<String> getUrls() {
		if (allUrls == null) {       
			allUrls = new ArrayList<String>();
			//read file into stream, try-with-resources
			try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
				stream.forEach((k) -> {allUrls.add(k);
				});
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return allUrls;
	}
}
