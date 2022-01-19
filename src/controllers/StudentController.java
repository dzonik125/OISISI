package controllers;

import frame.EditStudent;
import frame.MainFrame;
import model.NotPassedExamsBase;
import model.Student;
import model.StudentBase;
import model.Subject;
import model.SubjectBase;

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
	
	public void deleteExam(int rowSelectedIndex, int id) {
		if(rowSelectedIndex < 0) {
			return;
		}
		//izmena modela
		StudentBase.getInstance().deleteExam(id);
	}
	
	public void addSubjectToNotPassed(Student st, Subject s) {
		// izmena modela
		st.getNotPassed().add(s);
		// azuriranje prikaza
		
	}
	
}