package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class NotPassedExamsBase {
	private static NotPassedExamsBase instance = null;

	public static NotPassedExamsBase getInstance() {
		if (instance == null) {
			instance = new NotPassedExamsBase();
		}
		return instance;
	}

	private List<Subject> exams;
	private List<String> columns;

	private NotPassedExamsBase() {
		this.columns = new ArrayList<String>();
		this.columns.add("Šifra predmeta");
		this.columns.add("Naziv predmeta");
		this.columns.add("ESPB");
		this.columns.add("Godina studija");
		this.columns.add("Semestar");
		this.exams = new ArrayList<Subject>();
	}

	public List<Subject> getNotPassedExams() {
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
