import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GeoFrame extends JFrame implements ActionListener {
	private Platno platno;
	private JButton gumb;

	public GeoFrame(Vector<Lik> liki) {
		super();
		Container pane = this.getContentPane(); // področje v oknu, kamor dajemo widgete
		pane.setLayout(new GridBagLayout());

		GridBagConstraints gumbLayout = new GridBagConstraints();
		gumbLayout.gridx = 0;
		gumbLayout.gridy = 1;
		this.gumb = new JButton("Zbiriši!");
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
