package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import frame.MainFrame;

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
	private List<String> columns1; // Polozeni
	private List<String> columns2; // Nepolozeni

	private StudentBase() {
		this.columns = new ArrayList<String>();
		this.columns.add("Indeks");
		this.columns.add("Ime");
		this.columns.add("Prezime");
		this.columns.add("Godina studija");
		this.columns.add("Status");
		this.columns.add("Prosek");
		this.columns1 = new ArrayList<String>();
		this.columns1.add("Šifra predmeta");
		this.columns1.add("Naziv predmeta");
		this.columns1.add("ESPB");
		this.columns1.add("Ocena");
		this.columns1.add("Datum");
		this.columns2 = new ArrayList<String>();
		this.columns2.add("Šifra predmeta");
		this.columns2.add("Naziv predmeta");
		this.columns2.add("ESPB");
		this.columns2.add("Godina studija");
		this.columns2.add("Semestar");
		this.students = new ArrayList<Student>();
		Student s = new Student("ra-132-2019", "Nikola", "Kolarov", new Date(),
				new Adress("Laze Kostica", "Kovilj", "77", "Srbija"), 3, Student.Status.B, (float) 7.53, "0621016150",
				"dzonik125@gmail.com", 2019);
		ArrayList<Subject> subjs = new ArrayList<Subject>();
		subjs.add(new Subject(12, "Algebra", Subject.Semester.Letnji, 1, 8));
		s.setNotPassed(subjs);
		students.add(s);
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public ArrayList<Subject> getNotPassedExams(Student s) {
		return s.getNotPassed();
	}

	public List<ExamGrade> getGrades(Student s) {
		return s.getGradeList();
	}

	public List<Student> getStudents() {
		return students;
	}

	public List<String> getColumns() {
		return columns;
	}

	public List<String> getColumns1() {
		return columns1;
	}

	public List<String> getColumns2() {
		return columns2;
	}

	public String getColumnName(int index) {
		return this.columns.get(index);
	}

	public String getColumnName1(int index) {
		return this.columns1.get(index);
	}

	public String getColumnName2(int index) {
		return this.columns2.get(index);
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

	public void deleteExam(int id) {
		for (Subject sbj : StudentBase.getInstance().getRow(MainFrame.getInstance().getDataFromSelectedRow())
				.getNotPassed()) {
			if (sbj.getSubjectID() == id) {
				StudentBase.getInstance().getRow(MainFrame.getInstance().getDataFromSelectedRow())
						.deleteSubjectFromNotPassed(sbj);
				;
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

	public String getValueAt1(int row, int column) {
		Student st = new Student(StudentBase.getInstance().getRow(MainFrame.getInstance().getDataFromSelectedRow()));
		ExamGrade g = st.getGradeList().get(row);
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd.MM.yyyy.");
		String dt = formatter1.format(g.getExamDate());
		switch (column) {
		case 0:
			return String.valueOf(g.getSubject().getSubjectID());
		case 1:
			return g.getSubject().getSubjectName();
		case 2:
			return String.valueOf(g.getSubject().getEspb());
		case 3:
			return String.valueOf(g.getGrade());
		case 4:
			return dt;
		default:
			return null;
		}
	}

	public String getValueAt2(int row, int column) {
		Subject s = StudentBase.getInstance().getRow(MainFrame.getInstance().getDataFromSelectedRow()).getNotPassed()
				.get(row);
		System.out.println(s.getSubjectName());
		switch (column) {
		case 0:
			return String.valueOf(s.getSubjectID());
		case 1:
			return s.getSubjectName();
		case 2:
			return String.valueOf(s.getEspb());
		case 3:
			return String.valueOf(s.getStudyYear());
		case 4:
			return String.valueOf(s.getSemester());
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
