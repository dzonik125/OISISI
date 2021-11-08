package main;

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
	private Adresa adress;
	private String contact;
	private String mail; 
	private String index;
	private int enrollmentYear;
	private int currentStudyYear;
	private Status status;
	private float avgGrade;
	private ArrayList<String> gradeList = new ArrayList<String>();
	private ArrayList<String> notPassed = new ArrayList<String>();
}