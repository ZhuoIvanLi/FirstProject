package helloworld;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeyEventDemo extends JFrame {

	private KeyboardPanel keyPanel = new KeyboardPanel();

	public KeyEventDemo() {
		// Add the key board panel to accept and display user input
		add(keyPanel);
		// set focus
		keyPanel.setFocusable(true);
	}

	public static void main(String[] args) {
		KeyEventDemo f = new KeyEventDemo();
		f.setTitle("KeyEventDemo");
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300, 300);
		f.setVisible(true);

	}

	private static class KeyboardPanel extends JPanel {
		private int x = 100;
		private int y = 100;
		private char keyChar = 'A';

		public KeyboardPanel() {
			// Add listener to the Panel
			addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					switch (e.getKeyCode()) {
					case KeyEvent.VK_DOWN:
						y += 10;
						break;
					case KeyEvent.VK_UP:
						y -= 10;
						break;
					case KeyEvent.VK_LEFT:
						x -= 10;
						break;
					case KeyEvent.VK_RIGHT:
						x += 10;
						break;
					default:
						keyChar = e.getKeyChar();
					}

					repaint();
				}
			});
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
			g.drawString(String.valueOf(keyChar), x, y);
		}
	}
}
