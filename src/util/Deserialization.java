package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import model.BazaProfesora;
import model.Professor;
import model.Student;
import model.StudentBase;
import model.Subject;
import model.SubjectBase;

public class Deserialization {
	private static Deserialization instance = null;
	private static ObjectInputStream in;

	private Deserialization() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static Deserialization getInstance() {
		if (instance == null) {
			instance = new Deserialization();
		}
		return instance;
	}
	
	public void deserializeStudent() {
		try {
		FileInputStream file = new FileInputStream("serializationStudent.txt");
		in = new ObjectInputStream(file);
		
		ArrayList<Student> object1 = new ArrayList<Student>();
		object1 = (ArrayList<Student>) in.readObject();
		StudentBase.getInstance().setStudents(object1);
		
		in.close();
		file.close();
		
		}catch(IOException e) {
			System.out.print("IOException is caught");
		}catch(ClassNotFoundException e) {
			System.out.print("ClassNotFoundException is caught");
		}
	}
	
	public void deserializeProfessor() {
		try {
		FileInputStream file = new FileInputStream("serializationProfessor.txt");
		in = new ObjectInputStream(file);
		
		ArrayList<Professor> object1 = new ArrayList<Professor>();
		object1 = (ArrayList<Professor>) in.readObject();
		BazaProfesora.getInstance().setProfessors(object1);
		
		in.close();
		file.close();
		
		}catch(IOException e) {
			System.out.print("IOException is caught");
		}catch(ClassNotFoundException e) {
			System.out.print("ClassNotFoundException is caught");
		}
	}
	
	public void deserializeSubject() {
		try {
		FileInputStream file = new FileInputStream("serializationSubject.txt");
		in = new ObjectInputStream(file);
		
		ArrayList<Subject> object1 = new ArrayList<Subject>();
		object1 = (ArrayList<Subject>) in.readObject();
		SubjectBase.getInstance().setSubjects(object1);
		
		in.close();
		file.close();
		
		}catch(IOException e) {
			System.out.print("IOException is caught");
		}catch(ClassNotFoundException e) {
			System.out.print("ClassNotFoundException is caught");
		}
	}
	
	

}
