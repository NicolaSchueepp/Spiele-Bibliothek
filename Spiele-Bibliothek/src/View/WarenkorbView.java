package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Benutzer;

public class WarenkorbView extends viewSuperclass {
	
	private static final long serialVersionUID = 1L;
	protected JLabel game1 = new JLabel("Game1");
	protected JLabel game2 = new JLabel("Game2");
	protected JLabel preis1 = new JLabel("Preis1");
	protected JLabel preis2 = new JLabel("Preis2");
	protected JLabel total = new JLabel("Total");
	protected JLabel totalPreis = new JLabel("Total Preis");
	protected JPanel panelMitte = new JPanel(new GridLayout(1,0));
	protected JPanel panelUnten = new JPanel(new GridLayout(1,0));

	public static void main(String[] args) {
		WarenkorbView gui = new WarenkorbView(null);
		gui.setSize(1500, 900);
		gui.setResizable(false);
		gui.setVisible(true);
	}
	
	public WarenkorbView(Benutzer benutzer) {
		setTitle("Warenkorb");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMainMenu(benutzer);
		
		final JPanel listeGame = new JPanel(new FlowLayout(FlowLayout.LEFT, 100, 50));
		listeGame.add(game1);
		listeGame.add(game2);
		
		final JPanel listePreis = new JPanel(new FlowLayout(FlowLayout.RIGHT, 50, 50));
		listePreis.add(preis1);
		listePreis.add(preis2);
		
		final JPanel preis = new JPanel(new GridLayout(1, 2));
		preis.add(total);
		preis.add(totalPreis);
		
		panelMitte.add(listeGame);
		panelMitte.add(listePreis);
		
		panelUnten.add(preis);
		
		add(panelMitte, BorderLayout.CENTER);
		add(panelUnten, BorderLayout.SOUTH);
		
	}

}
