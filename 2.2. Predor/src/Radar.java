import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Radar {

	public static void main(String[] args) throws IOException {
		System.out.println("�tevilo prekr�kov: " + prekrski("predor.txt", "kazni.txt").toString());
	}
	
	public static Integer prekrski(String imeVhod, String imeIzhod) throws IOException {
		Integer stevec_prekrskov = 0; 
		// Definiramo zapis na 2 decimalki natan�no
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator('.');
		DecimalFormat df = new DecimalFormat("0.00", symbols);
		df.setRoundingMode(RoundingMode.HALF_UP);
		// Beremo iz ene datoteke, pi�emo prekr�ke v drugo
		BufferedReader vhod = new BufferedReader(new FileReader(imeVhod));
		PrintWriter izhod = new PrintWriter(new FileWriter(imeIzhod));
		while (vhod.ready()) {
			String vrstica = vhod.readLine().trim();
			if (vrstica.equals(""))
				continue;
			String[] besede = vrstica.split(" +"); // Deluje tudi na ve� presledkih
			int vstopil = Integer.parseInt(besede[0]);
			int izstopil = Integer.parseInt(besede[1]);
			int cas_v_predoru = izstopil - vstopil;
			double dovoljena_hitrost = 80 / 3.6; // V m/s
			double hitrost = 622.0 / cas_v_predoru; // �e bi dali 622, bi bilo to celo�tevilsko deljenje !!!
			if (hitrost > dovoljena_hitrost) {
				izhod.println(besede[2] + " je vozil " + df.format(hitrost * 3.6) + " km/h");
				++stevec_prekrskov;
			}
		}
		
		
		vhod.close();
		izhod.close();
		return stevec_prekrskov;
	}

}
