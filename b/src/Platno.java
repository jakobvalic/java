import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;

public class Platno extends JPanel {
	private Vector<Lik> liki;

	public Platno() {
		super();
		this.liki = new Vector<Lik>();
		this.setBackground(Color.white);
	}
	
	public void dodajLik(Lik l) {
		this.liki.add(l);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(640, 480);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.red);
		for (Lik l : this.liki) {
			l.narisiSe(g);
		}
	}

	
	
}
