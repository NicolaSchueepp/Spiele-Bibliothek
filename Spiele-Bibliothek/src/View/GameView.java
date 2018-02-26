package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import Controller.SpielController;
import model.Benutzer;
import model.Bewertung;
import model.Spiel;


public class GameView extends viewSuperclass {

	private static final long serialVersionUID = 1L;
	private JLabel gameName = new JLabel();
	private JLabel gameIcon = new JLabel();
	
	JFrame sterne = new JFrame("");

	public GameView(Benutzer benutzer, Spiel spiel, List<Spiel> warenkorb) {
		setTitle("Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMainMenu(benutzer, warenkorb);
		JPanel leftPanel = new JPanel(new GridLayout(2, 1,0,0));
		leftPanel.setAlignmentX(CENTER_ALIGNMENT);
		JPanel leftTopPanel = new JPanel();
		leftTopPanel.setLayout(new BoxLayout(leftTopPanel,BoxLayout.Y_AXIS));
		leftTopPanel.setAlignmentX(CENTER_ALIGNMENT);
		gameName.setText(spiel.getBezeichnung());
		gameName.setFont(new Font("Open Sans", 0, 30));
		leftTopPanel.add(gameName, FlowLayout.LEFT);
		gameIcon.setIcon(loadIcon(spiel.getCover()));
		leftTopPanel.add(gameIcon);
		
		JPanel leftBottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		if(!spiel.getVideo().equals("")) {
			
		}
		
		
		leftPanel.add(leftTopPanel);
		leftPanel.add(leftBottomPanel);

		JPanel rightPanel = new JPanel(new GridLayout(2, 1, 0,0));
		JPanel rightBottomPanel = new JPanel(new BorderLayout());
		JPanel rightBottomTopPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel rightBottomBottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		rightBottomTopPanel.setLayout(new BoxLayout(rightBottomTopPanel, BoxLayout.X_AXIS));
		rightBottomPanel.add(rightBottomTopPanel, BorderLayout.NORTH);
		rightBottomPanel.add(rightBottomBottomPanel, BorderLayout.CENTER);

		JComboBox<Integer> combobox = new JComboBox<Integer>();
		for (int i = 1; i<6; i++) {
			combobox.addItem(i);
		}
		
		JButton bewertungSenden = new JButton("Bewertung Senden");
		JButton addWarenkorb = new JButton("In den Warenkorb");
		bewertungSenden.setFont(new Font("Open Sans", 0, 30));
		addWarenkorb.setFont(new Font("Open Sans", 0, 30));
		
		rightBottomBottomPanel.add(addWarenkorb);
		rightBottomTopPanel.add(bewertungSenden);
		rightBottomTopPanel.add(combobox);
		
		JTextArea spielBeschreibung = new JTextArea();
		spielBeschreibung.setText(spiel.getBeschreibung());
		spielBeschreibung.setBackground(getBackground());
		for (int i = 110; i < spielBeschreibung.getText().length(); i += 110) {
			spielBeschreibung.insert("\n", i);
		}
		spielBeschreibung.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(spielBeschreibung, 
	            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
	            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(null);
		rightPanel.add(scrollPane);
		rightPanel.add(rightBottomPanel);
		
//
//		centerLeftTopPanel.setBorder(BorderFactory.createLineBorder(Color.black));
//		centerLeftPanel.setBorder(BorderFactory.createLineBorder(Color.black));
//		centerRightPanel.setBorder(BorderFactory.createLineBorder(Color.black));

		JPanel centerPanel = new JPanel(new GridLayout(1, 2));
		centerPanel.add(leftPanel);
		centerPanel.add(rightPanel);

		add(centerPanel, BorderLayout.CENTER);
		
		addWarenkorb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(warenkorb.contains(spiel)) {
					JDialog fenster = new JDialog();
					fenster.setLayout(new GridLayout(2, 1,100,0));
					fenster.setSize(1000, 1000);
					
					JLabel text = new JLabel("Spiel ist bereits im Warenkorb");
					JButton schliessen = new JButton("Schliessen");
					schliessen.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							fenster.setVisible(false);
						}
					});
					
					fenster.add(text, BorderLayout.CENTER);
					fenster.add(schliessen, BorderLayout.SOUTH);
					fenster.pack();
					fenster.setVisible(true);
					fenster.setLocationRelativeTo(null);
					
				}else {
					warenkorb.add(spiel);
					
					JDialog fenster = new JDialog();
					fenster.setSize(1000, 1000);
					
					JLabel text = new JLabel("Spiel zum Warenkorb hinzugef�gt...M�chten Sie weiter einkaufen?");
					JButton weiterEinkaufen = new JButton("Weiter einkaufen");
					JButton zumWarenkorb = new JButton("Zum Warenkorb");
					
					weiterEinkaufen.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							ShopView warenkorbView = new ShopView(benutzer, warenkorb, null);
							warenkorbView.setSize(1500, 900);
							warenkorbView.setResizable(false);
							warenkorbView.setVisible(true);
							warenkorbView.setLocation(getLocation());
							fenster.setVisible(false);
							setVisible(false);
						}
					});
					
					zumWarenkorb.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							WarenkorbView warenkorbView = new WarenkorbView(benutzer, warenkorb);
							warenkorbView.setSize(1500, 900);
							warenkorbView.setResizable(false);
							warenkorbView.setVisible(true);
							warenkorbView.setLocation(getLocation());
							fenster.setVisible(false);
							setVisible(false);
						}
					});
					
					JPanel top = new JPanel(new FlowLayout(FlowLayout.CENTER));
					JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 50));
					
					top.add(text);
					bottom.add(weiterEinkaufen);
					bottom.add(zumWarenkorb);
					
					fenster.add(top, BorderLayout.NORTH);
					fenster.add(bottom, BorderLayout.CENTER);
					
					fenster.pack();
					fenster.setVisible(true);
					
					fenster.setLocationRelativeTo(null);
				}
			}
			
		});
		
		bewertungSenden.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean schonvorhanden = false;
				List<Bewertung> bewertungen = SpielController.getGameController().searchAllBewertungenbyID(spiel.getId());
				for (Bewertung bewertung : bewertungen) {
					if(bewertung.getBenutzer_ID() == benutzer.getId()) {
						schonvorhanden = true;
					}
				}
				if(schonvorhanden) {
					JDialog fenster = new JDialog();
					fenster.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 40));
					fenster.setSize(1000, 1000);
					
					JLabel text = new JLabel("Spiel wurde schon bewertet!");
					JButton schliessen = new JButton("Schliessen");
					schliessen.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							fenster.setVisible(false);
						}
					});
					
					fenster.add(text, BorderLayout.CENTER);
					fenster.add(schliessen, BorderLayout.SOUTH);
					fenster.pack();
					fenster.setVisible(true);
					fenster.setLocationRelativeTo(null);
				}else{
					SpielController.getGameController().addBewertung(benutzer, spiel, combobox.getSelectedIndex());
					
					JDialog fenster = new JDialog();
					fenster.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 40));
					fenster.setSize(1000, 1000);
					
					JLabel text = new JLabel("Bewertung gesendet. Danke f�r die Bewertung!");
					JButton schliessen = new JButton("Schliessen");
					schliessen.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							fenster.setVisible(false);
						}
					});
					
					fenster.add(text, BorderLayout.CENTER);
					fenster.add(schliessen, BorderLayout.SOUTH);
					fenster.pack();
					fenster.setVisible(true);
					fenster.setLocationRelativeTo(null);
				}
			}
		});
	}
}
