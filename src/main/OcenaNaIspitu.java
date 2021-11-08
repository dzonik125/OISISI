package main;

import java.util.Date;

public class OcenaNaIspitu {
	private String studentPolozio;
	private String predmet;
	private int ocena;
	private Date datumPolaganja;
	
	public void setOcena(int a) {
		if (a >= 6 && a <= 10) {
			ocena = a;
		} else {
			throw new IllegalArgumentException("Broj je van opsega");
		} 
	}
}