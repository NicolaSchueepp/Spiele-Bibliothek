package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton home = new JButton("Home");
	private JButton genre = new JButton("Genre");
	private JButton warenkorb = new JButton("Warenkorb");
	private JButton bibliothek = new JButton("Bibliothek");
	private final JTextField search = new JTextField("search", 20);
	private JLabel gameText = new JLabel("GameText");
	private JButton inWarenkorb = new JButton("In den Warenkorb");
	private JButton bewerten = new JButton("Bewertung senden");
	JFrame sterne = new JFrame("");
    @SuppressWarnings("rawtypes")
	JComboBox combobox;
	
	
	public static void main(String[] args) {
		GameView gui = new GameView();
		gui.setSize(1000, 1000);
		gui.setResizable(false);
		gui.setVisible(true);

	}

	public GameView() {
		setTitle("Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		combobox = new JComboBox(new Object[] {"1", "2", "3", "4", "5"});
		
		final JPanel schaltflaeche = new JPanel(new GridLayout(1, 4));
		schaltflaeche.add(home);
		schaltflaeche.add(genre);
		schaltflaeche.add(warenkorb);
		schaltflaeche.add(bibliothek);

		final JPanel suche = new JPanel(new GridLayout(1, 1));
		suche.add(search);

		final JPanel panelOben = new JPanel();
		panelOben.add(schaltflaeche);
		panelOben.add(suche);
		
		final JPanel panelMitte = new JPanel();
		panelMitte.add(gameText);
		
		final JPanel inDenWarenkorb = new JPanel(new GridLayout(1, 1));
		inDenWarenkorb.add(inWarenkorb);
		
		final JPanel bewertung = new JPanel(new GridLayout(1, 2));
		bewertung.add(bewerten);
		bewertung.add(combobox);
		
		
		final JPanel panelUnten = new JPanel();
		panelUnten.add(inDenWarenkorb);
		panelUnten.add(bewertung);
		
		
		add(panelOben, BorderLayout.NORTH);
		add(panelMitte, BorderLayout.CENTER);
		add(panelUnten, BorderLayout.SOUTH);
		
	}
}
