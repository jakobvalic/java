
public class PoudarjanjeZnakov {

	public static void main(String[] args) {
		poudariVse("banana");
		poudariVse("Zadnja novica");
		poudariNekatere("Zadnja *novica* danes, ampak *zares* zandnja!");
	}
	
	public static void poudariVse(String niz) {
		String s = "";
		for (int i = 0; i < niz.length(); ++i) {
			if (i > 0) s += " "; // Na zaèetku ne dodamo
			char znak = niz.charAt(i);
			char velika = Character.toUpperCase(znak);
			s += velika;			
		}
		System.out.println(s);
	}
	
	public static void poudariNekatere(String niz) {
		String s = "";
		boolean vecajmo = false;
		for (int i = 0; i < niz.length(); ++i) {
			char znak = niz.charAt(i);
			if (znak == '*') 
				vecajmo = !vecajmo;
			else if (vecajmo)
				s+= Character.toUpperCase(znak);
			else
				s += znak;
		}
		System.out.println(s);
	}

}
