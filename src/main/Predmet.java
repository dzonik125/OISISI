package main;

import java.util.ArrayList;

enum Semestar{
	ZIMSKI,
	LETNJI
}

public class Predmet {
	private int sifraPredmeta;
	private String nazivPredmeta;
	private Semestar semestar;
	private int godStudija;
	private String predmetniProf;
	private int espb;
	private ArrayList<String> spisakPolozili = new ArrayList<String>();
	private ArrayList<String> spisakNisuPolozili = new ArrayList<String>();
}