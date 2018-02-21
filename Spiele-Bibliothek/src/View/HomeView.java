package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import Controller.SpielController;
import model.Benutzer;
import model.Spiel;

public class HomeView extends viewSuperclass {
	private static final long serialVersionUID = 4724085734802179441L;
	protected JPanel centerPanel = new JPanel(new GridLayout(2,1));
	protected JTextArea textArea = new JTextArea(5,10);
	
	public static void main(String[] args) {
		HomeView gui = new HomeView(null);
		gui.setSize(1500, 900);
		gui.setResizable(false);
		gui.setVisible(true);
	}
	
	public HomeView(Benutzer benutzer) {
		setTitle("Home");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMainMenu(benutzer);
		textArea.setEditable(false);
		textArea.setBackground(getBackground());
		textArea.setText("Lorem ipsum dolor sit amet, consetetur "
				+ "sadipscing elitr, sed diam nonumy eirmod tempor inv"
				+ "idunt ut labore et dolore magna aliquyam erat, sed diam vo"
				+ "luptua. At vero eos et accusam et justo duo dolores e"
				+ "t ea rebum. Stet clita kasd gubergren, no sea takimata "
				+ "sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dol"
				+ "or sit amet, consetetur sadipscing elitr, sed diam nonu"
				+ "my eirmod tempor invidunt ut labore et dolore magna aliquy"
				+ "am erat, sed diam voluptua. At vero eos et accusam et justo "
				+ "duo dolores et ea rebum. Stet clita kasd gubergren, no sea tak"
				+ "imata sanctus est Lorem ipsum dolor sit amet.Lorem"
				+ " ipsum dolor sit amet, consetetur sadipscing elitr"
				+ ", sed diam nonumy eirmod tempor invidunt ut labore"
				+ " et dolore magna aliquyam erat, sed diam voluptua. "
				+ "At vero eos et accusam et justo duo dolores et ea r"
				+ "bum. Stet clita kasd gubergren, no sea takimata sanctus"
				+ " est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit "
				+ "amet, consetetur sadipscing elitr, sed diam nonumy eirm"
				+ "od tempor invidunt ut labore et dolore magna aliquyam era"
				+ "t, sed diam voluptua. At vero eos et accusam et justo duo"
				+ " dolores et ea rebum. Stet clita kasd gubergren, no se"
				+ "a takimata sanctus est Lorem ipsum dolor sit amet.");
		for(int i = 150; i<textArea.getText().length();i+=150) {
			textArea.insert("\n", i);
		}
		
		JPanel centerNorthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		centerNorthPanel.add(textArea);
		
		JPanel centerSouthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,80));
		JLabel topSpieleLabel = new JLabel("Top Spiele");
		centerSouthPanel.add(topSpieleLabel);
		topSpieleLabel.setFont(new Font("TopGames", 30, 30));
		
		centerPanel.add(centerNorthPanel);
		centerPanel.add(centerSouthPanel);
		
		JPanel topGamesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40,80));
		List<Spiel> topGames = SpielController.getGameController().searchTopGames();
		
		for (Spiel spiel : topGames) {
			
			JButton button = new JButton(loadIcon(spiel.getCover()));
			topGamesPanel.add(button);
			button.setBorder(null);
			button.setBackground(getBackground());
			
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {
					setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			});
			
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					GameView game = new GameView(benutzer, spiel);
					game.setSize(1500,900);
					game.setResizable(false);
					game.setVisible(true);
					setVisible(false);
				}
			});
		}
		
		add(centerPanel, BorderLayout.CENTER);
		add(topGamesPanel, BorderLayout.SOUTH);
		
	}

}

