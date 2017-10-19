import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;

public class Prenos {

/*	public static void main(String[] args) throws Exception {
		prijava("Mare");
		prijava("Sovica Oka");
		System.out.println(uporabniki());
		posljiVsem("Mare", "Danes sem ulovil veliko rib. Pridite na veèerjo!");
		posljiEnemu("Mare", "Sovica Oka", "Zivjo!");
		posljiEnemu("Mare", "Oka", "Adijo, se vidimo prihodnjic.");
		prejmi("Mare");
		prejmi("Sovica Oka");
		odjava("Mare");
		uporabniki();
		
	}*/
	
	
	
	public static String prenesiStran (String spletnaStran) {
		try {
			String sporocilo = Request.Get(spletnaStran)
					.execute()
					.returnContent().asString();
			return sporocilo;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String uporabniki() {
		// Vrne seznam uporabnikov
		try {
			String sporocilo = Request.Get("http://chitchat.andrej.com/users")
					.execute()
					.returnContent().asString();
			return sporocilo;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static void prijava(String uporabnik) throws Exception {
		URI uri = new URIBuilder("http://chitchat.andrej.com/users")
				.addParameter("username", uporabnik)
				.build();
		
		String responseBody;
		responseBody = Request.Post(uri)
				.execute()
				.returnContent()
				.asString();
		
		System.out.println(responseBody);
	}
	
	public static void odjava(String uporabnik) throws Exception {
	URI uri;
		uri = new URIBuilder("http://chitchat.andrej.com/users")
				.addParameter("username", uporabnik)
				.build();
		String responseBody = Request.Delete(uri)
				.execute()
				.returnContent()
				.asString();
		System.out.println(responseBody);
	}
	
	
	
	public static void posljiVsem(String uporabnik, String sporocilo) throws Exception {

			URI uri = new URIBuilder("http://chitchat.andrej.com/messages")
					.addParameter("username", uporabnik)
					.build();
			String celotnoSporocilo = "{ \"global\" : true, \"text\" : \"" + sporocilo +  "\"  }";
			
			String responseBody = Request.Post(uri)
					.bodyString(celotnoSporocilo, ContentType.APPLICATION_JSON)
					.execute()
					.returnContent()
					.asString();
			
			System.out.println(responseBody);
			// Pošlje tudi samemu sebi
			posljiEnemu(uporabnik, uporabnik, sporocilo);


	}
	
	public static void posljiEnemu(String uporabnik, String naslovnik, String sporocilo) {
		try {
			URI uri = new URIBuilder("http://chitchat.andrej.com/messages")
					.addParameter("username", uporabnik)
					.build();
			String celotnoSporocilo = "{ \"global\" : false, \"recipient\" : \"" + naslovnik + "\", \"text\" : \"" + sporocilo +  "\"  }";
			
			String responseBody = Request.Post(uri)
					.bodyString(celotnoSporocilo, ContentType.APPLICATION_JSON)
					.execute()
					.returnContent()
					.asString();
			System.out.println(responseBody);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static String prejmi(String uporabnik) {
		try {
			URI uri = new URIBuilder("http://chitchat.andrej.com/messages")
					.addParameter("username", uporabnik)
					.build();
			String responseBody = Request.Get(uri)
					.execute()
					.returnContent()
					.asString();
			System.out.println(responseBody);
			return responseBody;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
		
	}

}
