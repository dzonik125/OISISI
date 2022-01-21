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
		this.columns.add("�ifra predmeta");
		this.columns.add("Naziv predmeta");
		this.columns.add("Semestar");
		this.columns.add("Godina studija u kojoj se predmet izvodi");
		this.columns.add("ESPB");
		this.subjects = new ArrayList<Subject>();
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void addSubject(Subject s) {
		subjects.add(s);
	}

	public void deleteSubject(String subjectID) {
		for (Subject s : subjects) {
			if (s.getSubjectID().equals(subjectID)) {
				subjects.remove(s);
				break;

			}

		}

	}

	public void editSubject(int rowIndex, Subject s) {
		Subject s1 = subjects.get(rowIndex);
		s1.setSubjectName(s.getSubjectName());
		s1.setSubjectID(s.getSubjectID());
		s1.setEspb(s.getEspb());
		s1.setFailed(s.getFailed());
		s1.setPassed(s.getPassed());
		s1.setSemester(s.getSemester());
		s1.setStudyYear(s.getStudyYear());
		s1.setSubjectProfessor(s.getSubjectProfessor());
	}

	public String getColumnName(int index) {
		return this.columns.get(index);
	}

	public Subject getRow(int rowIndex) {
		return this.subjects.get(rowIndex);
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
			return String.valueOf(s.getEspb());
		default:
			return null;
		}
	}

}
