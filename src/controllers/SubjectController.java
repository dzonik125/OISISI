package controllers;

import frame.MainFrame;
import model.Student;
import model.StudentBase;
import model.Subject;
import model.SubjectBase;

public class SubjectController {
	private static SubjectController instance = null;
	
	public static SubjectController getInstance() {
		if(instance == null) {
			instance = new SubjectController();
		}
		return instance;
	}
	
	private SubjectController() {}
	
	public void addSubject(Subject s) {
		//izmena modela
		SubjectBase.getInstance().addSubject(s);
		//azuriranje prikaza
		MainFrame.getInstance().refresh1();
	}
	
	public void editSubject(int rowSelectedIndex, Subject s) {
		if(rowSelectedIndex < 0) {
			return;
		}
		//izmena modela
		SubjectBase.getInstance().editSubject(rowSelectedIndex, s);
		//azuriranje prikaza
		MainFrame.getInstance().refresh1();
	}
	
	public void deleteSubject(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		//izmena modela
		Subject subject = SubjectBase.getInstance().getRow(rowSelectedIndex);
		//SubjectBase.getInstance().deleteSubject();
		//azuriranje prikaza
		MainFrame.getInstance().refresh1();
	}
	
}