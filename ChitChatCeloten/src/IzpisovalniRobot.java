import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

public class IzpisovalniRobot extends TimerTask {
	private ChatFrame chat;
	private Timer timer;
	

	public IzpisovalniRobot(ChatFrame chat) {
		this.chat = chat;
		
	}

	/**
	 * Aktiviraj robota!
	 */
	public void activate() {
		timer = new Timer();
		timer.scheduleAtFixedRate(this, 5000, 1000);
	}
	
	public void deactivate() {
		timer.cancel();
	}
	
	@Override
	public void run(){ 
		String prejeto = Prenos.prejmi(chat.vzdevek.getText());
		
		
		// Tolmaèi niz tako, da ga pretvori iz in v JSON 
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new ISO8601DateFormat());

		try {	
			
			// En uporabnik v JSON
			Uporabnik asistent = new Uporabnik("aljaz", new Date());
			Uporabnik asistentFiz = new Uporabnik("Gregor", new Date());
			Uporabnik jaz = new Uporabnik("Jakob", new Date());
			
			String jsonAsistent;
			jsonAsistent = mapper.writeValueAsString(asistent);
			System.out.println(jsonAsistent);
					
			// iz JSON v enege uporabnika
			Uporabnik asistent2;
			asistent2 = mapper.readValue(jsonAsistent, Uporabnik.class);
			System.out.println(asistent2);
			
			// Seznam uporabnikov v JSON
			List<Uporabnik> asistenti = new ArrayList<Uporabnik>();
			asistenti.add(new Uporabnik("aljaz", new Date()));
			asistenti.add(new Uporabnik("matjaz", new Date()));
			String jsonAsistenti = mapper.writeValueAsString(asistenti);
			System.out.println(jsonAsistenti);
			
			// iz JSON v seznam uporabnikov
			TypeReference<List<Uporabnik>> t = new TypeReference<List<Uporabnik>>() { };
			List<Uporabnik> asistenti2 = mapper.readValue(jsonAsistenti, t);
			System.out.println(asistenti2);
			
			// Še za sporoèila
			Sporocilo sporocilo = new Sporocilo(false, "miki", "pluto", "How are you?", new Date());
			String jsonSporocilo;
			jsonSporocilo = mapper.writeValueAsString(sporocilo);
			System.out.println(jsonSporocilo);

		} catch (IOException e) {
			e.printStackTrace();
						
			
		}
		
		
					
		
	}
}
