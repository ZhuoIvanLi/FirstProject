package helloworld;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class HoldComponents extends JFrame {
	public HoldComponents() {
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));

		JButton jbtok = new JButton("OK");
		jbtok.setBackground(Color.blue);
		jbtok.setForeground(Color.red);

		JButton jbtc = new JButton("Cancel");
		JLabel lblName = new JLabel("enter name:");
		JTextField jtfName = new JTextField("type in text field");
		JCheckBox jchkBold = new JCheckBox("bold");
		JRadioButton jrbRed = new JRadioButton("Red");
		JComboBox jcmbColor = new JComboBox(new String[] { "Red", "Green", "Blue" });

		p1.add(jbtok);
		p1.add(jbtc);
		p1.add(lblName);
		p1.add(jtfName);
		p1.add(jchkBold);
		p1.add(jrbRed);
		p1.add(jcmbColor);

		// create JPanel 2 for the number board
		JPanel p2 = new JPanel(new GridLayout(4, 3));

		for (int i = 1; i <= 9; i++)
			p2.add(new JButton("" + i));

		p2.add(new JButton("" + 0));
		p2.add(new JButton("Start"));
		p2.add(new JButton("Stop"));
		p2.setSize(100, 100);

		// p1.add(p2);

		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		add(new JButton("Place something here"), BorderLayout.SOUTH);

		// Add Listener on the OK Button
		jbtok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(
						"the " + e.getActionCommand() + " button is clicked at\n " + new java.util.Date(e.getWhen()));
			}
		});

		// Add Listener on window
		addWindowListener(new WindowListener() {
			public void windowDeiconified(WindowEvent e) {
				System.out.println("Window deiconified");
			}

			public void windowIconified(WindowEvent e) {
				System.out.println("Window iconified");

			}

			public void windowActivated(WindowEvent e) {
				System.out.println("Window activate");

			}

			public void windowDeactivated(WindowEvent e) {
				System.out.println("Window deactivated");

			}

			public void windowOpened(WindowEvent e) {
				System.out.println("Window open");

			}

			public void windowClosing(WindowEvent e) {
				System.out.println("Window closing");

			}

			public void windowClosed(WindowEvent e) {
				System.out.println("Window closed");

			}

		});

	}

	public static void main(String[] args) {
		JFrame frame = new HoldComponents();

		frame.setTitle("MyFirstWindows");
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
