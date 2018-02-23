package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Benutzer;
import model.Spiel;

public class WarenkorbView extends viewSuperclass {
	
	private static final long serialVersionUID = 1L;
	protected JLabel game1 = new JLabel("Game1");
	protected JLabel game2 = new JLabel("Game2");
	protected JLabel preis1 = new JLabel("Preis1");
	protected JLabel preis2 = new JLabel("Preis2");
	protected JLabel total = new JLabel("Total Preis");
	protected JButton kaufen = new JButton("Kaufen");
	protected JPanel panelMitteLinks = new JPanel(new FlowLayout(FlowLayout.LEFT, 100, 100));
	protected JPanel panelMitteRechts = new JPanel(new FlowLayout(FlowLayout.RIGHT, 100, 100));
	protected JPanel panelUntenLinks = new JPanel(new FlowLayout(FlowLayout.LEFT, 100, 100));
	protected JPanel panelMitte = new JPanel(new GridLayout(1, 2));
	protected JPanel panelUnten = new JPanel(new GridLayout(1, 2));
	
	
	public WarenkorbView(Benutzer benutzer, List<Spiel> warenkorb) {
		setTitle("Warenkorb");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMainMenu(benutzer, warenkorb);
		
		final JPanel listeGame = new JPanel(new GridLayout(2, 1));
		listeGame.add(game1);
		listeGame.add(game2);
		
		listeGame.setFont(new Font("", 30, 30));
		
		final JPanel listePreis = new JPanel(new GridLayout(2, 1));
		listePreis.add(preis1);
		listePreis.add(preis2);
		
		panelMitteLinks.add(listeGame);
		panelMitteRechts.add(listePreis);
		
		panelMitte.add(panelMitteLinks);
		panelMitte.add(panelMitteRechts);
		
		panelUntenLinks.add(total);
		panelUntenLinks.add(kaufen);
		
		panelUnten.add(panelUntenLinks);
		
		add(panelMitte, BorderLayout.CENTER);
		add(panelUnten, BorderLayout.SOUTH);
		
		System.out.println(warenkorb);
	}

}
