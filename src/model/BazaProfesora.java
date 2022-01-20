package model;
import model.Professor;
import model.Professor;

import java.util.ArrayList;
import java.util.Date;
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


	
	private List<Professor> professors;
	private List<String> kolone;

	private BazaProfesora() {
	

		this.kolone = new ArrayList<String>();
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("MAIL");
		this.kolone.add("ZVANJE");
		this.kolone.add("KATEDRA");
		this.professors = new ArrayList<Professor>();
		
		
		
		Professor p = new Professor( "Nikola", "Kolarov", new Date(), new Adress("Laze Kostica", "Kovilj", "77", "Srbija"), "45336", "dzonik125@gmail.com", "algebra", "2343","doktor",4);
		
		professors.add(p);
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
	
	public void addProfessor(Professor p) {
		professors.add(p);
	}
	
	public void deleteProfesor(String id) {
		for (Professor p: professors) {
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

	
	
	
}


	
	
	
	
	
	
	
	

