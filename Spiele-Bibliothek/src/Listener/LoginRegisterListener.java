package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class LoginRegisterListener implements ActionListener {
	private JTextArea textArea;
	
	public void MyJButtonListener(JTextArea tmpTextArea) {
		this.textArea = tmpTextArea;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("LogIn")) {
			
		}
	}
	
}
