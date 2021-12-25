package frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import controllers.StudentController;
import model.Adress;
import model.Student;
import model.StudentBase;

public class EditProfesor extends JDialog {


	public EditProfesor(JFrame parent) {
		Dimension frameSize = parent.getSize();
		int frameHeight = frameSize.height;
		int frameWidth = frameSize.width;
		setSize(frameWidth / 2, frameHeight - 30);
		setLocationRelativeTo(parent);
		setTitle("Izmena profesora");
		setModal(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		JPanel bottomPanel = new JPanel();
		JButton confirm = new JButton("Potvrda");
		JButton abort = new JButton("Odustanak");

		bottomPanel.add(confirm);
		bottomPanel.add(abort);

		add(bottomPanel, BorderLayout.SOUTH);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridBagLayout());
		add(centerPanel, BorderLayout.NORTH);

		JTabbedPane tp = new JTabbedPane();
		add(tp);
		setVisible(true);
	}
}