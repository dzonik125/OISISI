package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import frame.MainFrame;

public class NotPassedExamsBase {

	private List<Subject> exams;
	private List<String> columns;

	public NotPassedExamsBase(Student St) {
		this.columns = new ArrayList<String>();
		this.columns.add("Šifra predmeta");
		this.columns.add("Naziv predmeta");
		this.columns.add("ESPB");
		this.columns.add("Godina studija");
		this.columns.add("Semestar");
		this.exams = new ArrayList<Subject>();
		exams.add(SubjectBase.getInstance().getSubjects().get(0));
	}

	public List<Subject> getNotPassedExams(Student s) {
		return exams;
	}

	public List<String> getColumns() {
		return columns;
	}

	public String getColumnName(int index) {
		return this.columns.get(index);
	}

	public Subject getRow(int rowIndex) {
		return this.exams.get(rowIndex);
	}

	public void deleteExam(int id) {
		for (Subject sbj : exams) {
			if (sbj.getSubjectID() == id) {
				exams.remove(sbj);
				break;
			}
		}
	}
	
	public void addExam(Subject s) {
		exams.add(s);
	}

	public String getValueAt(int row, int column) {
		Subject s = this.exams.get(row);

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

}
