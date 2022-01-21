package search;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import frame.MainFrame;
import model.Subject;
import model.SubjectBase;

public class SearchSubjects {

	private static SearchSubjects instance = null;
	public boolean flag;

	public static SearchSubjects getInstance() {
		if (instance == null) {
			instance = new SearchSubjects();
		}
		return instance;
	}

	public List<Subject> searchList;
	public List<Subject> remove;

	public SearchSubjects() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void searchSubjects(String search) {
		searchList = new ArrayList<Subject>(SubjectBase.getInstance().getSubjects());
		remove = new ArrayList<Subject>();
		String[] splitted = search.split(", ");
		

		
		if(splitted[0].isBlank()) {
			flag = true;
		}else {
			flag = false;
		}

		for (Subject s : searchList) {
			if (splitted.length == 1) {
				if (!s.getSubjectName().toUpperCase().contains(splitted[0].toUpperCase())) {
					remove.add(s);
				} else if (splitted.length == 2) {
					if (!s.getSubjectName().toUpperCase().contains(splitted[0].toUpperCase())) {
						remove.add(s);
					} else if (!s.getSubjectID().toUpperCase().contains(splitted[1].toUpperCase())) {
						remove.add(s);
					}
				} 		
			
				
				
				
			}
		}

		searchList.removeAll(remove);
		
		if(searchList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nema predmeta!", "Pretraga", JOptionPane.WARNING_MESSAGE, null);
		}else {
			SubjectBase.getInstance().setSubjects(searchList);
			MainFrame.getInstance().refresh1();
		}

	}

}
