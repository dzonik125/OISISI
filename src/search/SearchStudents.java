package search;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import frame.MainFrame;
import model.Student;
import model.StudentBase;

public class SearchStudents {

	private static SearchStudents instance = null;
	public boolean flag;

	public static SearchStudents getInstance() {
		if (instance == null) {
			instance = new SearchStudents();
		}
		return instance;
	}

	public List<Student> searchList;
	public List<Student> remove;

	public SearchStudents() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void searchStudents(String search) {
		searchList = new ArrayList<Student>(StudentBase.getInstance().getStudents());
		remove = new ArrayList<Student>();
		String[] splitted = search.split(", ");
		
		if(splitted[0].isBlank()) {
			flag = true;
		}else {
			flag = false;
		}

		for (Student s : searchList) {
			if (splitted.length == 1) {
				if (!s.getSurname().toUpperCase().contains(splitted[0].toUpperCase())) {
					remove.add(s);
				}
			} else if (splitted.length == 2) {
				if (!s.getSurname().toUpperCase().contains(splitted[0].toUpperCase())) {
					remove.add(s);
				} else if (!s.getName().toUpperCase().contains(splitted[1].toUpperCase())) {
					remove.add(s);
				}
			} else if (splitted.length == 3) {
				if (!s.getSurname().toUpperCase().contains(splitted[0].toUpperCase())) {
					remove.add(s);
				} else if (!s.getName().toUpperCase().contains(splitted[1].toUpperCase())) {
					remove.add(s);
				} else if (!s.getIndex().toUpperCase().contains(splitted[2].toUpperCase())) {
					remove.add(s);
				}
			}
		}

		searchList.removeAll(remove);
		
		if(searchList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nema Studenata!", "Pretraga", JOptionPane.WARNING_MESSAGE, null);
		}else {
			StudentBase.getInstance().setStudents(searchList);
			MainFrame.getInstance().refresh();
		}

	}

}
