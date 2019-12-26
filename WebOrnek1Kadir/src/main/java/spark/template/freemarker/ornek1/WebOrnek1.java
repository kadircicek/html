package spark.template.freemarker.ornek1;

import spark.*;
import static spark.Spark.*;

public class WebOrnek1 {

	public static void main(String[] args) {
		// http://localhost:4567/medipol/ornek1 gelicek
		Route webSayfasi1 = new WebSayfasi1("/medipol/ornek1");
		get(webSayfasi1);

	}

	private static class WebSayfasi1 extends Route {

		protected WebSayfasi1(String path) {
			super(path);

		}

		@Override
		public Object handle(Request request, Response response) {

			return "<html>" + "<head>" + "<title>Ornek 1 </title>" + "</head>" + "<body><b>sayfa 1 </b></body>"
					+ "</html>";

		}

	}

}
