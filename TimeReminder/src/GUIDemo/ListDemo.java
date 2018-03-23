package GUIDemo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import GUIDemo.ButtonDemo.MessagePanel;

public class ListDemo extends JFrame {
	final int NUMBER_OF_IMAGES = 9;

	private String[] titles = { "b001", "b002", "b003", "b004", "b005", "b006", "b007", "b008", "b009" };

	// the list of selecting chose
	private JList jlist = new JList(titles);

	// Declare the ImageIcons
	private ImageIcon[] imageIcons = { new ImageIcon("src/GUIDemo/images/b001.jpg"),
			new ImageIcon("src/GUIDemo/images/b002.jpg"), new ImageIcon("src/GUIDemo/images/b003.jpg"),
			new ImageIcon("src/GUIDemo/images/b004.jpg"), new ImageIcon("src/GUIDemo/images/b005.jpg"),
			new ImageIcon("src/GUIDemo/images/b006.jpg"), new ImageIcon("src/GUIDemo/images/b007.jpg"),
			new ImageIcon("src/GUIDemo/images/b008.jpg"), new ImageIcon("src/GUIDemo/images/b009.jpg"), };

	// Arrays of labels for the displaying images
	private JLabel[] jlblImages = new JLabel[NUMBER_OF_IMAGES];

	// Create horizontal and vertical scroll bars
	private JScrollBar jsbHort = new JScrollBar(JScrollBar.HORIZONTAL);
	private JScrollBar jsbVert = new JScrollBar(JScrollBar.VERTICAL);
	private MessagePanel messPanel = new MessagePanel("test scroll bar");

	public static void main(String[] args) {

		System.out.println(System.getProperty("user.dir"));
		ListDemo framegg = new ListDemo();
		framegg.setTitle("List Demo");
		framegg.setLocationRelativeTo(null);
		framegg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framegg.setVisible(true);
		framegg.setSize(650, 500);
	}

	public ListDemo() {
		JPanel p0 = new JPanel(new GridLayout(2, 1));
		JPanel p = new JPanel(new GridLayout(3, 3, 5, 5));
		JPanel messP = new JPanel();

		for (int i = 0; i < NUMBER_OF_IMAGES; i++) {
			p.add(jlblImages[i] = new JLabel());
			jlblImages[i].setHorizontalAlignment(SwingConstants.CENTER);

		}

		p0.add(p);
		p0.add(messP);

		// Add the scroll bar in the panel
		messP.setLayout(new BorderLayout());
		messP.add(messPanel, BorderLayout.CENTER);
		messP.add(jsbHort, BorderLayout.SOUTH);
		messP.add(jsbVert, BorderLayout.EAST);

		// Add p and the list to the frame
		add(p0, BorderLayout.CENTER);
		// Add the scroll pane for the list
		add(new JScrollPane(jlist), BorderLayout.WEST);

		// Register listeners
		jlist.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int[] index = jlist.getSelectedIndices();

				int i;

				// Set icons in the labels
				for (i = 0; i < index.length; i++) {
					jlblImages[i].setIcon(imageIcons[index[i]]);

				}

				for (; i < NUMBER_OF_IMAGES; i++) {
					jlblImages[i].setIcon(null);
				}

			}
		});

		// Register listeners for the scroll bar
		jsbHort.addAdjustmentListener(new AdjustmentListener() {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				// TODO Auto-generated method stub
				double value = jsbHort.getValue();
				double maxValue = jsbHort.getMaximum();
				double newX = (value * messPanel.getWidth() / maxValue);
				messPanel.setLocation(((int) newX), 0);
			}
		});

		jsbVert.addAdjustmentListener(new AdjustmentListener() {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				// TODO Auto-generated method stub
				double value = jsbVert.getValue();
				double maxValue = jsbVert.getMaximum();
				double newY = (value * messPanel.getHeight() / maxValue);
				messPanel.setLocation(0, ((int) newY));
			}
		});

	}

}
