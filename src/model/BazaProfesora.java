package model;

import model.Professor;
import model.Professor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import frame.MainFrame;
import model.Professor;

public class BazaProfesora {

	private static BazaProfesora instance = null;

	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}

	private List<Professor> professors;
	private List<String> kolone;
	private List<String> columns;

	private BazaProfesora() {

		this.kolone = new ArrayList<String>();
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("MAIL");
		this.kolone.add("ZVANJE");
		this.kolone.add("KATEDRA");
		this.professors = new ArrayList<Professor>();
		this.columns = new ArrayList<String>();
		this.columns.add("Šifra");
		this.columns.add("Naziv");
		this.columns.add("Godina studija");
		this.columns.add("Semestar");
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}
	

	public int getColumnCount() {
		return 5;
	}

	public int getColumnCount1() {
		return 4;
	}

	public String getColumnName1(int index) {
		return this.columns.get(index);
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public ArrayList<Subject> getProfessorSubject(Professor p) {
		return p.getSubjectList();
	}

	public Professor getRow(int rowIndex) {
		return this.professors.get(rowIndex);
	}

	public void addProfessor(Professor p) {
		professors.add(p);
	}

	public void deleteProfessorSubject(int id) {
		BazaProfesora.getInstance().getRow(MainFrame.getInstance().getDataFromSelectedRow2()).deleteSubjectFromProfessor(id);
	}
	
	public void deleteProfesor(String id) {
		for (Professor p : professors) {
			if (p.getId().equals(id)) {
				professors.remove(p);
				break;
			}
		}
	}

	public void editProfessor(int rowIndex, Professor p) {
		Professor p1 = professors.get(rowIndex);
		p1.setName(p.getName());
		p1.setSurname(p.getSurname());
		p1.setDateOfBirth(p.getDateOfBirth());
		p1.setAdress(p.getAdress());
		p1.setPhone(p.getPhone());
		p1.setMail(p.getMail());
		p1.setInternshipYear(p.getInternshipYear());
		p1.setOffice(p.getOffice());
		p1.setTitle(p.getTitle());
		p1.setId(p.getId());

	}

	public String getValueAt(int row, int column) {

		Professor p = this.professors.get(row);
		switch (column) {
		case 0:
			return p.getName();
		case 1:
			return p.getSurname();
		case 2:
			return p.getMail();
		case 3:
			return p.getTitle();
		case 4:
			return p.getOffice();

		default:
			return null;
		}
	}

	public String getValueAt1(int row, int column) {
		Subject s = BazaProfesora.getInstance().getRow(MainFrame.getInstance().getDataFromSelectedRow2())
				.getSubjectList().get(row);
		switch (column) {
		case 0:
			return String.valueOf(s.getSubjectID());
		case 1:
			return s.getSubjectName();
		case 2:
			return String.valueOf(s.getStudyYear());
		case 3:
			return String.valueOf(s.getSemester());
		default:
			return null;
		}


	}
}