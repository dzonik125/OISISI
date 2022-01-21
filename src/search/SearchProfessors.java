package search;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import frame.MainFrame;
import model.Professor;
import model.BazaProfesora;

public class SearchProfessors {

	private static SearchProfessors instance = null;
	public boolean flag;

	public static SearchProfessors getInstance() {
		if (instance == null) {
			instance = new SearchProfessors();
		}
		return instance;
	}

	public List<Professor> searchList;
	public List<Professor> remove;

	public SearchProfessors() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void searchProfessors(String search) {
		searchList = new ArrayList<Professor>(BazaProfesora.getInstance().getProfessors());
		remove = new ArrayList<Professor>();
		String[] splitted = search.split(", ");
		
		if(splitted[0].isBlank()) {
			flag = true;
		}else {
			flag = false;
		}

		for (Professor p : searchList) {
			if (splitted.length == 1) {
				if (!p.getSurname().toUpperCase().contains(splitted[0].toUpperCase())) {
					remove.add(p);
				}
			} else if (splitted.length == 2) {
				if (!p.getSurname().toUpperCase().contains(splitted[0].toUpperCase())) {
					remove.add(p);
				} else if (!p.getName().toUpperCase().contains(splitted[1].toUpperCase())) {
					remove.add(p);
				}
			
				
			}
		}

		searchList.removeAll(remove);
		
		if(searchList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nema Profesora!", "Pretraga", JOptionPane.WARNING_MESSAGE, null);
		}else {
			BazaProfesora.getInstance().setProfessors(searchList);
			MainFrame.getInstance().refresh2();
		}

	}

}
