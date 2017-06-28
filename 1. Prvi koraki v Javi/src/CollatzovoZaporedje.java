public class CollatzovoZaporedje {
	
	
	/** Funkcija za izraèunanje Collatzovega zaporedja ob zaèetnem pogoju
	 * @param args
	 */
	public static void main (String[] args) {
		Collatzovo(10);
		System.out.println("\nPoskusimo še z daljšim zaporedjem:");
		Collatzovo(400);
		
	}
	
	/** Funkcija za izpisovanje Collatzovega zaporedja
	 * @param zacetek - kje se zaporedje zaène
	 */
	public static void Collatzovo(int zacetek) {
		int najvecji = zacetek;
		int dolzina = 1;
		System.out.println(zacetek);
		int naslednji_clen = zacetek;
		while (naslednji_clen != 1) {
			naslednji_clen = naslednjiClen(naslednji_clen);
			System.out.println(naslednji_clen);
			if (naslednji_clen > najvecji)
				najvecji = naslednji_clen;
			++dolzina;
		}
		System.out.println("najveèji: " + najvecji);
		System.out.println("dolžina: " + dolzina);
	}
	
	
	/**
	 * @param clen - trenutni èlen
	 * @return vrne naslednji èlen
	 */
	public static int naslednjiClen(int clen) {
		if (clen % 2 == 0) 
			return clen / 2;
		else
			return clen * 3 + 1;		
	}
}
