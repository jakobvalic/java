import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
	 * Activate the robot!
	 */
	public void activate() {
		timer = new Timer();
		timer.scheduleAtFixedRate(this, 5000, 1000);
	}
	
	public void deactivate() {
		timer.cancel();
	}
	
	@Override
	public void run() {
		String prejeto = Prenos.prejmi(chat.vzdevek.getText());
		
		
		// Tolmaèi niz 
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new ISO8601DateFormat());
		
		TypeReference<List<Sporocilo>> t = new TypeReference<List<String>>() { };
		List<Sporocilo> asistenti2 = mapper.readValue(prejeto, t);
		
		// Izpišemo 
		chat.output.
		
	}
}
