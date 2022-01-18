package frame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.Timer;

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
		
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss        dd.MM.yyyy.        ");
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("HH:mm:ss        dd.MM.yyyy.        ");
		Date date = new Date();
		JLabel statusLabel1 = new JLabel();
		statusLabel1.setText(dateFormat.format(date));
		Timer t = new Timer(500, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				statusLabel1.setText(java.time.LocalDateTime.now().format(myFormat));
			}
		});
		t.setRepeats(true);
		t.setCoalesce(true);
		t.setInitialDelay(0);
		t.start();
		statusBarDesni.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0,Color.BLACK));
		statusBarDesni.add(statusLabel1);
		
		add(statusBarDesni);
		
	}
	
}
