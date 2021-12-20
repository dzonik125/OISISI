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
		students.add(new Student("ra-132-2019", "Nikola", "Kolarov", 3, Status.B, (float)7.11));
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

	public void deleteStudent(String index) {
		for(Student s: students) {
			if(s.getIndex().equals(index)) {
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

}
