package frame;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

import javax.swing.JFrame;

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
		
		addSeparator();
		
		ImageIcon pencilIcon = new ImageIcon("images/pencil.png");
		Image image2 = pencilIcon.getImage();
		Image newimg2 = image2.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		pencilIcon = new ImageIcon(newimg2);
		
		JButton buttonChange = new JButton();
		buttonChange.setToolTipText("New");
		buttonChange.setIcon(pencilIcon);
		add(buttonChange);
		
		addSeparator();
		
		ImageIcon deleteIcon = new ImageIcon("images/delete.png");
		Image image1 = deleteIcon.getImage();
		Image newimg1 = image1.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		deleteIcon = new ImageIcon(newimg1);
		
		
		JButton buttonBin = new JButton();
		buttonBin.setToolTipText("New");
		buttonBin.setIcon(deleteIcon);
		add(buttonBin);
		
		addSeparator();
		
		JTextField textField = new JTextField();
		textField.setPreferredSize(new Dimension(30, 15));
		
		add(textField);
		
		ImageIcon searchIcon = new ImageIcon("images/search.png");
		Image image4 = searchIcon.getImage();
		Image newimg4 = image4.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		searchIcon = new ImageIcon(newimg4);
		
		
		JButton buttonSearch=new JButton();
		buttonSearch.setText("seach");
		buttonSearch.setIcon(searchIcon);
		
		add(buttonSearch);
		
		setFloatable(false);
		
	}



}

