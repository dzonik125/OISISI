package frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	public MainFrame() {
		super();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		setSize(3*(screenWidth / 4), 3*(screenHeight / 4));
		setTitle("Studentska služba");
		setLocationRelativeTo(null);
		
		MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
		
		MyToolBar tb = new MyToolBar();
		add(tb, BorderLayout.NORTH);
		
		StatusBar status = new StatusBar();
		add(status, BorderLayout.SOUTH);
		
		
	}
	
}
