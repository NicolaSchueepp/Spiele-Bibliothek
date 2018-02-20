package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HomeView extends viewSuperclass {
	private static final long serialVersionUID = 4724085734802179441L;
	protected JPanel centerPanel = new JPanel(new FlowLayout());
	protected JTextArea textLabel = new JTextArea(10,0);
	
	public static void main(String[] args) {
		HomeView gui = new HomeView();
		gui.setSize(1500, 900);
		gui.setResizable(false);
		gui.setVisible(true);
	}
	
	public HomeView() {
		setTitle("Home");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		printMainMenu();
		
		textLabel.setEditable(false);
		textLabel.setBackground(getBackground());
		textLabel.setText("Lorem ipsum dolor sit amet, consetetur "
				+ "sadipscing elitr, sed diam nonumy eirmod tempor inv"
				+ "idunt ut labore et dolore magna aliquyam erat, sed diam vo"
				+ "luptua. At vero eos et accusam et justo duo dolores e"
				+ "t ea rebum. Stet clita kasd gubergren, no sea takimata "
				+ "sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dol"
				+ "or sit amet, consetetur sadipscing elitr, sed diam nonu"
				+ "my eirmod tempor invidunt ut labore et dolore magna aliquy"
				+ "am erat, sed diam voluptua. At vero eos et accusam et justo "
				+ "duo dolores et ea rebum. Stet clita kasd gubergren, no sea tak"
				+ "imata sanctus est Lorem ipsum dolor sit amet.");
		centerPanel.add(textLabel);
		add(centerPanel, BorderLayout.CENTER);
	}

}

