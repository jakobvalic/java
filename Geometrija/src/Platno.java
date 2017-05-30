import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Platno extends JPanel {
	private Vector<Lik> liki;
	private Vector<Lik> pobrisaniLiki;

	public Platno() {
		super();
		this.liki = new Vector<Lik>();
		this.setBackground(Color.white);
		this.pobrisaniLiki = new Vector<Lik>();
	}
	
	public void dodajLik(Lik l) {
		this.liki.add(l);
		repaint();
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(640, 480);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // Gre z zanko �ez vektor likov in vsakega nari�e
		g.setColor(Color.red);
		for (Lik l : this.liki) {
			l.narisiBarvno(g);
		}
	}
	
	public void pobrisiVse() {
		pobrisaniLiki = liki;
		liki = new Vector<Lik>();
		repaint(); // Na novo nari�e vse like
	}
	
	public void pobrisiEnega() {
		if (!liki.isEmpty()) {
			Lik pobrisanLik = liki.remove(liki.size() - 1);
			pobrisaniLiki.add(pobrisanLik);
			repaint();		
		}
	}
	
	public void razveljaviBrisanje() {
		System.out.println("manjka");
		if (!pobrisaniLiki.isEmpty()) {
			liki.add(pobrisaniLiki.remove(pobrisaniLiki.size() - 1));
			repaint();
		}
	}
	
	public void shraniSliko(String filename) throws IOException{
		// Sliko iz platna shranimo v pomo�no sliko v pomnilnik
		BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB); // A je za plast prosojnosti
		// Preri�emo sliko iz platna v pomnilnik
		paint(image.getGraphics()); // Nari�e samo sliko na platnu brez komponent
		// Nato iz pomnilnika shranimo v datoteko
		ImageIO.write(image, "PNG", new File(filename));
	}
	

	
	
}
