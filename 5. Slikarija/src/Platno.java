import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

/**
 * Področje za risanje črt.
 * 
 * @author andrej
 *
 */
public class Platno extends JPanel implements MouseListener, MouseMotionListener {
	
	/**
	 * Vse zaključene lomljene črte, ki smo jih narisali do zdaj.
	 */
	private List<Lomljenka> vseCrte;
	

	/**
	 * Lomljena črta, ki jo trenutno rišemo ({@code null} če trenutno ne rišemo črte)
	 */
	private Lomljenka trenutnaCrta;
	
	protected Color barva; // do PROTECTED lahko dostopajo vsi iz istega paketa; �e bi bilo PRIVATE, lahko nastavljamo z metodo (setter)
	
	protected int debelina;
	
	private Slikarija slikarija;
	
	
	public Platno(Slikarija slikarija) {
		this.trenutnaCrta = null;
		this.vseCrte = new ArrayList<Lomljenka>();
		this.debelina = 3;
		this.barva = Color.BLUE;
		this.slikarija = slikarija;
		setBackground(Color.white);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public void zbrisiVse() {
		vseCrte = new ArrayList<Lomljenka>();
		repaint();
	}
	
	public void zbrisiEnega() {
		if (vseCrte.size() > 0) {
			vseCrte.remove(vseCrte.size() - 1);
			repaint();			
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Lomljenka l : vseCrte) {
			l.narisi((Graphics2D)g);
		}
		if (trenutnaCrta != null) {
			trenutnaCrta.narisi((Graphics2D)g);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(640, 480);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		slikarija.platno = this;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (trenutnaCrta != null) {
			// Uporabnik je spustil miško, torej smo končali z risnjem črte
			vseCrte.add(trenutnaCrta);
		}
		trenutnaCrta = null;
	}

	@Override
	public void mouseEntered(MouseEvent e) {		
	}

	@Override
	public void mouseExited(MouseEvent e) {		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (trenutnaCrta == null) {
			// nimam trenutne čte, zato jo naredimo
			trenutnaCrta = new Lomljenka(e.getX(), e.getY(), barva, debelina);
		} else {
			// trenutno črto že imamo, zato ji dodamo točko
			trenutnaCrta.dodajTocko(e.getX(), e.getY());
		}
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
}
