import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JToolBar;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.*;

/**
 * Preprost program za risanje slikic.
 * 
 * @author andrej
 *
 */
public class Slikarija extends JFrame implements ActionListener, ChangeListener {
	private JButton zbrisiGumb;
	private JButton zbrisiEnegaGumb;
	private JButton barvaGumb;
	private JSpinner spin;
	protected Platno platno;
	private Platno platno1;
	private Platno platno2;

	

	public Slikarija() {
		getContentPane().setLayout(new GridBagLayout());
		
		// podroƒçje za risanje
		platno1 = new Platno(this);

		
		// podroƒçje za risanje
		platno2 = new Platno(this);

		// Orodna vrstica
		FlowLayout flowl = new FlowLayout();
		flowl.setHgap(40);
		
		JToolBar toolBar = new JToolBar();
		// toolBar.setMargin(new Insets(12, 12, 120, 120));
		toolBar.setLayout(flowl);
		GridBagConstraints barConstraint = new GridBagConstraints();
		barConstraint.gridx = 0;
		barConstraint.gridy = 0;
		barConstraint.weightx = 1; // se razteguje vodoravno
		barConstraint.anchor = GridBagConstraints.WEST; // je na levi strani
		getContentPane().add(toolBar, barConstraint);

		//Create a split pane with the two scroll panes in it.
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
		                           platno1, platno2);
		GridBagConstraints platnoConstraint = new GridBagConstraints();
		platnoConstraint.gridx = 0;
		platnoConstraint.gridy = 1;
		platnoConstraint.fill = GridBagConstraints.BOTH; // se razteguje v vse smeri
		platnoConstraint.weightx = 1; // zavzame ves prostor vodoravno
		platnoConstraint.weighty = 1; // zavzame ves prostor navpiƒçno
		getContentPane().add(splitPane, platnoConstraint);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(150);

		//Provide minimum sizes for the two components in the split pane
		Dimension minimumSize = new Dimension(100, 50);
		platno1.setMinimumSize(minimumSize);
		platno2.setMinimumSize(minimumSize);
		
		platno = platno1;
		
		
		// gumb za brisanje
		zbrisiGumb = new JButton("Zbriöi");
		zbrisiGumb.addActionListener(this);
		toolBar.add(zbrisiGumb);
		
		// gumb za brisanje enega
		zbrisiEnegaGumb = new JButton("Zbriöi enega");
		zbrisiEnegaGumb.addActionListener(this);
		toolBar.add(zbrisiEnegaGumb);
		

		// gumba za izbiranje barve
		barvaGumb = new JButton("Barva");
		barvaGumb.setOpaque(true); // da se bo videlo barvo gumba
		barvaGumb.setBorderPainted(false); // da se bo dejansko pobarvalo ozadje
		barvaGumb.addActionListener(this);
		toolBar.add(barvaGumb);
		pobarvajBarvaGumb(platno.barva);
		
		// Napis za izbirnik debeline
		JLabel debelinaLabel = new JLabel("Debelina: ");
		toolBar.add(debelinaLabel);
		
		// Izbirnik debeline
		SpinnerModel model = new SpinnerNumberModel(3, 1, 20, 1);
		spin = new JSpinner(model); // NAROBE: JSpinner spin
		spin.addChangeListener(this); // This je potreben
		toolBar.add(spin);
				

	}

	/**
	 * Nastavi ozadje gumba na podano barvo
	 * in barvo besedila na njej komplementarno barvo.
	 */
	/**
	 * @param barva barva ozadja
	 */
	private void pobarvajBarvaGumb(Color barva) {
		Color komplementarna =
				new Color(255 - barva.getRed(),
						  255 - barva.getGreen(),
						  255 - barva.getBlue());
		barvaGumb.setForeground(komplementarna);
		barvaGumb.setBackground(barva);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == zbrisiGumb) {
			platno.zbrisiVse();
			System.out.println("ZBRIäI SLIKO");
		} else if (e.getSource() == zbrisiEnegaGumb) {
			platno.zbrisiEnega();
		} else if (e.getSource() == barvaGumb) {
			Color izbranaBarva = JColorChooser.showDialog(this, "Barva Ërte", platno.barva);
			if (izbranaBarva != null) { 
				pobarvajBarvaGumb(izbranaBarva);
				platno.barva = izbranaBarva; // Nastavimo barvo
			}
		}

	}

	public static void main(String args[]) {
		Slikarija okno = new Slikarija();
		okno.pack();
		okno.setVisible(true);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == spin) {
			int debelina = (Integer)spin.getValue(); // getValue vrne objekt, ki ga pretvorimo v Integer
			platno.debelina = debelina;
		}
	}
}
