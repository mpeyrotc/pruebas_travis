import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
 * This Java source file was auto generated by running 'gradle buildInit --type java-library'
 * by 'mpeyrotc' at '4/21/17 7:58 PM' with Gradle 2.9
 *
 * @author mpeyrotc, @date 4/21/17 7:58 PM
 */
public class WebScraping {
	public static String getFooterInfo(String site, List<String> queries) throws IOException {
		// Connect to webpage and get all html content
		Document doc = Jsoup.connect(site).timeout(10000).validateTLSCertificates(false).get();

		// Execute queries
		for (int i = 0; i < queries.size() - 1; i++) {
			String content = doc.select(queries.get(i)).html();
			// crreate a new DOM object
			doc = Jsoup.parse(content);
		}

		// Print the last query's content
		System.out.println(doc.select(queries.get(queries.size() - 1)).text());
		return doc.select(queries.get(queries.size() - 1)).text();
	}

	public static void main(String[] args) throws IOException {
		List<String> queries = new ArrayList<>();
		queries.add("section#block-direccion");
		queries.add("p");

		getFooterInfo("https://www.tec.mx/es", queries);
	}
}