package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WarenkorbView extends HomeView {
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		WarenkorbView gui = new WarenkorbView();
		gui.setSize(1500, 900);
		gui.setResizable(false);
		gui.setVisible(true);
	}
	
	public WarenkorbView() {
		setTitle("Warenkorb");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

//		add(panelMitte, BorderLayout.CENTER);
//		add(panelUnten, BorderLayout.SOUTH);
		
	}

}
