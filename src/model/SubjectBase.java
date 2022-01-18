package model;

import java.util.ArrayList;
import java.util.List;

public class SubjectBase {
	private static SubjectBase instance = null;

	public static SubjectBase getInstance() {
		if (instance == null) {
			instance = new SubjectBase();
		}
		return instance;
	}
	
	private List<Subject> subjects;
	private List<String> columns;
	
	private SubjectBase() {
		this.columns = new ArrayList<String>();
		this.columns.add("Šifra predmeta");
		this.columns.add("Naziv predmeta");
		this.columns.add("Semestar");
		this.columns.add("Godina studija u kojoj se predmet izvodi");
		this.columns.add("Predmetni profesor");
		this.columns.add("ESPB");
		this.subjects = new ArrayList<Subject>();
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void addSubject(Subject s) {
		subjects.add(s);
	}
	
	public String getColumnName(int index) {
		return this.columns.get(index);
	}
	
	public String getValueAt(int row, int column) {

		Subject s = this.subjects.get(row);
		switch (column) {
		case 0:
			return String.valueOf(s.getSubjectID());
		case 1:
			return s.getSubjectName();
		case 2:
			return String.valueOf(s.getSemester());
		case 3:
			return String.valueOf(s.getStudyYear());
		case 4:
			return String.valueOf(s.getSubjectProfessor());
		case 5:
			return String.valueOf(s.getEspb());
		default:
			return null;
		}
	}
	
}
