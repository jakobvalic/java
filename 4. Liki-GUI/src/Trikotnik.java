import java.awt.Color;
import java.awt.Graphics;

public class Trikotnik extends Lik {
	private int dx2;
	private int dy2;
	private int dx3;
	private int dy3;
	
	
	
	public Trikotnik(int x, int y, int dx2, int dy2, int dx3, int dy3, Color barva) {
		super(x, y, barva);
		this.dx2 = dx2;
		this.dy2 = dy2;
		this.dx3 = dx3;
		this.dy3 = dy3;
	}


	@Override
	public double ploscina() {
		return 0.5 * (dx2 * dy3 - dx3 * dy2);
	}

	@Override
	public void narisiSe(Graphics g) {
		int [] tabelaX = {x, x + dx2, x + dx3};
		int [] tabelaY = {y, y + dy2, y + dy3};
		
		g.fillPolygon(tabelaX, tabelaY, 3);

	}

}
