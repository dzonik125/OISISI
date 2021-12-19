package frame;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class MyToolBar extends JToolBar {
	public MyToolBar() {

		super(SwingConstants.HORIZONTAL);

		ImageIcon iconIcon = new ImageIcon("images/icon.png");
		Image image3 = iconIcon.getImage();
		Image newimg3 = image3.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		iconIcon = new ImageIcon(newimg3);

		JButton buttonNew = new JButton();
		buttonNew.setToolTipText("New");
		buttonNew.setIcon(iconIcon);
		add(buttonNew);
		buttonNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// Dodati if za tabove!!
				if (MainFrame.getInstance().tp.getSelectedIndex() == 0) {
					DialogStudent ds = new DialogStudent(MainFrame.getInstance());
				}
			}
		});

		addSeparator();

		ImageIcon pencilIcon = new ImageIcon("images/pencil.png");
		Image image2 = pencilIcon.getImage();
		Image newimg2 = image2.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		pencilIcon = new ImageIcon(newimg2);

		JButton buttonChange = new JButton();
		buttonChange.setToolTipText("change");
		buttonChange.setIcon(pencilIcon);
		add(buttonChange);
		buttonChange.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (MainFrame.getInstance().tp.getSelectedIndex() == 0) {
					EditStudent es = new EditStudent(MainFrame.getInstance());
				}
			}

		});

		addSeparator();

		ImageIcon deleteIcon = new ImageIcon("images/delete.png");
		Image image1 = deleteIcon.getImage();
		Image newimg1 = image1.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		deleteIcon = new ImageIcon(newimg1);

		JButton buttonBin = new JButton();
		buttonBin.setToolTipText("delete");
		buttonBin.setIcon(deleteIcon);
		add(buttonBin);
		buttonBin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (MainFrame.getInstance().tp.getSelectedIndex() == 0) {
					DeleteStudent dels = new DeleteStudent(MainFrame.getInstance());
				}
			}
		});

		addSeparator();

		JTextField textField = new JTextField();
		textField.setToolTipText("pretraga");
		textField.setColumns(9);
		textField.getPreferredSize();
		textField.setBounds(100, 100, 200, 40);

		add(textField);

		ImageIcon searchIcon = new ImageIcon("images/search.png");
		Image image4 = searchIcon.getImage();
		Image newimg4 = image4.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		searchIcon = new ImageIcon(newimg4);

		JButton buttonSearch = new JButton();
		buttonSearch.setToolTipText("seach");
		buttonSearch.setIcon(searchIcon);

		add(buttonSearch);

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(RIGHT));
		panel.add(textField);
		panel.add(buttonSearch);

		add(panel);

		setFloatable(false);

	}

}
