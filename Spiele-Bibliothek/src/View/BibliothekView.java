package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import model.Benutzer;

public class BibliothekView extends viewSuperclass {

	private static final long serialVersionUID = 1L;
	private JButton download = new JButton("Download");
	private JButton download2 = new JButton("Download");
	private JPanel cod = new JPanel(loadIcon("callOfDutyWWII.jpg"));
	private JLabel assasinsCreed = new JLabel(loadIcon("assassinsCreedOrigins.jpg"));
	private JLabel assasinsCreedText = new JLabel("TEXT");
	private JLabel codText = new JLabel("TEXT2");

	public BibliothekView(Benutzer benutzer) {
		setTitle("Bibliothek");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMainMenu(benutzer);
	
		final JPanel images = new JPanel(new GridLayout(1, 1));
		images.add(cod);
		images.add(assasinsCreed);
		
		
		final JPanel downloads = new JPanel(new GridLayout(1, 1));
		downloads.add(download);
		downloads.add(download2);
		
		add(images, BorderLayout.CENTER);
		add(downloads, BorderLayout.SOUTH);
		
		cod.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        cod.setBackground(Color.GREEN);
		    }
		    
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        cod.setBackground(UIManager.getColor("control"));
		    }
		});

		
		
	}
}
