package model;

import java.util.ArrayList;
import java.util.Date;

public class Student {
	public enum Status {
		B, S
	}

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

	public Student() {
		super();
	}

	public Student(String index, String name, String surname, Date birthday, Adress adr, int currentStudyYear, Status s, float avgGrade, String cont, String email, int ey) {
		super();
		this.surname = surname;
		this.name = name;
		this.index = index;
		this.currentStudyYear = currentStudyYear;
		this.status = s;
		this.avgGrade = avgGrade;
		this.birthDate = birthday;
		this.adress = adr;
		this.mail = email;
		this.contact = cont;
		this.enrollmentYear =  ey;
	}

	public Student(Student s) {
		// TODO Auto-generated constructor stub
		super();
		this.surname = s.getSurname();
		this.name = s.getName();
		this.index = s.getIndex();
		this.birthDate = s.getBirthDate();
		this.currentStudyYear = s.getCurrentStudyYear();
		this.status = s.getStatus();
		this.avgGrade = s.getAvgGrade();
		this.adress = s.getAdress();
		this.mail = s.getMail();
		this.contact = s.getContact();
		this.enrollmentYear = s.getEnrollmentYear();
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public int getEnrollmentYear() {
		return enrollmentYear;
	}

	public void setEnrollmentYear(int ey) {
		this.enrollmentYear = ey;
	}

	public int getCurrentStudyYear() {
		return currentStudyYear;
	}

	public void setCurrentStudyYear(int currentStudyYear) {
		this.currentStudyYear = currentStudyYear;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public float getAvgGrade() {
		return avgGrade;
	}

	public void setAvgGrade(float avgGrade) {
		this.avgGrade = avgGrade;
	}

	public ArrayList<ExamGrade> getGradeList() {
		return gradeList;
	}

	public void setGradeList(ArrayList<ExamGrade> gradeList) {
		this.gradeList = gradeList;
	}

	public ArrayList<Subject> getNotPassed() {
		return notPassed;
	}

	public void setNotPassed(ArrayList<Subject> notPassed) {
		this.notPassed = notPassed;
	}

}