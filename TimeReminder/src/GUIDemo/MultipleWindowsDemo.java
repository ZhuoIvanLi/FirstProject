package GUIDemo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MultipleWindowsDemo extends JFrame {
	private JTextArea jtArea = new JTextArea();
	private JButton jbtHis = new JButton("Show HIstogram");
	private Histogram histogram = new Histogram();

	private JFrame hisFrame = new JFrame();

	public MultipleWindowsDemo() {
		// Set text area the text
		jtArea.setText(
				"A scrollbar consists of a rectangular tab called slider or thumb located between two arrow buttons. Two arrow buttons control the position of the slider by increasing or decreasing a number of units, one unit by default. The area between the slider and the arrow buttons is known as paging area. If user clicks on the paging area, the slider will move one block, normally 10 units. The slider’s position of scrollbar can be changed by: Creating Scrollbar Using JScrollBar Class\r\n"
						+ "In this tutorial, you will learn how to use JScrollBar class to create scrollbars in Java Swing application.\r\n"
						+ "\r\n"
						+ "A scrollbar consists of a rectangular tab called slider or thumb located between two arrow buttons. Two arrow buttons control the position of the slider by increasing or decreasing a number of units, one unit by default. The area between the slider and the arrow buttons is known as paging area. If user clicks on the paging area, the slider will move one block, normally 10 units. The slider’s position of scrollbar can be changed by:Creating Scrollbar Using JScrollBar Class\r\n"
						+ "In this tutorial, you will learn how to use JScrollBar class to create scrollbars in Java Swing application.\r\n"
						+ "\r\n"
						+ "A scrollbar consists of a rectangular tab called slider or thumb located between two arrow buttons. Two arrow buttons control the position of the slider by increasing or decreasing a number of units, one unit by default. The area between the slider and the arrow buttons is known as paging area. If user clicks on the paging area, the slider will move one block, normally 10 units. The slider’s position of scrollbar can be changed by:");

		// Store Text area in the scroll pane
		JScrollPane scrollPane = new JScrollPane(jtArea);
		scrollPane.setPreferredSize(new Dimension(300, 200));
		jtArea.setWrapStyleWord(true);
		jtArea.setLineWrap(true);

		// Place scroll pane and button in the frame
		add(scrollPane, BorderLayout.CENTER);
		add(jbtHis, BorderLayout.SOUTH);

		// Register listener
		jbtHis.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int[] count = countLetter();
				histogram.showHistogram(count);
				hisFrame.setVisible(true);
			}

		});

		// Create a new frame to hold the histogram panel
		hisFrame.add(histogram);
		hisFrame.pack();
		hisFrame.setTitle("Histogram");

	}

	private int[] countLetter() {
		// TODO Auto-generated method stub
		int[] count = new int[26];

		String text = jtArea.getText();

		for (int i = 0; i < text.length(); i++) {
			char character = text.charAt(i);

			if ((character >= 'A') && (character <= 'Z')) {
				count[(int) character - 65]++;// The ASCII for 'A' is 65

			} else if ((character >= 'a') && (character <= 'z')) {
				count[(int) character - 97]++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		MultipleWindowsDemo framegg = new MultipleWindowsDemo();
		framegg.setTitle("Multiple Windows Demo");
		framegg.setLocationRelativeTo(null);
		framegg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framegg.setVisible(true);
		framegg.pack();
		;
	}

}

class Histogram extends JPanel {
	private int[] count;

	// Set the count and display histogram
	public void showHistogram(int[] count) {
		this.count = count;
		repaint();
	}

	protected void paintComponent(Graphics g) {
		if (count == null)
			return;

		super.paintComponent(g);

		// Find the panel size and bar width and interval dynamically
		int width = getWidth();
		int height = getHeight();
		int interval = (width - 40) / count.length;
		int indWidth = (int) (((width - 40) / 24) * 0.60);

		// Find the maximum count. The maximum count has the highest bar
		int maxCount = 0;
		for (int i = 0; i < count.length; i++) {
			if (maxCount < count[i])
				maxCount = count[i];
		}

		int x = 30;

		// Draw a horizontal base line
		g.drawLine(10, height - 45, width - 10, height - 45);
		for (int i = 0; i < count.length; i++) {
			int barHeight = (int) (((double) count[i] / (double) maxCount) * (height - 55));

			// Display a bar
			g.drawRect(x, height - 45 - barHeight, indWidth, barHeight);

			g.drawString((char) (65 + i) + " ", x, height - 30);

			x += interval;
		}
	}

	public Dimension getPreferredSize() {
		return new Dimension(300, 300);
	}
}
