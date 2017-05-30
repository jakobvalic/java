import java.awt.Color;
import java.awt.Graphics;

public class Krog extends Lik {
	protected int r;

	/**
	 * @param x - abcisa središča
	 * @param y - ordinata središča
	 * @param r - polmer
	 */
	public Krog(int x, int y, int r, Color barva) {
		super(x, y, barva);
		this.r = r;
	}
	
	public double ploscina() {
		return Math.PI * this.r * this.r;
	}

	@Override
	public String toString() {
		return "Krog [r=" + r + "]";
	}

	@Override
	public void narisiSe(Graphics g) {
		g.fillOval(x - r, y - r, 2 * r, 2 * r);
	}
	
	
}
