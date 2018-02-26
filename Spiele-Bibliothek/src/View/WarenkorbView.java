package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Controller.SpielController;
import model.Benutzer;
import model.Spiel;
import model.spieleliste;

public class WarenkorbView extends viewSuperclass {
	
	private static final long serialVersionUID = 1L;
	protected JLabel total = new JLabel("Total Preis");
	protected JButton kaufen = new JButton("Kaufen");
	protected JPanel gamesPanel = new JPanel();
	protected JPanel totalPanel = new JPanel();
	boolean weiterfahren = false;
	
	public WarenkorbView(Benutzer benutzer, List<Spiel> warenkorb) {
		setTitle("Warenkorb");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMainMenu(benutzer, warenkorb);
		gamesPanel.setLayout(new GridLayout(0, 2));
		gamesPanel.setBorder(null);
		totalPanel.setLayout(new BoxLayout(totalPanel, BoxLayout.X_AXIS));
		float totalpreis = 0f;
		
		for (Spiel spiel : warenkorb) {
			JLabel gametext = new JLabel(spiel.getBezeichnung());
			JLabel preistext = new JLabel(Float.toString(spiel.getPreis()));
			
			JPanel gametextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 50, 50));
			JPanel preistextPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 50, 50));
			
			gametext.setBorder(null);
			preistext.setBorder(null);
			
			gametextPanel.add(gametext);
			preistextPanel.add(preistext);
			
			gamesPanel.add(gametextPanel);
			gamesPanel.add(preistextPanel);
			totalpreis += spiel.getPreis();
		}
		JLabel preisText = new JLabel("Totalpreis: "+Float.toString(totalpreis));
		JButton kaufenButton = new JButton("Kaufen");
		kaufenButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("unlikely-arg-type")
			@Override
			public void actionPerformed(ActionEvent e) {
				List<spieleliste> spielelisteList = SpielController.getGameController().getAlleKäufe();
				
				for(Spiel spiel : warenkorb) {
					weiterfahren = false;
					if (spielelisteList.contains(spiel)) {
						JDialog fenster = new JDialog();
						fenster.setLayout(new GridLayout(2, 1,100,0));
						fenster.setSize(1000, 1000);
						
						JLabel text = new JLabel("Das Spiel:"+spiel.getBezeichnung()+"wurde schon gekauft");
						JButton schliessen = new JButton("Schliessen");
						schliessen.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								fenster.setVisible(false);
								weiterfahren = true;
								warenkorb.remove(spiel);
								revalidate();
								repaint();
							}
						});
						
						fenster.add(text, BorderLayout.CENTER);
						fenster.add(schliessen, BorderLayout.SOUTH);
						fenster.pack();
						fenster.setVisible(true);
						fenster.setLocationRelativeTo(null);
					}else if(weiterfahren) {
						continue;
					}else {
						spieleliste spieleliste = new spieleliste();
						spieleliste.setBenutzer_ID(benutzer.getId());
						spieleliste.setGame_ID(spiel.getId());
						SpielController.getGameController().addKauf(spieleliste);
						
						JDialog fenster = new JDialog();
						fenster.setLayout(new GridLayout(2, 1,100,0));
						fenster.setSize(1000, 1000);
						
						JLabel text = new JLabel("Spiel zur Bibliothek hinzugefügt");
						JButton schliessen = new JButton("Schliessen");
						schliessen.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								fenster.setVisible(false);
								weiterfahren = true;
								warenkorb.remove(spiel);
							}
						});
						
						fenster.add(text, BorderLayout.CENTER);
						fenster.add(schliessen, BorderLayout.SOUTH);
						fenster.pack();
						fenster.setVisible(true);
						fenster.setLocationRelativeTo(null);
					}

				}
			}
		});
		
		totalPanel.setLayout(new BoxLayout(totalPanel, BoxLayout.X_AXIS));
		
		JPanel preisTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 50,50));
		JPanel kaufenButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,50,50));
		preisTextPanel.add(preisText);
		kaufenButtonPanel.add(kaufenButton);
		
		totalPanel.add(preisTextPanel);
		totalPanel.add(kaufenButtonPanel);
		
		JScrollPane scrollPane = new JScrollPane(gamesPanel, 
	            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
	            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(null);
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		add(scrollPane, BorderLayout.CENTER);
		add(totalPanel, BorderLayout.SOUTH);
	}

}
