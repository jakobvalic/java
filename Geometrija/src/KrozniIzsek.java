import java.awt.Color;
import java.awt.Graphics;

public class KrozniIzsek extends Krog {
	private int alpha;
	private int beta;
	
	
	
	/**
	 * @param x - x sredisca
	 * @param y - y sredisca
	 * @param r - polmer
	 * @param alpha - odmik od 0
	 * @param beta - odmik od alpha do konca
	 * @param barva
	 */
	public KrozniIzsek(int x, int y, int r, int alpha, int beta, Color barva) {
		super(x, y, r, barva);
		this.alpha = alpha;
		this.beta = beta;
	}


	@Override
	public double ploscina() {
		return beta / 360.0 * super.ploscina(); // Realno deljenje, zato 360.0
	}

	@Override
	public void narisiSe(Graphics g) {
		g.fillArc(x, y, r, r, alpha, beta);

	}

}
