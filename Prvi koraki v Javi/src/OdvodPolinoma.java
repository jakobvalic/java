
public class OdvodPolinoma {

	public static void main(String[] args) {
		int[] sez = odvod(new int[] {4, -1, 2, 0, 1}, 3);
		
		
		// for (int i = 0; i < sez.length; ++i) {
		//	int koef = sez[i];
		//	System.out.print(koef + " ");
		//}
		// for (int stevilo : sez) { // Druga možnost za izpis števil v seznamu
		// 	System.out.print(stevilo + " ");
		// }
			
	}

	public static int[] odvod(int[] sezKoef) {
		return odvod(sezKoef, 1);
	}
	
	
	public static int[] odvod(int[] sezKoef, int stopnja) {
		for (int odvod = 1; odvod <= stopnja; ++odvod) {
			int[] noviKoef = new int[noviKoef.length - 1];
			int i = 1;
			int eksponent = 1;
			while (i < noviKoef.length) {
				int koeficient = sezKoef[i];
				// Odvajamo trenutni koeficient
				noviKoef[i-1] = koeficient * (eksponent - 1);
				++eksponent;
				++i;
			}
			System.out.print(odvod + ". odvod: ");
			for (int stevilo : noviKoef)
				System.out.print(stevilo + " ");
				
			System.out.println();
		}
		return noviKoef;
	}
}
