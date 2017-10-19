import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatFrame extends JFrame implements ActionListener, KeyListener, WindowListener {
	
	private JTextArea output;
	private JTextField input;
	private JTextField inputKomu;
	protected JTextField vzdevek;
	private JPanel vzdevekpanel;
	private JLabel vzdeveknapis;
	private JScrollPane sp;
	private JButton prijavaGumb;
	private JButton odjavaGumb;
	private IzpisovalniRobot robot;
	
	public static String javniVzdevek = System.getProperty("user.name");


	public ChatFrame() {
		super();
		this.setTitle("ChitChat");
		Container pane = this.getContentPane();
		pane.setLayout(new GridBagLayout());
		
		this.vzdevekpanel = new JPanel();
		FlowLayout vzdeveklayout = new FlowLayout(FlowLayout.LEFT);
		vzdevekpanel.setLayout(vzdeveklayout);
		GridBagConstraints vzdevekConstraint = new GridBagConstraints();
		vzdevekConstraint.gridx = 0;
		vzdevekConstraint.gridy = 0;
		vzdevekConstraint.fill = GridBagConstraints.HORIZONTAL;
		pane.add(vzdevekpanel, vzdevekConstraint);
		
		this.vzdeveknapis = new JLabel();
		vzdeveknapis.setText("Vzdevek:");
		vzdevekpanel.add(vzdeveknapis);
		
		this.vzdevek = new JTextField(10);
		this.vzdevek.setText(System.getProperty("user.name"));
		vzdevekpanel.add(vzdevek);
		
		this.prijavaGumb = new JButton("Prijava");
		prijavaGumb.addActionListener(this);
		vzdevekpanel.add(prijavaGumb);
		
		this.odjavaGumb = new JButton("Odjava");
		odjavaGumb.addActionListener(this);
		vzdevekpanel.add(odjavaGumb);

		this.output = new JTextArea(20, 40);
		this.sp = new JScrollPane(output);
		this.output.setEditable(false);
		GridBagConstraints outputConstraint = new GridBagConstraints();
		outputConstraint.gridx = 0;
		outputConstraint.gridy = 1;
		outputConstraint.fill = 1;
		outputConstraint.weightx = 1;
		outputConstraint.weighty = 1;
		pane.add(sp, outputConstraint);
		

		
		this.input = new JTextField(40);
		GridBagConstraints inputConstraint = new GridBagConstraints();
		inputConstraint.gridx = 0;
		inputConstraint.gridy = 2;
		inputConstraint.fill = GridBagConstraints.HORIZONTAL;
		inputConstraint.weightx = 1;
		inputConstraint.weighty = 0;
		pane.add(input, inputConstraint);
		input.addKeyListener(this);
		this.addWindowListener( new WindowAdapter() {
		    public void windowOpened( WindowEvent e ){
		        input.requestFocus();
		    }
		});
		input.setEnabled(true);
		
		this.inputKomu = new JTextField(10);
		GridBagConstraints inputConstraint2 = new GridBagConstraints();
		inputConstraint2.gridx = 1;
		inputConstraint2.gridy = 2;
		inputConstraint2.fill = 1;
		inputConstraint2.weightx = 1;
		inputConstraint2.weighty = 1;
		pane.add(inputKomu, inputConstraint2);
		
		// Naredimo robota za izpisovanje
		this.robot = new IzpisovalniRobot(this);
		robot.activate();
		
	}

	/**
	 * @param person - the person sending the message
	 * @param message - the message content
	 */
	public void addMessage(String person, String message) {
		String chat = output.getText();
		output.setText(chat + person + ": " + message + "\n");
	}
	
	public void posljiStrezniku(String person, String message) throws Exception {
		if (inputKomu.getText() == "") {
			Prenos.posljiVsem(person, message);
		}
		else {
			Prenos.posljiEnemu(person, input.getText(), message);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == prijavaGumb) {
			try {
				Prenos.prijava(vzdevek.getText());
				input.setEnabled(true); // Sedaj lahko tipkamo
				robot.activate();
				
			}
			catch (Exception error){
				System.out.println("Pojavila se je napaka, uporabnik je že prijavljen.");
				System.out.println(error);
			}
		}
		else if (e.getSource() == odjavaGumb) {
			try {
				input.setEnabled(false);
				Prenos.odjava(vzdevek.getText());
				robot.deactivate();
			}
			catch (Exception error){
				System.out.println("Pojavila se je napaka");
				System.out.println(error);
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == input) {
			if (e.getKeyChar() == '\n') {
				if(vzdevek.getText().equals("")){
					vzdevek.setText(System.getProperty("user.name"));
				}
			javniVzdevek = vzdevek.getText();	
			this.addMessage(vzdevek.getText(), input.getText());
			try {
				posljiStrezniku(vzdevek.getText(), input.getText());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			input.setText("");
			}
		}		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		input.setEnabled(false);
		try {
			Prenos.odjava(vzdevek.getText());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		robot.deactivate();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		if (e.getSource() == this) {
			System.out.println("Zapiramo okno. Odjavljamo uporabnika. Ustavimo izpisovalnega robota.");
		}
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("Zapiramo okno.");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("zmanjšali");
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Živjo!");
	}
		
	
	
	
}
