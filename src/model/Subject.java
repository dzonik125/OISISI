package model;

import java.util.ArrayList;

enum Semester{
	WINTER,
	SUMMER
}

public class Subject {
	private int subjectID;
	private String subjectName;
	private Semester semester;
	private int studyYear;
	private Professor subjectProfessor;
	private int espb;
	private ArrayList<Student> passed = new ArrayList<Student>();
	private ArrayList<Student> failed = new ArrayList<Student>();
}