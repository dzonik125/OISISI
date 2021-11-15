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
	private ArrayList<String> passed = new ArrayList<String>();
	private ArrayList<String> failed = new ArrayList<String>();
}