package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Benutzer;
import model.Spiel;

public class GameView extends viewSuperclass {

	private static final long serialVersionUID = 1L;
	private JLabel gameName = new JLabel();
	private JLabel gameIcon = new JLabel();

	JFrame sterne = new JFrame("");
	@SuppressWarnings("rawtypes")
	JComboBox combobox;

	public GameView(Benutzer benutzer, Spiel spiel) {
		setTitle("Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMainMenu(benutzer);

		JPanel centerLeftTopPanel = new JPanel(new GridLayout(2, 1));
		gameName.setText(spiel.getBezeichnung());
		centerLeftTopPanel.add(gameName);
		gameIcon.setIcon(loadIcon(spiel.getCover()));
		centerLeftTopPanel.add(gameIcon);

		JPanel centerLeftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		centerLeftPanel.add(centerLeftTopPanel);

		JPanel centerRightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		centerLeftTopPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		centerLeftPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		centerRightPanel.setBorder(BorderFactory.createLineBorder(Color.black));

		JPanel centerPanel = new JPanel(new GridLayout(1, 2));
		centerPanel.add(centerLeftPanel);
		centerPanel.add(centerRightPanel);

		add(centerPanel, BorderLayout.CENTER);
	}
}
