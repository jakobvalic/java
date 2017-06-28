import java.awt.Color;
import java.awt.Graphics;

public abstract class Lik {
	protected int x; // Tudi iz drugih razredov v istem paketu
	protected int y;
	protected Color barva;
	
	
	public Lik(int x, int y, Color barva) {
		super();
		this.x = x;
		this.y = y;
		this.barva = barva;
	}
	
	/**
	 * @param x abcisa referenčne točke
	 * @param y ordinata referenčne točke
	 * barvo nastavimo na rde�o
	 */
	public Lik(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.barva = Color.RED; // Avtomati�no na rde�o barvo
	}
	

	
	public void premakni(int dx, int dy) {
		x += dx;
		y += dy;
	}
	
	public abstract double ploscina();
	
	public void narisiBarvno(Graphics g) {
		g.setColor(barva);
		narisiSe(g);
	}
	
	public abstract void narisiSe(Graphics g);

}
