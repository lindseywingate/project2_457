package airplane_radar;

import javax.swing.*;//lightweight components that work on same platforms
import java.awt.*;
import java.awt.event.*;

public class radar {
	private static void GUI() {
		JFrame window = new JFrame("radar");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel text = new JLabel("Testing :)");
		window.getContentPane().add(text);

		window.pack();
		window.setVisible(true);
	}
	private static void EVENTS() {
		JButton start_button = new JButton("start");
	
		start_button.setActionCommand("start");
		
		start_button.addActionListener(new ButtonClickListener());
		window.add(start_button);
			
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GUI();
			}
		});
	}
}
