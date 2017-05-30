import java.awt.Graphics;

public class Kvadrat extends Lik {
	private int a;

	public int getA() {
		return a;
	}

	/**
	 * @param x - abcisa spodnjega levega vozlišča
	 * @param y - ordinata spodnjega levega vozlišča
	 * @param a - velikost stranice
	 */
	public Kvadrat(int x, int y, int a) {
		super(x, y);
		this.a = a;
	}

	@Override
	public double ploscina() {
		return a * a;
	}

	@Override
	public String toString() {
		return "Kvadrat [a=" + a + "]";
	}

	@Override
	public void narisiSe(Graphics g) {
		g.fillRect(x, y, a, a);	
	}

}
