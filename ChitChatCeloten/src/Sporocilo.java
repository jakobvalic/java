import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sporocilo {
	
	

	private String posiljatelj;
	private String prejemnik;
	private String tekst;
	private boolean global;
	private Date sentAt;
	
	private Sporocilo() { }
	
	public Sporocilo(boolean global, String posiljatelj, String prejemnik, String tekst, Date lastActive) {
		this.posiljatelj = posiljatelj;
		this.global = global;
		this.prejemnik = prejemnik;
		this.tekst = tekst;
		this.sentAt = lastActive;
	}
	
	
	@Override
	public String toString() {
		return "Uporabnik [username=" + username + ", lastActive=" + lastActive + "]";
	}

	@JsonProperty("global")
	public boolean getPosiljatelj() {
		return global;
	}
	
	@JsonProperty("recipient")
	public String getPrejemnik() {
		return prejemnik;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonProperty("last_active")
	public Date getLastActive() {
		return this.lastActive;
	}

	public void setLastActive(Date lastActive) {
		this.lastActive = lastActive;
	}
	
	
}
