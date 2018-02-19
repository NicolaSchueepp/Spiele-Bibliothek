package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameView extends HomeView {

	private static final long serialVersionUID = 1L;
	private JLabel gameText = new JLabel("GameText");
	protected static JLabel video = new JLabel("Video");
	private JButton inWarenkorb = new JButton("In den Warenkorb");
	private JButton bewerten = new JButton("Bewertung senden");
	JFrame sterne = new JFrame("");
    @SuppressWarnings("rawtypes")
	JComboBox combobox;
	
	
	public static void main(String[] args) {
		GameView gui = new GameView();
		gui.setSize(1500, 900);
		gui.setResizable(false);
		gui.setVisible(true);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GameView() {
		setTitle("Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		combobox = new JComboBox(new Object[] {"1", "2", "3", "4", "5"});
		
		final JPanel panelMitteLinks = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelMitteLinks.add(gameText);
		
		final JPanel panelMitteRechts = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelMitteRechts.add(video);
		
		final JPanel inDenWarenkorb = new JPanel(new GridLayout(1, 1));
		inDenWarenkorb.add(inWarenkorb);
		
		final JPanel bewertung = new JPanel(new GridLayout(1, 2));
		bewertung.add(bewerten);
		bewertung.add(combobox);
		
		
		final JPanel panelUnten = new JPanel();
		panelUnten.add(inDenWarenkorb);
		panelUnten.add(bewertung);
		
		add(panelMitteLinks, BorderLayout.CENTER);
		add(panelMitteRechts, BorderLayout.CENTER);
		add(panelUnten, BorderLayout.SOUTH);
		
	}
}
