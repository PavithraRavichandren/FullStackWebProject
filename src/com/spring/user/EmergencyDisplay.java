package com.spring.user;

public class EmergencyDisplay {
	private String name;
	private String address;
	private Medication medication;
	public Medication getMedication() {
		return medication;
	}
	public void setMedication(Medication medication) {
		this.medication = medication;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public EmergencyDisplay(String name, String address, Medication medication) {
		super();
		this.name = name;
		this.address = address;
		this.medication = medication;
	}
	public EmergencyDisplay() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
