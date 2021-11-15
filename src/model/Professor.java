package model;

import java.util.ArrayList;
import java.util.Date;

public class Professor {
	private String name;
	private String surname;
	private Date dateOfBirth = new Date();
	private Adress adress;
	private String phone;
	private String mail;
	private String office;
	private String id;
	private String title;
	private int internshipYear;
	private ArrayList<Subject> subjectList = new ArrayList<Subject>(); 
}