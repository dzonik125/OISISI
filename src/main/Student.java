package main;

import java.util.ArrayList;
import java.util.Date;

enum Status{
	B,
	S
}

public class Student {
	private String prezime;
	private String ime;
	private Date datumRodj = new Date();
	private String adresaStan;
	private String kontaktTel;
	private String mail; 
	private String brIndeksa;
	private String godUpisa;
	private String trenutnaGodStudija;
	private Status status;
	private float prosecnaOcena;
	private ArrayList<String> spisakOcena = new ArrayList<String>();
	private ArrayList<String> spisakNepolozenihIspita = new ArrayList<String>();
}