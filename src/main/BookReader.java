/**
 * @author msezer
 * Jul 24, 2017
 */

package main;

import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class BookReader {

	/* @param fName variable gets the directory address for the urls.txt file
	 * @param urls variable holds the urls for the books
	 * @param bookreaderurl is the imported class variable for reading the txt file
	 */
	public static final String fName = System.getProperty("user.dir") + "/src/main/" + "Book_Reader_Urls.txt";
	public static ArrayList<String> urls;
	public static BookReaderUrl bookreaderurl;

	public static void main(String[] args) {
		bookreaderurl = new BookReaderUrl(fName);
		urls = new ArrayList<String>(bookreaderurl.getUrls());

		for (String temp : urls) {

			Document doc = null;

			try {
				doc = Jsoup.connect(temp).get();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(doc.select("div.product-name").text());
		}
	}
}