package helloworld;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class TestSwingCommonFeatures extends JFrame {

	public TestSwingCommonFeatures() {
		// Create a panel to group three buttons
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
		JButton btLeft = new JButton("Left");
		JButton btCenter = new JButton("Center");
		JButton btRight = new JButton("Right");
		btLeft.setBackground(Color.white);
		btCenter.setForeground(Color.green);
		btRight.setToolTipText("This right button");
		p1.add(btLeft);
		p1.add(btCenter);
		p1.add(btRight);
		p1.setBorder(new TitledBorder("Three Buttons"));

		// create a font and a line border
		Font largeFont = new Font("TimesRoman", Font.BOLD, 20);
		Border lineBorder = new LineBorder(Color.BLACK, 2);

		// Create a panel to group two labels
		JPanel p2 = new JPanel(new GridLayout(1, 2, 5, 5));
		JLabel lbRed = new JLabel("Red");
		JLabel lbOrange = new JLabel("Orange");
		lbRed.setForeground(Color.RED);
		lbOrange.setForeground(Color.ORANGE);
		lbRed.setFont(largeFont);
		lbOrange.setFont(largeFont);
		lbRed.setBorder(lineBorder);
		lbOrange.setBorder(lineBorder);
		p2.add(lbRed);
		p2.add(lbOrange);
		p2.setBorder(new TitledBorder("Two Labels"));

		// add two Panels to the frame
		setLayout(new GridLayout(2, 1, 5, 5));
		add(p1);
		add(p2);

	}

	// run the application
	public static void main(String[] arg) {
		// Create a frame and set its properties
		TestSwingCommonFeatures frame = new TestSwingCommonFeatures();
		frame.setTitle("TestSwingCommonFeatures");
		frame.setSize(300, 150);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
