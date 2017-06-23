import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Sporocilo {
	
	private boolean global;
	private String prejemnik;
	private String posiljatelj;
	private String tekst;
	private Date poslanoOb;
	
	private Sporocilo() { }
	
	/**
	 * @param global - Pove, ali bomo pošiljali vsem
	 * @param prejemnik - Komu pošiljamo
	 * @param posiljatelj - Kdor je trenutno prijavljen
	 * @param tekst - Tekst
	 * @param sentAt - Kdaj je bilo sporoèilo poslano 
	 */
	public Sporocilo(boolean global, String posiljatelj, String prejemnik, String tekst, Date poslanoOb) {
		this.global = global;
		this.prejemnik = prejemnik;
		this.posiljatelj = posiljatelj;
		this.tekst = tekst;
		this.poslanoOb = poslanoOb;
	}
	
	
	@Override
	public String toString() {
		return "Sporocilo [global=" + global + ", recipient=" + prejemnik + ", sender=" + posiljatelj +",text=" + tekst + ", sent_at=" + poslanoOb + "]";
	}

	@JsonProperty("global")
	public boolean getGlobal() {
		return global;
	}
	
	public void setGlobal(boolean global) {
		this.global = global;
	}

	@JsonProperty("recipient")
	public String getPrejemnik() {
		return prejemnik;
	}

	public void setUsername(String posiljatelj) {
		this.posiljatelj = posiljatelj;
	}
	
	@JsonProperty("sender")
	public String getPosiljatelj() {
		return posiljatelj;
	}
	
	@JsonProperty("text")
	public String getText() {
		return tekst;
	}

	public void setText(String tekst) {
		this.tekst = tekst;
	}
	

	@JsonProperty("last_active")
	public Date getLastActive() {
		return this.poslanoOb;
	}

	public void setLastActive(Date lastActive) {
		this.poslanoOb = lastActive;
	}
	
	
}
