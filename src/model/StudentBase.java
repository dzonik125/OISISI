package model;

import java.util.ArrayList;
import java.util.List;

import model.Student.Status;

public class StudentBase {

	private static StudentBase instance = null;

	public static StudentBase getInstance() {
		if (instance == null) {
			instance = new StudentBase();
		}
		return instance;
	}

	private List<Student> students;
	private List<String> columns;

	private StudentBase() {
		this.columns = new ArrayList<String>();
		this.columns.add("Indeks");
		this.columns.add("Ime");
		this.columns.add("Prezime");
		this.columns.add("Godina studija");
		this.columns.add("Status");
		this.columns.add("Prosek");
		this.students = new ArrayList<Student>();
	}

	public List<Student> getStudents() {
		return students;
	}

	public String getColumnName(int index) {
		return this.columns.get(index);
	}

	public Student getRow(int rowIndex) {
		return this.students.get(rowIndex);
	}

	public void addStudent(Student s) {
		students.add(s);
	}

	public void editStudent(int rowIndex, Student s) {
		Student s1 = students.get(rowIndex);
		s1.setName(s.getName());
		s1.setSurname(s.getSurname());
		s1.setIndex(s.getIndex());
		s1.setBirthDate(s.getBirthDate());
		s1.setAdress(s.getAdress());
		s1.setContact(s.getContact());
		s1.setMail(s.getMail());
		s1.setEnrollmentYear(s.getEnrollmentYear());
		s1.setCurrentStudyYear(s.getCurrentStudyYear());
		s1.setStatus(s.getStatus());
		s1.setAvgGrade(s.getAvgGrade());
	}

	public void deleteStudent(String index) {
		for (Student s : students) {
			if (s.getIndex().equals(index)) {
				students.remove(s);
				break;
			}
		}
	}

	public String getValueAt(int row, int column) {

		Student s = this.students.get(row);
		switch (column) {
		case 0:
			return s.getIndex();
		case 1:
			return s.getName();
		case 2:
			return s.getSurname();
		case 3:
			return String.valueOf(s.getCurrentStudyYear());
		case 4:
			return String.valueOf(s.getStatus());
		case 5:
			return String.valueOf(s.getAvgGrade());
		default:
			return null;
		}
	}

	public boolean findByIndex(String ind) {
		for (Student s1 : students) {
			if (ind.equals(s1.getIndex()))

				return true;
		}
		return false;
	}
}
