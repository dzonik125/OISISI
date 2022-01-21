package model;

import java.io.Serializable;
import java.util.Date;

public class ExamGrade implements Serializable{
	private String studentPassed;
	private Subject subject;
	private int grade;
	private Date examDate;
	
	public void setGrade(int a) {
		if (a >= 6 && a <= 10) {
			grade = a;
		} else {
			throw new IllegalArgumentException("Number out of range!");
		} 
	}

	public String getStudentPassed() {
		return studentPassed;
	}

	public void setStudentPassed(String studentPassed) {
		this.studentPassed = studentPassed;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public int getGrade() {
		return grade;
	}
	
	
}