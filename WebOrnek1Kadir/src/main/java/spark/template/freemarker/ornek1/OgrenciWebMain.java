package spark.template.freemarker.ornek1;

import spark.*;
import spark.template.freemarker.*;
import static spark.Spark.*;
import java.util.*;

public class OgrenciWebMain {
	private static List<String> ogrenciListesi = new ArrayList<>();

	public static void main(String[] args) {

		ogrenciListesi.add("Ali");
		ogrenciListesi.add("Ayşe");
		ogrenciListesi.add("Merve");
		ogrenciListesi.add("Abdulkadir");
		FreeMarkerRoute anasayfa = new FreeMarkerRoute("/mebis/") {

			@Override
			public Object handle(Request request, Response response) {
				Map<String, Object> sayfaVerisi = new HashMap<>();
				sayfaVerisi.put("OGRENCI_LISTESI", ogrenciListesi);
				return new ModelAndView(sayfaVerisi, "/ornek1/anasayfa.html");
			}

		};
		get(anasayfa);

		Route ogrenciEkleFormAction = new Route("/mebis/ogrenci/ekle") {

			@Override
			public Object handle(Request request, Response response) {
				String isim = request.queryParams("isim");
				if (isim != null && isim.trim().length() > 0) {
					ogrenciListesi.add(isim);
				}
				response.redirect("/mebis/");
				return null;
			}

		};
		post(ogrenciEkleFormAction);
		
		Route ogrenciSilLink=new Route("/mebis/ogrenci/sil") {

			@Override
			public Object handle(Request request, Response response) {
				String id=request.queryParams("id");
				if (id != null && id.trim().length() > 0) {
					int index=Integer.valueOf(id);
					ogrenciListesi.remove(index);
				
				}
				response.redirect("/mebis/");
				return null;
			}
			
		};
		get(ogrenciSilLink);
	}

}
