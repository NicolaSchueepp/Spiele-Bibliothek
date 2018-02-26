package model;

import java.awt.BorderLayout;
import java.net.URL;

import javax.swing.JPanel;

public class mediaPlayer extends JPanel {
	private static final long serialVersionUID = 6178208856783276853L;
	
	public mediaPlayer()
    {
        setLayout(new BorderLayout());

        //file you want to play
        URL mediaURL = //Whatever
        //create the media player with the media url
        Player mediaPlayer = Manager.createRealizedPlayer(mediaURL);
        //get components for video and playback controls
        Component video = mediaPlayer.getVisualComponent();
        Component controls = mediaPlayer.getControlPanelComponent();
        add(video,BorderLayout.CENTER);
        add(controls,BorderLayout.SOUTH);
    }
}
