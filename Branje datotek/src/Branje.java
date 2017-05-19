import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class Branje {

	public static void main(String[] args) throws IOException {
		Map<String, Integer> besedisce = deloZdatotekami("HisaMarijePomocnice.txt");
		System.out.println(besedisce.size());
		Collection<String> zbirkaBesed = besedisce.keySet();
		for (String kljuc : zbirkaBesed) {
			Integer vrednost = besedisce.get(kljuc);
			System.out.println(kljuc + ": " + vrednost);
		}
		
	}

	public static Map deloZdatotekami(String imeVhod) throws IOException {
		BufferedReader vhod = new BufferedReader(new FileReader(imeVhod));
		Integer stevecVseh = 0;
		Map<String, Integer> besedisce = new HashMap<String, Integer>(); // Mora biti objekt, torej int ne pride v poštev
		while (vhod.ready()) {
			String vrstica = vhod.readLine().trim();
			if (vrstica.equals(""))
				continue;
			String[] besede = vrstica.split(" +");
			for (String beseda : besede) {
				Integer stevec = 0;
				if (besedisce.containsKey(beseda))
					stevec += besedisce.get(beseda);
				++stevec;
				besedisce.put(beseda, stevec);
			}
			stevecVseh += besede.length; 
		}
		vhod.close();
		return besedisce;
	}
	
	
}
