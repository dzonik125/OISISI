package controllers;

import frame.MainFrame;
import model.Student;
import model.BazaProfesora;

public class ProfessorController {
	private static ProfessorController instance = null;
	
	public static ProfessorController getInstance() {
		if(instance == null) {
			instance = new ProfessorController();
		}
		return instance;
	}
	
	private ProfessorController() {}
}