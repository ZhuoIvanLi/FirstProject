package AddressBook;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class AddressBook extends JFrame {

	final static int NAME_SIZE = 32;
	final static int STREET_SIZE = 32;
	final static int CITY_SIZE = 20;
	final static int STATE_SIZE = 2;
	final static int ZIP_SIZE = 5;
	final static int RECORD_SIZE = (NAME_SIZE + STREET_SIZE + CITY_SIZE + STATE_SIZE + ZIP_SIZE);

	// Access address.dat using RandomAccessFile
	private RandomAccessFile raf;

	private JTextField tfName = new JTextField(NAME_SIZE);
	private JTextField tfStreet = new JTextField(STREET_SIZE);
	private JTextField tfCity = new JTextField(CITY_SIZE);
	private JTextField tfState = new JTextField(STATE_SIZE);
	private JTextField tfZip = new JTextField(ZIP_SIZE);

	private JButton jbAdd = new JButton("Add");
	private JButton jbFirst = new JButton("First");
	private JButton jbNext = new JButton("Next");
	private JButton jbPrevious = new JButton("Previous");
	private JButton jbLast = new JButton("Last");

	public AddressBook() {
		// Open or create a random access file
		try {
			raf = new RandomAccessFile("address.dat", "rw");
		} catch (IOException ex) {
			System.out.print("Error: " + ex);
			System.exit(0);
		}

		// set text panel
		JPanel p1 = new JPanel(new GridLayout(3, 1));
		p1.add(new JLabel("Name"));
		p1.add(new JLabel("Street"));
		p1.add(new JLabel("City"));

		// set state panel
		JPanel jpState = new JPanel(new BorderLayout());
		jpState.add(new JLabel("State"), BorderLayout.WEST);
		jpState.add(tfState, BorderLayout.CENTER);

		// set zip panel
		JPanel jpZip = new JPanel(new BorderLayout());
		jpZip.add(new JLabel("Zip"), BorderLayout.WEST);
		jpZip.add(tfZip, BorderLayout.CENTER);

		// combine state and zip panel
		JPanel jpCom = new JPanel(new BorderLayout());
		jpCom.add(jpState, BorderLayout.WEST);
		jpCom.add(jpZip, BorderLayout.CENTER);

		// combine city label and state and zip
		JPanel p2 = new JPanel(new BorderLayout());
		p2.add(tfCity, BorderLayout.WEST);
		p2.add(jpCom, BorderLayout.CENTER);

		// combine text field with p2
		JPanel p3 = new JPanel(new GridLayout(3, 1));
		p3.add(tfName);
		p3.add(tfStreet);
		p3.add(p2);

		// Combine all fields together to make address panel
		JPanel jpAddress = new JPanel(new BorderLayout());
		jpAddress.add(p1, BorderLayout.WEST);
		jpAddress.add(p3, BorderLayout.CENTER);

		jpAddress.setBorder(new BevelBorder(BevelBorder.RAISED));

		// make a Button panel
		JPanel jpButton = new JPanel();
		jpButton.add(jbAdd);
		jpButton.add(jbFirst);
		jpButton.add(jbNext);
		jpButton.add(jbPrevious);
		jpButton.add(jbLast);

		// Add all panels in the frame
		add(jpAddress, BorderLayout.CENTER);
		add(jpButton, BorderLayout.SOUTH);

		// Add listener to Add button to add new address
		jbAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				writeAddress();
			}
		});

		// Add listener to First button
		jbFirst.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if (raf.length() > 0)
						readAddress(0);
				} catch (IOException ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}
			}
		});

		// Add listener to Next button
		jbNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					long currentPosition = raf.getFilePointer();
					if (currentPosition < raf.length()) {
						readAddress(currentPosition);
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}

			}
		});

		// Add listener to Previous button
		jbPrevious.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					long currentPosition = raf.getFilePointer();
					if (currentPosition - 2 * RECORD_SIZE > 0) {
						readAddress(currentPosition - 2 * 2 * RECORD_SIZE);
					} else
						readAddress(0);
				} catch (IOException ex) {
					ex.printStackTrace();
				}

			}
		});

		// Add listener to Last button to get the last record
		jbLast.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					long lasPosition = raf.length();
					if (lasPosition > 0)
						readAddress(lasPosition - 2 * RECORD_SIZE);
				} catch (Exception ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}

			}
		});

		// Display the first record if exists
		try {
			if (raf.length() > 0)
				readAddress(0);
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}

	}

	public void writeAddress() {
		try {
			raf.seek(raf.length());
			FiexedLengthIO.writeFixedLength(tfName.getText(), NAME_SIZE, raf);
			FiexedLengthIO.writeFixedLength(tfStreet.getText(), STREET_SIZE, raf);
			FiexedLengthIO.writeFixedLength(tfCity.getText(), CITY_SIZE, raf);
			FiexedLengthIO.writeFixedLength(tfState.getText(), STATE_SIZE, raf);
			FiexedLengthIO.writeFixedLength(tfZip.getText(), ZIP_SIZE, raf);
			JOptionPane.showMessageDialog(null, "test add done", "add", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}

	}

	public void readAddress(long position) throws IOException {

		try {
			raf.seek(position);
			String name = FiexedLengthIO.readFixedLength(NAME_SIZE, raf);
			String street = FiexedLengthIO.readFixedLength(STREET_SIZE, raf);
			String city = FiexedLengthIO.readFixedLength(CITY_SIZE, raf);
			String state = FiexedLengthIO.readFixedLength(STATE_SIZE, raf);
			String zip = FiexedLengthIO.readFixedLength(ZIP_SIZE, raf);

			tfName.setText(name);
			tfStreet.setText(street);
			tfCity.setText(city);
			tfState.setText(state);
			tfZip.setText(zip);

		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}

	}

	public static void main(String[] args) {

		AddressBook ab = new AddressBook();
		ab.pack();
		ab.setTitle("Address Book");
		ab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ab.setVisible(true);

	}
}
