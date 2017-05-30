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
	 * @return Set množico besed, ki jih ne bomo šteli
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
	 * @param imeVhod ime datoteke, s katere bomo prebrali besede, ki jih štejemo
	 * @return Map, slovar z besedami in številom ponovitev
	 * @throws IOException
	 */
	public static Map<String, Integer> deloZdatotekami(String imeVhod) throws IOException {
		Set<String> nesteteBesede = neStejemo("nestete_besede.txt");
		BufferedReader vhod = new BufferedReader(new FileReader(imeVhod));
		Integer stevecVseh = 0;
		int stIzkljucenih = 0;
		Map<String, Integer> besedisce = new HashMap<String, Integer>(); // Mora biti objekt, torej int ne pride v poštev
		while (vhod.ready()) {
			String vrstica = vhod.readLine().trim();
			if (vrstica.equals(""))
				continue;
			StringTokenizer st = new StringTokenizer(vrstica, " ?!.,;\"");
			while (st.hasMoreTokens()) {
				++stevecVseh;
				String beseda = st.nextToken();
				// Èe ni vsebovana v množici besed, ki jih ne štejemo, jo dodamo v slovar
				if (!nesteteBesede.contains(beseda)) {
					Integer vrednost = besedisce.get(beseda);
					if (vrednost == null)
						vrednost = 0;
					besedisce.put(beseda, vrednost);
				} else {
					++stIzkljucenih;
				}
			}
		}
		System.out.println("Število vseh besed: " + stevecVseh);
		System.out.println("Število izkljuèenih besed: " + stIzkljucenih);
		System.out.println("Velikost slovarja: " + besedisce.size());
		vhod.close();
		return besedisce;
	}
	
	
}
