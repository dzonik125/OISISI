package main;

import javax.swing.WindowConstants;

import frame.MainFrame;

public class StudentService {

	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
		mf.setVisible(true);
		mf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

}