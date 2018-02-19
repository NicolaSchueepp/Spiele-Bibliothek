package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WarenkorbView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	protected static JButton home = new JButton("Home");
	protected static JButton genre = new JButton("Genre");
	protected static JButton warenkorb = new JButton("Warenkorb");
	protected static JButton bibliothek = new JButton("Bibliothek");
	private final JTextField search = new JTextField("search", 20);

	public static void main(String[] args) {
		WarenkorbView gui = new WarenkorbView();
		gui.setSize(1000, 1000);
		gui.pack();
		gui.setResizable(false);
		gui.setVisible(true);
		
//		Home
		home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Home")) {
					HomeView home = new HomeView();
					home.setSize(1000, 1000);
					home.pack();
					home.setVisible(true);
					gui.setVisible(false);
				}
			}
			
		});
		
//		Genre
		genre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Warenkorb")) {
					GenreView genre = new GenreView();
					genre.setSize(1000, 1000);
					genre.pack();
					genre.setVisible(true);
					gui.setVisible(false);
				}
			}
			
		});
		
		
//		Bibliothek
		bibliothek.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Bibliothek")) {
					BibliothekView bibliothek = new BibliothekView();
					bibliothek.setSize(1000, 1000);
					bibliothek.pack();
					bibliothek.setVisible(true);
					gui.setVisible(false);
				}
			}
			
		});

	}
	
	public WarenkorbView() {
		setTitle("Warenkorb");
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
		
		
		add(panelOben, BorderLayout.NORTH);
//		add(panelMitte, BorderLayout.CENTER);
//		add(panelUnten, BorderLayout.SOUTH);
		
	}

}
