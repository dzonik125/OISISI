package frame;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedPane extends JTabbedPane{
	public TabbedPane() {
		addTab("Studenti", new StudentTable());
	}
}