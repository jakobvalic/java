
public class CollatzovoZaporedje {
	public static void main (String[] args) {
		int zacetek = 10;
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
		System.out.println("najve�ji: " + najvecji);
		System.out.println("dol�ina: " + dolzina);
		
	}

	
	public static int naslednjiClen(int clen) {
		if (clen % 2 == 0) 
			return clen / 2;
		else
			return clen * 3 + 1;		
	}
}
