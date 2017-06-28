public class Datum {
	private int dan;
	private int mesec;
	private int leto;


	public Datum(int dan, int mesec, int leto) {
		this.dan = dan;
		this.mesec = mesec;
		this.leto = leto;
	}
	

	/**
	 * @return true, èe je prestopno, false sicer
	 */
	public boolean je_prestopno(){
		if (leto % 100 == 0 && leto % 400 != 0) {
			return false;
		}
		if (leto % 4 == 0) 
			return true;
		return false;
	}
	
	/**
	 * @return število dni v (@code mesec) 
	 */
	public int stevilo_dni() {
		int feb = 28;
		if (je_prestopno())
			feb = 29;
		int[] dnevi = {31, feb, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		return dnevi[mesec - 1];
	}

	public boolean jeVeljaven() {
		if (1 <= dan <= stevilo_dni() && 1 <= mesec <= 12)
			return true;
		return false;
		
	}
	
}