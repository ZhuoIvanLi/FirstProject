package applet;

import java.applet.Applet;
import java.awt.Graphics;

public class AppletDemo extends Applet {
	// public void init() {
	// add(new JLabel("Welcome to Jave", JLabel.CENTER));
	// }

	@Override
	public void paint(Graphics g) {
		g.drawString("Hello applet!", 150, 100);
	}

}
