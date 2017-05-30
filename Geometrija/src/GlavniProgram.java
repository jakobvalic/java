import java.awt.Color;
import java.util.Vector;

import javax.swing.JFrame;

public class GlavniProgram {

	public static void main(String[] args) {
		Vector<Lik> mojiLiki = new Vector<Lik>();
		mojiLiki.add(new Krog(30, 40, 100, Color.DARK_GRAY));
		for (int x = 100; x < 500; x += 40) {
			int r = (int) (256 * Math.random());
			int g = (int) (256 * Math.random());
			int b = (int) (256 * Math.random());
			mojiLiki.add(new Kvadrat(x, 270, 30, new Color(r, g, b)));
			mojiLiki.add(new KrozniIzsek(x, 100, 50, 0, 180, new Color(r, g, b)));
		}
		for (int x = 40; x < 500; x += 70) {
			mojiLiki.add(new Trikotnik(x, 20, 70, 40, 100, 140, Color.YELLOW));
		}
		
		Lik [] tabelaLikov = {new Krog(48, 50, 80, Color.GREEN), new Kvadrat(300, 100, 60, Color.BLUE)};
		Skupina s = new Skupina(250, 250, tabelaLikov);
		s.premakni(0, 100);
		mojiLiki.add(s);
		
		JFrame okno = new GeoFrame(mojiLiki);
		okno.pack();
		okno.setVisible(true);
		
		
		
	}

}
