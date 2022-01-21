package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.BazaProfesora;
import model.StudentBase;
import model.SubjectBase;

public class Serialization {
	private static Serialization instance = null;
	private static ObjectOutputStream oos;

	private Serialization() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static Serialization getInstance() {
		if (instance == null) {
			instance = new Serialization();
		}
		return instance;
	}
	
	public void serializeStudent() {
		File f = new File("serializationStudent.txt");
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(StudentBase.getInstance().getStudents());	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void serializeProfessor() {
		File f = new File("serializationProfessor.txt");
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(BazaProfesora.getInstance().getProfessors());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void serializeSubject() {
		File f = new File("serializationSubject.txt");
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(SubjectBase.getInstance().getSubjects());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
