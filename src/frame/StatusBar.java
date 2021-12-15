package frame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class StatusBar extends JMenuBar {
	
	public StatusBar() {
		JPanel statusBarLevi = new JPanel();
		statusBarLevi.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel statusLabel = new JLabel("  Studentska služba");
		statusBarLevi.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0,Color.BLACK));
		statusBarLevi.add(statusLabel);
		
		add(statusBarLevi);
		
		JPanel statusBarDesni = new JPanel();
		statusBarDesni.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		DateFormat dateFormat = new SimpleDateFormat("HH:mm        dd.MM.yyyy.        ");
		Date date = new Date();
		JLabel statusLabel1 = new JLabel(dateFormat.format(date));
		statusBarDesni.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0,Color.BLACK));
		statusBarDesni.add(statusLabel1);
		
		add(statusBarDesni);
		
	}
	
}
