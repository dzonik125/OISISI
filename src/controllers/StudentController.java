package controllers;

import frame.MainFrame;
import model.Student;
import model.StudentBase;
import model.Subject;

public class StudentController {
	private static StudentController instance = null;
	
	public static StudentController getInstance() {
		if(instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	
	private StudentController() {}
	
	public void addStudent(Student s) {
		//izmena modela
		StudentBase.getInstance().addStudent(s);
		//azuriranje prikaza
		MainFrame.getInstance().refresh();
	}
	
	public void editStudent(int rowSelectedIndex, Student s) {
		if(rowSelectedIndex < 0) {
			return;
		}
		//izmena moedla
		StudentBase.getInstance().editStudent(rowSelectedIndex, s);
		//azuriranje prikaza
		MainFrame.getInstance().refresh();
	}
	
	public void deleteStudent(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		//izmena modela
		Student student = StudentBase.getInstance().getRow(rowSelectedIndex);
		StudentBase.getInstance().deleteStudent(student.getIndex());
		//azuriranje prikaza
		MainFrame.getInstance().refresh();
	}
	
	public void addSubjectToNotPassed(Student st, Subject s) {
		// izmena modela
		st.getNotPassed().add(s);
		// azuriranje prikaza
		
	}
	
}