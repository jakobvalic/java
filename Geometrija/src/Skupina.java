import java.awt.Graphics;

public class Skupina extends Lik {
	private Lik[] liki;
	

	/**
	 * @param x - abscisa skupine likov
	 * @param y - ordinata skupine likov
	 * @param liki - seznam likov
	 */
	public Skupina(int x, int y, Lik[] liki) {
		super(x, y, null);
		this.liki = liki;
	}
	
	
	// Premakni Skupino je isti kot premakni posamezen lik

	@Override
	public double ploscina() {
		double vsotaPloscin = 0;
		for (Lik lik : liki) {
			vsotaPloscin += lik.ploscina();
		}
		return vsotaPloscin;
	}

	@Override
	public void narisiSe(Graphics g) {
		// Premaknemo koordinatno izhodišèe
		g.translate(x, y);
		for (Lik lik : liki) {
			lik.narisiBarvno(g);
		}
	}

}
