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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getInternshipYear() {
		return internshipYear;
	}
	public void setInternshipYear(int internshipYear) {
		this.internshipYear = internshipYear;
	}
	public ArrayList<Subject> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(ArrayList<Subject> subjectList) {
		this.subjectList = subjectList;
	}

}