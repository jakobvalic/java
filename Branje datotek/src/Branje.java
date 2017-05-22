import java.io.*;
import java.util.*;


public class Branje {

	public static void main(String[] args) throws IOException {
		Map<String, Integer> besedisce = deloZdatotekami("HisaMarijePomocnice.txt");
		Collection<String> zbirkaBesed = besedisce.keySet();
		for (String kljuc : zbirkaBesed) {
			Integer vrednost = besedisce.get(kljuc);
			System.out.println(kljuc + ": " + vrednost);
		}
		
	}
	
	/**
	 * @param imeVhod, z nje preberemo besede
	 * @return Set mno�ico besed, ki jih ne bomo �teli
	 * @throws IOException
	 */
	public static Set<String> neStejemo(String imeVhod) throws IOException {
		Set<String> besede = new HashSet<String>();
		BufferedReader vhod = new BufferedReader(new FileReader(imeVhod));
		int stevec = 0;
		while (vhod.ready()) {
			String vrstica = vhod.readLine().trim();
			if (vrstica.equals(""))
				continue;
			besede.add(vrstica);
			++stevec;
		}
		vhod.close();
		System.out.println(stevec);
		return besede;
	}

	/**
	 * @param imeVhod ime datoteke, s katere bomo prebrali besede, ki jih �tejemo
	 * @return Map, slovar z besedami in �tevilom ponovitev
	 * @throws IOException
	 */
	public static Map<String, Integer> deloZdatotekami(String imeVhod) throws IOException {
		Set<String> nesteteBesede = neStejemo("nestete_besede.txt");
		BufferedReader vhod = new BufferedReader(new FileReader(imeVhod));
		Integer stevecVseh = 0;
		int stIzkljucenih = 0;
		Map<String, Integer> besedisce = new HashMap<String, Integer>(); // Mora biti objekt, torej int ne pride v po�tev
		while (vhod.ready()) {
			String vrstica = vhod.readLine().trim();
			if (vrstica.equals(""))
				continue;
			String[] besede = vrstica.split(" +"); // " +" odstrani presledke // KAKO ODSTRANITI VEJICE IN PIKE??
			for (String beseda : besede) {
				char zadnjiZnak = beseda.charAt(beseda.length()-1); // Preverimo, ali je treba zadnji znak odstraniti
				if ("?!.,;\"".contains("" + zadnjiZnak)) 
					beseda = beseda.substring(0, beseda.length()-1);
				// �e ni vsebovana v mno�ici besed, ki jih ne �tejemo, jo dodamo v slovar
				if (!nesteteBesede.contains(beseda)) {
					int stevec = 1; // ALI OBSTAJA KAK�NA METODA GET(BESEDA, 0) KOT V .PY?
					if (besedisce.containsKey(beseda))
						++stevec;
					besedisce.put(beseda, stevec);
				} else {
					++stIzkljucenih;
				}
			}
			stevecVseh += besede.length; 
		}
		System.out.println("�tevilo vseh besed: " + stevecVseh);
		System.out.println("�tevilo izklju�enih besed: " + stIzkljucenih);
		System.out.println("Velikost slovarja: " + besedisce.size());
		vhod.close();
		return besedisce;
	}
	
	
}
