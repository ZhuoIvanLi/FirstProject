package GUIDemo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ButtonDemo extends JFrame {
	// Declare the message
	protected MessagePanel messPanel = new MessagePanel("GUI Demo");

	// Declare Two Buttons
	private JButton jbtLeft = new JButton("<=");
	private JButton jbtRight = new JButton("=>");

	// Create the three check boxes to control the display of message
	private JCheckBox jcCentered = new JCheckBox("Centered");
	private JCheckBox jcBold = new JCheckBox("Bold");
	private JCheckBox jcItalic = new JCheckBox("Italic");

	// Declare radio buttons
	private JRadioButton jrbRed = new JRadioButton("Red");
	private JRadioButton jrbGreen = new JRadioButton("Green");
	private JRadioButton jrbBlue = new JRadioButton("Blue");

	// Declare text field
	private JTextField jtfMessage = new JTextField(10);

	public static void main(String[] args) {
		ButtonDemo bd = new ButtonDemo();
		bd.setTitle("Button Demo");
		bd.setLocationRelativeTo(null);
		bd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bd.setVisible(true);
		bd.pack();
	}

	public ButtonDemo() {
		// Set the background color of messagePanel
		messPanel.setBackground(Color.WHITE);

		// Create Panel jbPanel to hold the buttons
		JPanel jbPanel = new JPanel();
		jbPanel.setLayout(new FlowLayout());
		jbPanel.add(jbtLeft);
		jbPanel.add(jbtRight);

		// Create JPanel jpCheck for Check boxes
		JPanel jpCheck = new JPanel();
		jpCheck.setLayout(new GridLayout(3, 1));
		jpCheck.add(jcCentered);
		jpCheck.add(jcBold);
		jpCheck.add(jcItalic);

		// Create JPanel jprb for the single check box
		JPanel jprb = new JPanel();
		jprb.setLayout(new GridLayout(3, 1));
		jprb.add(jrbRed);
		jprb.add(jrbGreen);
		jprb.add(jrbBlue);

		// Create a Radio button group to group three buttons
		ButtonGroup group = new ButtonGroup();
		group.add(jrbRed);
		group.add(jrbGreen);
		group.add(jrbBlue);

		// Create a JPanel jpText for the text field
		JPanel jpText = new JPanel();
		jpText.setLayout(new BorderLayout(5, 0));
		jpText.add(new JLabel("Enter a new message here：                                   "), BorderLayout.WEST);
		jpText.add(jtfMessage, BorderLayout.CENTER);

		jtfMessage.setHorizontalAlignment(JTextField.RIGHT);

		// Set keyboard mnemonics
		jbtLeft.setMnemonic('L');
		jbtRight.setMnemonic('R');

		// Set tool tip text on the buttons
		jbtLeft.setToolTipText("Move message to left");
		jbtRight.setToolTipText("Move message to Right");

		// Place the Panel in frame
		setLayout(new BorderLayout());
		add(messPanel, BorderLayout.CENTER);
		add(jbPanel, BorderLayout.SOUTH);
		add(jpCheck, BorderLayout.EAST);
		add(jprb, BorderLayout.WEST);
		add(jpText, BorderLayout.NORTH);

		// Add listener for each button
		jbtLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				messPanel.moveLeft();
			}
		});
		jbtRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				messPanel.moveRight();
			}
		});

		// Add Listener for the check boxes
		jcCentered.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				messPanel.setCentered(jcCentered.isSelected());
			}
		});
		jcBold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNewFont();
			}
		});
		jcItalic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNewFont();
			}
		});

		// Add Listeners for the Radio check box
		jrbRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				messPanel.setForeground(Color.red);
			}
		});

		jrbGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				messPanel.setForeground(Color.green);
			}
		});

		jrbBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				messPanel.setForeground(Color.blue);
			}
		});

		// Add Listener for the text field
		jtfMessage.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				messPanel.setMessage(jtfMessage.getText());
				jtfMessage.requestFocusInWindow();
			}

			public void removeUpdate(DocumentEvent e) {
				messPanel.setMessage(jtfMessage.getText());
				jtfMessage.requestFocusInWindow();
			}

			public void insertUpdate(DocumentEvent e) {
				messPanel.setMessage(jtfMessage.getText());
				jtfMessage.requestFocusInWindow();
			}

		});

	}

	private void setNewFont() {
		int fontStyle = Font.PLAIN;
		fontStyle += (jcBold.isSelected() ? Font.BOLD : Font.PLAIN);
		fontStyle += (jcItalic.isSelected() ? Font.ITALIC : Font.PLAIN);

		// Set font for the message
		Font font = messPanel.getFont();
		messPanel.setFont(new Font(font.getName(), fontStyle, font.getSize()));
	}

	public static class MessagePanel extends JPanel {
		private String message = "GUI Demo";
		private int x = 50;
		private int y = 50;
		private boolean select = false;
		public String s = new String();

		public MessagePanel(String s) {
			this.message = s;
		}

		public void setMessage(String s) {
			message = s;
			repaint();
		}

		public void moveLeft() {
			if (!select)
				x -= 20;
			repaint();
		}

		public void moveRight() {
			if (!select)
				x += 20;
			repaint();
		}

		public void setCentered(Boolean b) {
			if (b) {
				x = 50;
				y = 50;
				repaint();
				select = true;
			} else {
				select = false;
			}
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawString(message, x, y);
		}
	}

}
