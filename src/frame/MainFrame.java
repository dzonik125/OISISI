package frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MainFrame extends JFrame {
	private static MainFrame instance;
	private JTable studentTable;
	
	private MainFrame() {
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
		
		TabbedPane tp = new TabbedPane();
		add(tp, BorderLayout.CENTER);
		
		studentTable = new StudentTable();
		JScrollPane scrollPane = new JScrollPane(studentTable);
		tp.add(scrollPane);
		this.refresh();
	}
	
	public void refresh() {
		AbstractTableModelStudents model = (AbstractTableModelStudents) studentTable.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	public static MainFrame getInstance() {
		if(instance == null)
			instance = new MainFrame();
		return instance;
	}
	
}
