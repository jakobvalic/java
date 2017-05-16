import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Branje {

	public static void main(String[] args) throws IOException {
		System.out.println(deloZdatotekami("akcija.py"));
		
	}

	public static int deloZdatotekami(String imeVhod) throws IOException {
		BufferedReader vhod = new BufferedReader(new FileReader(imeVhod));
		int stevec = 0;
		while (vhod.ready()) {
			String vrstica = vhod.readLine().trim();
			if (vrstica.equals(""))
				continue;
			String[] besede = vrstica.split(" +");
			stevec += besede.length; 
		}
		vhod.close();
		return stevec;
	}
	
	public static int
	
}
