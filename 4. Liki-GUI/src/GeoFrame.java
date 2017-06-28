import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GeoFrame extends JFrame implements ActionListener {
	private Platno platno;
	private JButton gumbZbrisiVse;
	private JButton gumbZbrisiEnega;
	private JButton gumbRazveljaviBrisanje;
	private JButton gumbShrani;
	
	private JMenuItem menuIzhod; // Ker ga rabimo tudi pri action performed
	private JMenuItem menuKvadrat;
	private JMenuItem menuKrog;
	private JMenuItem menuTrikotnik;

	public GeoFrame(Vector<Lik> liki) {
		super();
		setTitle("Liki");
		Container pane = this.getContentPane(); // Podroèje v oknu, kamor dajemo widgete
		pane.setLayout(new GridBagLayout());
		
		// Menu
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		JMenu menuDatoteka = new JMenu("Datoteka");
		menubar.add(menuDatoteka);
		menuIzhod = new JMenuItem("Izhod");
		menuIzhod.addActionListener(this); // Posluša cel objekt
		menuDatoteka.add(menuIzhod);
		
		JMenu menuLiki = new JMenu("Nariši like");
		menubar.add(menuLiki);
		menuKvadrat = new JMenuItem("Kvadrat");
		menuKvadrat.addActionListener(this);
		menuLiki.add(menuKvadrat);
		
		menuKrog = new JMenuItem("Krog");
		menuKrog.addActionListener(this);
		menuLiki.add(menuKrog);
		
		menuTrikotnik = new JMenuItem("Trikotnik");
		menuTrikotnik.addActionListener(this);
		menuLiki.add(menuTrikotnik);
		
		

		// Platno
		GridBagConstraints kanvasLayout = new GridBagConstraints();
		// kanvasLayout.gridwidth = 2; // Platno sega èez 2 stolpca
		kanvasLayout.gridx = 0;
		kanvasLayout.gridy = 0;
		this.platno = new Platno();
		for (Lik l : liki) {
			platno.dodajLik(l);
		}
		pane.add(platno, kanvasLayout);
		
		// Panel, v katerega damo gumbe
		GridBagConstraints panelLayout = new GridBagConstraints();
		panelLayout.gridx = 0;
		panelLayout.gridy = 1;
		JPanel oknoZaGumba = new JPanel();
		oknoZaGumba.setLayout(new FlowLayout()); // Jih dodaja po vrsti, jih centrira
		pane.add(oknoZaGumba, panelLayout);
		
		
		// GridBagConstraints gumbLayout = new GridBagConstraints(); // TO SMO IMELI, PREDEN SMO DALI GUMBE V JPANEL
		// gumbLayout.gridx = 0;
		// gumbLayout.gridy = 1;
		
		// Gumbi
		this.gumbZbrisiVse = new JButton("Zbriši vse!");
		gumbZbrisiVse.addActionListener(this);
		oknoZaGumba.add(this.gumbZbrisiVse);
		
		this.gumbZbrisiEnega = new JButton("Zbriši enega!");
		gumbZbrisiEnega.addActionListener(this);
		oknoZaGumba.add(this.gumbZbrisiEnega);
		
		this.gumbRazveljaviBrisanje = new JButton("Razveljavi brisanje");
		gumbRazveljaviBrisanje.addActionListener(this);
		oknoZaGumba.add(gumbRazveljaviBrisanje);
		
		this.gumbShrani = new JButton("Shrani");
		gumbShrani.addActionListener(this);
		oknoZaGumba.add(gumbShrani);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == gumbZbrisiVse) {
			System.out.println("Pritisnili ste gumb.");
			platno.pobrisiVse();
		}
		else if (e.getSource() == gumbZbrisiEnega) {
			platno.pobrisiEnega();
		}
		else if (e.getSource() == gumbRazveljaviBrisanje) {
			platno.razveljaviBrisanje();
		}
		else if (e.getSource() == menuIzhod) {
			System.exit(0);
		}
		else if (e.getSource() == gumbShrani) { // Morda raje gumb namesto menija
			try {
				// Dialog za delo z datotekami
				JFileChooser chooser = new JFileChooser();
				int rezultat = chooser.showSaveDialog(this); // Parameter je okno, s katerega odpiramo
				// Rezultat je naèin, kako smo zaprli dialog
				if (rezultat == JFileChooser.APPROVE_OPTION) {
					// V pomnolniku naredimo to, kar nam bo predstavljalo datoteko; kar je uporabnik izbral
					File file = chooser.getSelectedFile();
					platno.shraniSliko(file.getAbsolutePath());
				}
			} catch (IOException e1) {
				System.out.println("Zgodila se je napaka");
			}
		}
		else {
			int x = (int) (platno.getWidth() * Math.random());
			int y = (int) (platno.getHeight() * Math.random());
			
			if (e.getSource() == menuKvadrat) {
				int a = (int) (100 * Math.random());
				platno.dodajLik(new Kvadrat(x, y, a, Color.GREEN));
			if (e.getSource() == menuTrikotnik) {
				System.out.println("Manjka");
			}
			if (e.getSource() == menuKrog) {
				System.out.println("Manjka");
			}
				
		}
			

			
		}
	}
	
}
