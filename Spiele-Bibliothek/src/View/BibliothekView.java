package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BibliothekView extends JFrame {
	
	private JButton home = new JButton("Home");
	private JButton genre = new JButton("Genre");
	private JButton warenkorb = new JButton("Warenkorb");
	private JButton bibliothek = new JButton("Bibliothek");
	private final JTextField search = new JTextField("search", 20);
	private JButton download = new JButton("Download");
	
	

	public static void main(String[] args) {
		BibliothekView gui = new BibliothekView();
		gui.setSize(1000, 1000);
		gui.pack();
		//gui.setResizable(false);
		gui.setVisible(true);
	}

	public BibliothekView() {
		setTitle("Bibliothek");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		final JPanel loginLabelPanel = new JPanel(new GridLayout(1, 4));
		loginLabelPanel.add(home);
		loginLabelPanel.add(genre);
		loginLabelPanel.add(warenkorb);
		loginLabelPanel.add(bibliothek);
		
		final JPanel loginInputPanel = new JPanel(new GridLayout(1, 1));
		loginInputPanel.add(search);
		
		final JPanel loginPanel = new JPanel();
		loginPanel.add(loginLabelPanel);
		loginPanel.add(loginInputPanel);
		
		add(loginPanel, BorderLayout.CENTER);
		
		final JPanel gameView = new JPanel();
		setLayout(new BoxLayout(gameView, BoxLayout.X_AXIS));
		gameView.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		gameView.add(download);
		add(gameView, BorderLayout.SOUTH);
	}
}
