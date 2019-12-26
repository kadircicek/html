package spark.template.freemarker.ornek1;

import spark.*;
import static spark.Spark.*;

public class WebOrnek2 {

	public static void main(String[] args) {
		// http://localhost:4567/medipol/ornek1 gelicek
		Route webSayfasi1 = new Route("/medipol/ornek1") {
			@Override
			public Object handle(Request request, Response response) {

				return "<html>" + "<head>" + "<title>Ornek 1 </title>" + "</head>" + "<body><b>sayfa 2 </b></body>"
						+ "</html>";

			}
		};
		get(webSayfasi1);

	}
}