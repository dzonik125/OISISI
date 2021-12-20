package controllers;

import frame.MainFrame;
import model.Student;
import model.StudentBase;

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
	
}
