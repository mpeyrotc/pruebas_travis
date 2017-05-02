import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class WebScrapingTest {

	@Test
	public void test() throws IOException {
		List<String> queries = new ArrayList<>();
		queries.add("section#block-direccion");
		queries.add("p");

		Assert.assertTrue(WebScraping.getFooterInfo("https://www.tec.mx/es", queries).equals(
				"AV. EUGENIO GARZA SADA 2501 SUR COL. TECNOLÓGICO C.P. 64849 | MONTERREY, NUEVO LEÓN, MÉXICO | TEL. +52 (81) 8358-2000 D.R.© INSTITUTO TECNOLÓGICO Y DE ESTUDIOS SUPERIORES DE MONTERREY, MÉXICO. 2017"));
	}
}