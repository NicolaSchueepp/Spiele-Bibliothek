package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton home = new JButton("Home");
	private JButton genre = new JButton("Genre");
	private JButton warenkorb = new JButton("Warenkorb");
	private JButton bibliothek = new JButton("Bibliothek");
	private final JTextField search = new JTextField("search", 20);
	private final JTextField search = new JTextField("search", 20);

	public static void main(String[] args) {
		GameView gui = new GameView();
		gui.setSize(1000, 1000);
		gui.pack();
		// gui.setResizable(false);
		gui.setVisible(true);

	}

	public GameView() {
		setTitle("Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

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
		
		add(panelOben, BorderLayout.CENTER);
	}
}
