package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import model.Benutzer;
import model.Spiel;

public class WarenkorbView extends viewSuperclass {
	
	private static final long serialVersionUID = 1L;
	protected JLabel total = new JLabel("Total Preis");
	protected JButton kaufen = new JButton("Kaufen");
	protected JPanel gamesPanel = new JPanel(new GridLayout(0,1));
	protected JPanel totalPanel = new JPanel();
	
	
	public WarenkorbView(Benutzer benutzer, List<Spiel> warenkorb) {
		setTitle("Warenkorb");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMainMenu(benutzer, warenkorb);
		float totalpreis = 0f;
		
		for (Spiel spiel : warenkorb) {
			JPanel spieltmp = new JPanel();
			spieltmp.setLayout(new BoxLayout(spieltmp, BoxLayout.X_AXIS));
			
			JLabel gametext = new JLabel(spiel.getBezeichnung());
			JLabel preistext = new JLabel(Float.toString(spiel.getPreis()));
			
			gametext.setBorder(BorderFactory.createLineBorder(Color.black));
			preistext.setBorder(BorderFactory.createLineBorder(Color.black));
			
			spieltmp.add(gametext);
			spieltmp.add(preistext);
			
			gamesPanel.add(spieltmp);
			totalpreis += spiel.getPreis();
		}
		JLabel preisText = new JLabel("Totalpreis: "+Float.toString(totalpreis));
		JButton kaufenButton = new JButton("Kaufen");
		
		totalPanel.setLayout(new BoxLayout(totalPanel, BoxLayout.X_AXIS));
		totalPanel.add(preisText);
		totalPanel.add(kaufenButton);
		
		JScrollPane scrollPane = new JScrollPane(gamesPanel, 
	            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
	            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		add(scrollPane, BorderLayout.CENTER);
		add(totalPanel, BorderLayout.SOUTH);
	}

}
