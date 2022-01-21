package controllers;

import frame.MainFrame;

import model.BazaProfesora;
import model.Professor;
import model.Student;
import model.StudentBase;
import model.Subject;

public class ProfessorController {
	private static ProfessorController instance = null;

	public static ProfessorController getInstance() {
		if (instance == null) {
			instance = new ProfessorController();
		}
		return instance;
	}

	private ProfessorController() {
	}

	public void addProfessor(Professor p) {

		BazaProfesora.getInstance().addProfessor(p);
		MainFrame.getInstance().refresh2();

	}

	public void deleteProfesor(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		// izmena modela
		Professor profesor = BazaProfesora.getInstance().getRow(rowSelectedIndex);
		BazaProfesora.getInstance().deleteProfesor(profesor.getId());
		// azuriranje prikaza
		MainFrame.getInstance().refresh2();
	}

	public void editProfessor(int rowSelectedIndex, Professor p) {
		if (rowSelectedIndex < 0) {
			return;
		}
		// izmena moedla
		BazaProfesora.getInstance().editProfessor(rowSelectedIndex, p);
		// azuriranje prikaza
		MainFrame.getInstance().refresh2();
	}

	public void addSubjectToProfessor(Professor p, Subject s) {
		p.getSubjectList().add(s);
	}

	public void ddeleteSubjectFromProfessor(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}

		BazaProfesora.getInstance().deleteProfessorSubject(rowSelectedIndex);
	}

}