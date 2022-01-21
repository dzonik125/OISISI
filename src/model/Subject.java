package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Subject implements Serializable{
	public enum Semester {
		Letnji, Zimski
	}

	private String subjectID;
	private String subjectName;
	private Semester semester;
	private int studyYear;
	private Professor subjectProfessor;
	private int espb;
	private ArrayList<Student> passed = new ArrayList<Student>();
	private ArrayList<Student> failed = new ArrayList<Student>();

	public Subject() {
		super();
	}

	public Subject(String subjectID, String subjectName, Semester semester, int studyYear, int espb) { // DODATI
																									// PROFESORA!!
		super();
		this.subjectID = subjectID;
		this.subjectName = subjectName;
		this.semester = semester;
		this.studyYear = studyYear;
		// this.subjectProfessor = subjectProfessor;
		this.espb = espb;
	}

	public Subject(Subject s) {
		super();
		this.subjectID = s.subjectID;
		this.subjectName = s.subjectName;
		this.semester = s.semester;
		this.studyYear = s.studyYear;
		this.subjectProfessor = s.subjectProfessor;
		this.espb = s.espb;
		this.passed = s.passed;
		this.failed = s.failed;
	}

	public Subject(String subjectID, String subjectName, Semester semester, int studyYear, Professor subjectProfessor,
			int espb, ArrayList<Student> passed, ArrayList<Student> failed) {
		super();
		this.subjectID = subjectID;
		this.subjectName = subjectName;
		this.semester = semester;
		this.studyYear = studyYear;
		this.subjectProfessor = subjectProfessor;
		this.espb = espb;
		this.passed = passed;
		this.failed = failed;
	}
	
	
	public void deleteProfessorFromSubject(int index) {
		this.subjectProfessor=null;
	}

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public int getStudyYear() {
		return studyYear;
	}

	public void setStudyYear(int studyYear) {
		this.studyYear = studyYear;
	}

	public Professor getSubjectProfessor() {
		return subjectProfessor;
	}

	public void setSubjectProfessor(Professor subjectProfessor) {
		this.subjectProfessor = subjectProfessor;
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public ArrayList<Student> getPassed() {
		return passed;
	}

	public void setPassed(ArrayList<Student> passed) {
		this.passed = passed;
	}

	public ArrayList<Student> getFailed() {
		return failed;
	}

	public void setFailed(ArrayList<Student> failed) {
		this.failed = failed;
	}

}