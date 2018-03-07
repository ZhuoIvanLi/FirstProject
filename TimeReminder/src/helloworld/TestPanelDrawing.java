package helloworld;

import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestPanelDrawing extends JFrame {
	private final static int LINE = 1;

	// Create TestPanelDrawing frame constructor to use when a new instance is
	// created
	public TestPanelDrawing() {
		// Add the new Panel to the frame
		// setLayout(new GridLayout(2, 1, 5, 5));
		// add(new NewPanel());
		// add(new CenterMessage());

		StillClock clock = new StillClock();
		// CenterMessage messPanel = new CenterMessage(
		// clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond());

		add(clock);

	}

	public static void main(String[] arg) {
		// Create a frame(a new TestPanelDrawing and set its properties
		TestPanelDrawing frame = new TestPanelDrawing();
		frame.setTitle("TestPanelDrawing");
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

// Create a class extends JPanel to use to draw lines or graphics
class NewPanel extends JPanel {
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(0, 0, 50, 50);
		g.drawString("Banner", 0, 40);

	}
}

class CenterMessage extends JPanel {
	private String message;

	public CenterMessage() {
		this.message = "Welcome to Jave";
	}

	public CenterMessage(String message) {
		this.message = message;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Get font metrics for the current font
		FontMetrics fm = g.getFontMetrics();

		// Find the center location to display
		int stringWidth = fm.stringWidth("Welcom to Java");
		int stringAscent = fm.getAscent();

		// Get the position of the leftmost character in the baseline
		int xCoordinate = getWidth() / 2 - stringWidth / 2;
		int yCoordinate = getHeight() / 2 + stringAscent / 2;

		g.drawString(message, xCoordinate, yCoordinate);

	}
}
