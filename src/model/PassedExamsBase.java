package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PassedExamsBase {
	private static PassedExamsBase instance = null;
	
	public static PassedExamsBase getInstance() {
		if(instance == null) {
			instance = new PassedExamsBase();
		}
		return instance;
	}
	
	private List<ExamGrade> grades;
	private List<String> columns;
	
	
	private PassedExamsBase() {
		this.columns = new ArrayList<String>();
		this.columns.add("Šifra predmeta");
		this.columns.add("Naziv predmeta");
		this.columns.add("ESPB");
		this.columns.add("Ocena");
		this.columns.add("Datum");
		this.grades = new ArrayList<ExamGrade>();
	}


	public List<ExamGrade> getGrades() {
		return grades;
	}


	public List<String> getColumns() {
		return columns;
	}
	
	public String getColumnName(int index) {
		return this.columns.get(index);
	}
	
	public ExamGrade getRow(int rowIndex) {
		return this.grades.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {

		ExamGrade g = this.grades.get(row);
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
	
}
