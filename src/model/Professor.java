package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Professor implements Serializable{

	public Professor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Professor(String name, String surname, Date dateOfBirth, Adress adress, String phone, String mail,
			String office, String id, String title, int internshipYear) {
		super();
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.adress = adress;
		this.phone = phone;
		this.mail = mail;
		this.office = office;
		this.id = id;
		this.title = title;
		this.internshipYear = internshipYear;
		this.subjectList = new ArrayList<Subject>();
	}

	public Professor(Professor prof) {
		// TODO Auto-generated constructor stub
		super();
		this.name = prof.getName();
		this.surname = prof.getSurname();
		this.dateOfBirth = prof.getDateOfBirth();
		this.adress = prof.getAdress();
		this.phone = prof.getPhone();
		this.mail = prof.getMail();
		this.office = prof.getOffice();
		this.id = prof.getId();
		this.title = prof.getTitle();
		this.internshipYear = prof.getInternshipYear();
		this.subjectList = new ArrayList<Subject>();
	}

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

	public void deleteSubjectFromProfessor(int index) {
		subjectList.remove(index);
	}

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