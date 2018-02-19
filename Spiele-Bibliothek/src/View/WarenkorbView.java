package View;

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
