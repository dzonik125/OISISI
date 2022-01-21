package main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.WindowConstants;

import frame.MainFrame;
import util.Serialization;

public class StudentService {

	public static void main(String[] args) {
		MainFrame mf = MainFrame.getInstance();
		mf.setVisible(true);
		mf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mf.addWindowListener(new WindowAdapter() {
			@SuppressWarnings("unused")
			public void windowClosing(WindowEvent e) {
				Serialization.getInstance().serializeStudent();
				Serialization.getInstance().serializeProfessor();
				Serialization.getInstance().serializeSubject();
			}
		});
	}

}