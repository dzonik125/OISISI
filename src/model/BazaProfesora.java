package model;
import model.Professor;
import model.Professor;

import java.util.ArrayList;
import java.util.List;

import model.Professor;

public class BazaProfesora {

	private static BazaProfesora instance = null;

	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}

	private long generator;
	
	private List<Professor> professors;
	private List<String> kolone;

	private BazaProfesora() {
		generator = 0;
	

		this.kolone = new ArrayList<String>();
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("PREDMET");
		this.kolone.add("ZVANJE");
		this.kolone.add("katedra");

	}
	
	

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setIgraci(List<Professor> professors) {
		this.professors = professors;
	}


	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Professor getRow(int rowIndex) {
		return this.professors.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {

		Professor p = this.professors.get(row);
		switch (column) {
		case 0:
			return p.getName();
		case 1:
			return p.getSurname();
		case 2:
			return p.getTitle();
		case 3:
			return p.getOffice();
		case 4:
			return String.valueOf(p.getSubjectList());
	
		default:
			return null;
		}
	}

	
	
	
}


	
	
	
	
	
	
	
	

