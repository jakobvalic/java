import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;

// Geoframe, kot smo ga naredili pri 3. vaji in ga pri 4. nismo veè uporabljali

public class Geoframe_stari_iz_3_vaje_neuporabljen extends JFrame implements ActionListener {
	private Platno platno;
	private JButton gumb;

	public Geoframe_stari_iz_3_vaje_neuporabljen(Vector<Lik> liki) {
		super();
		Container pane = this.getContentPane(); // Podroèje v oknu, kamor dajemo widgete
		pane.setLayout(new GridBagLayout());

		GridBagConstraints gumbLayout = new GridBagConstraints();
		gumbLayout.gridx = 0;
		gumbLayout.gridy = 1;
		this.gumb = new JButton("ZbiriÅ¡i!");
		gumb.addActionListener(this);
		pane.add(this.gumb, gumbLayout);
		
		GridBagConstraints kanvasLayout = new GridBagConstraints();
		kanvasLayout.gridx = 0;
		kanvasLayout.gridy = 0;
		this.platno = new Platno();
		for (Lik l : liki) {
			platno.dodajLik(l);
		}
		pane.add(this.platno, kanvasLayout);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.gumb) {
			System.out.println("Pritisnili ste gumb.");
		}
	}
	
}
