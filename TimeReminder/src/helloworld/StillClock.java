package helloworld;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JPanel;
import javax.swing.Timer;

public class StillClock extends JPanel {
	private int hour;
	private int minute;
	private int second;

	public StillClock() {
		setCurrentTime();

		Timer timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCurrentTime();
				repaint();
			}
		});
		timer.start();
	}

	public StillClock(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
		repaint();
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
		repaint();
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
		repaint();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Initialize the clock parameters
		int clockRadius = (int) (Math.min(getWidth(), getHeight()) * 0.8 * 0.5);
		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;

		// Draw circle
		g.setColor(Color.BLACK);
		g.drawOval(xCenter - clockRadius, yCenter - clockRadius, 2 * clockRadius, 2 * clockRadius);
		g.drawString("12", xCenter - 5, yCenter - clockRadius + 12);
		g.drawString("9", xCenter - clockRadius + 3, yCenter + 5);
		g.drawString("3", xCenter + clockRadius - 10, yCenter + 3);
		g.drawString("6", xCenter - 3, yCenter + clockRadius - 3);

		// Draw second hand
		int sLength = (int) (clockRadius * 0.8);
		int xSecond = (int) (xCenter + sLength * Math.sin(second * (2 * Math.PI / 60)));
		int ySecond = (int) (yCenter - sLength * Math.cos(second * (2 * Math.PI / 60)));
		g.setColor(Color.RED);
		g.drawLine(xCenter, yCenter, xSecond, ySecond);

		// Draw minute hand
		int mLength = (int) (clockRadius * 0.7);
		int xMinute = (int) (xCenter + mLength * Math.sin(minute * (2 * Math.PI / 60)));
		int yMinute = (int) (yCenter - mLength * Math.cos(minute * (2 * Math.PI / 60)));
		g.setColor(Color.BLUE);
		g.drawLine(xCenter, yCenter, xMinute, yMinute);

		// Draw hour hand
		int hLength = (int) (clockRadius * 0.5);
		int xHour = (int) (xCenter + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
		int yHour = (int) (yCenter - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
		g.setColor(Color.GREEN);
		g.drawLine(xCenter, yCenter, xHour, yHour);

		g.setColor(Color.BLACK);
		g.drawString(getHour() + ":" + getMinute() + ":" + getSecond(), xCenter - 25, getHeight() - 10);

	}

	public void setCurrentTime() {
		// Contstruct a calendar for the current date and time
		Calendar cal = new GregorianCalendar();

		// Set current hour, minute and second
		this.hour = cal.get(Calendar.HOUR_OF_DAY);
		this.minute = cal.get(Calendar.MINUTE);
		this.second = cal.get(Calendar.SECOND);

	}

	public Dimension getPreferrredSize() {
		return new Dimension(200, 200);
	}

}