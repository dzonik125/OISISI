package model;

public class Adress {
	private String street;
	private String city;
	private String number;
	private String state;

	public Adress(String street, String city, String number, String state) {
		super();
		this.street = street;
		this.city = city;
		this.number = number;
		this.state = state;
	}

	public Adress() {
		super();
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	

}
