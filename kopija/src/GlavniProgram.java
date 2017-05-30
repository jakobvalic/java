import java.util.Vector;

import javax.swing.JFrame;

public class GlavniProgram {

	public static void main(String[] args) {
		Vector<Lik> mojiLiki = new Vector<Lik>();
		mojiLiki.add(new Krog(30, 40, 100));
		for (int x = 100; x < 500; x += 40) {
			mojiLiki.add(new Kvadrat(x, 270, 30));
		}
		JFrame okno = new GeoFrame(mojiLiki);
		okno.pack();
		okno.setVisible(true);
	}

}
