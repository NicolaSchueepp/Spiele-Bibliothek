package View;

import javax.swing.JFrame;

import model.Benutzer;

public class WarenkorbView extends viewSuperclass {
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		WarenkorbView gui = new WarenkorbView(null);
		gui.setSize(1500, 900);
		gui.setResizable(false);
		gui.setVisible(true);
	}
	
	public WarenkorbView(Benutzer benutzer) {
		setTitle("Warenkorb");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMainMenu(benutzer);

		
	}

}
