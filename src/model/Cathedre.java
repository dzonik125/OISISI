package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Cathedre implements Serializable{
	private int cathedreID;
	private String cathedreName;
	private Professor cathedreHead;
	private ArrayList<Professor> profList = new ArrayList<Professor>();
}
