
public class Glavni_program {
	
	
	public static void main (String[] args) {
		Datum d = new Datum(20, 12, 2017);
		Datum d2 = new Datum(1, 2, 2000);
		System.out.println(d.je_prestopno());
		System.out.println(d.stevilo_dni());
		System.out.println(d2.je_prestopno());
		System.out.println(d2.stevilo_dni());
	}

}
