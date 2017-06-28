import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

/**
 * Lomljena čta v ravnini.
 * 
 * @author andrej
 *
 */
public class Lomljenka {
	private Path2D lomljenka;
	private Color barva;
	private int debelina;

	/**
	 * Nova lomljena crta z danima začetnima koordinatama.
	 * @param x
	 * @param y
	 */
	public Lomljenka(int x, int y, Color barva, int debelina) {
		this.lomljenka = new Path2D.Float();
		this.lomljenka.moveTo(x, y);
		this.barva = barva;
		this.debelina = debelina;
	}
	
	/**
	 * Lomljeni črti dodaj še eno točko.
	 * 
	 * @param x
	 * @param y
	 */
	public void dodajTocko(int x, int y) {
		lomljenka.lineTo(x, y);
	}

	/**
	 * Nariši lomljeno črto v dani grafični kontekst.
	 * 
	 * @param g
	 */
	public void narisi(Graphics2D g) {
		g.setStroke(new BasicStroke(debelina));
		g.setColor(barva);
		g.draw(lomljenka);
	}
}
