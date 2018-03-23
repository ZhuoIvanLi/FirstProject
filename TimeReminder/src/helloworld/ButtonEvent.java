package helloworld;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ButtonEvent extends JFrame {

	public ButtonEvent() {
		// set FlowLayout for the frame
		// FlowLayout layout = new FlowLayout();
		// setLayout(layout);

		// Add two buttons to Frame
		JButton jbtOK = new JButton("OK");
		JButton jbtCancel = new JButton("Cancel");
		jbtOK.setHorizontalAlignment(SwingConstants.LEFT);

		JPanel jp = new JPanel();

		jp.add(jbtOK);
		jp.add(jbtCancel);

		// register listeners
		OKListenerClass listener1 = new OKListenerClass();
		CancelListenerClass listener2 = new CancelListenerClass();
		jbtOK.addActionListener(listener1);
		jbtCancel.addActionListener(listener2);

		MoveMessagePanel p = new MoveMessagePanel("Mouse Motion Listener");

		add(p, BorderLayout.CENTER);
		add(jp, BorderLayout.SOUTH);
	}

	public static void main(String[] arg) {
		JFrame frame = new ButtonEvent();
		frame.setTitle("Handle Button Event");
		frame.setSize(500, 500);
		frame.setLocation(200, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public static class MoveMessagePanel extends JPanel {
		private String message = "Mouse Motion Listener";
		private int x = 50;
		private int y = 50;

		public MoveMessagePanel(String s) {
			message = s;
			addMouseMotionListener(new MouseMotionAdapter() {
				public void mouseDragged(MouseEvent e) {
					x = e.getX();
					y = e.getY();
					repaint();
				}
			});
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawString(message, x, y);
		}
	}

}

class OKListenerClass implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("OK Button clicked");
	}
}

class CancelListenerClass implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("Cancel Button clicked");
	}
}
