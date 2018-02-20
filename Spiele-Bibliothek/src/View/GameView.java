package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameView extends viewSuperclass {

	private static final long serialVersionUID = 1L;
	protected JLabel gameText = new JLabel("GameText");
	protected static JLabel video = new JLabel("Video");
	protected JButton inWarenkorb = new JButton("In den Warenkorb");
	protected JButton bewerten = new JButton("Bewertung senden");
	protected JPanel panelMitte = new JPanel(new GridLayout(1, 0));
	protected JPanel panelUnten = new JPanel(new GridLayout(1, 0));
	
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
		printMainMenu();

		
		combobox = new JComboBox(new Object[] {"1", "2", "3", "4", "5"});
		
		final JPanel panelMitteLinks = new JPanel(new FlowLayout(FlowLayout.LEFT, 60, 100));
		panelMitteLinks.add(gameText);
		
		final JPanel panelMitteRechts = new JPanel(new FlowLayout(FlowLayout.RIGHT, 600, 100));
		panelMitteRechts.add(video);
		
		final JPanel inDenWarenkorb = new JPanel(new FlowLayout(FlowLayout.LEFT, 60, 100));
		inDenWarenkorb.add(inWarenkorb);
		
		final JPanel bewertung = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 100));
		bewertung.add(bewerten);
		
		final JPanel sterne = new JPanel(new FlowLayout(FlowLayout.RIGHT, 460, 100));
		sterne.add(combobox);
		
		
		panelMitte.add(panelMitteLinks);
		panelMitte.add(panelMitteRechts);
		
		panelUnten.add(inDenWarenkorb);
		panelUnten.add(bewertung);
		panelUnten.add(sterne);
		
		add(panelMitte, BorderLayout.CENTER);
		add(panelUnten, BorderLayout.SOUTH);
		
	}
}
