import java.awt.Graphics;

public abstract class Lik {
	protected int x;
	protected int y;
	
	/**
	 * @param x abcisa referenčne točke
	 * @param y ordinata referenčne točke
	 */
	public Lik(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public void premakni(int dx, int dy) {
		x += dx;
		y += dy;
	}
	
	public abstract double ploscina();
	
	public abstract void narisiSe(Graphics g);

}
