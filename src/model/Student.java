package model;

import java.util.ArrayList;
import java.util.Date;

enum Status{
	B,
	S
}

public class Student {
	private String surname;
	private String name;
	private Date birthDate;
	private Adress adress;
	private String contact;
	private String mail; 
	private String index;
	private int enrollmentYear;
	private int currentStudyYear;
	private Status status;
	private float avgGrade;
	private ArrayList<ExamGrade> gradeList = new ArrayList<ExamGrade>();
	private ArrayList<Subject> notPassed = new ArrayList<Subject>();
}