package model;

import java.util.Date;

public class ExamGrade {
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
}