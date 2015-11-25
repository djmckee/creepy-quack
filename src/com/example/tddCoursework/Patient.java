package com.example.tddCoursework;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Patient {
	private final int id;
	private String name;
	private String address;
	private String telephoneNumber;
	private Date dob;
	private List<Appointment> pastAppointmentList;
	
	public Patient(int id) {
		// Set the id to whatever we've been passed
		this.id = id;
		
		// Instantiate the past appointment list
		pastAppointmentList = new ArrayList<Appointment>();
		
	}

	/**
	 * Get the ID number of the patient.
	 * @return the id number
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the telephoneNumber
	 */
	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	/**
	 * @param telephoneNumber the telephoneNumber to set
	 */
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	/**
	 * @return return the DoB
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob - the new DoB
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the pastAppointmentList
	 */
	public List<Appointment> getPastAppointments() {
		return pastAppointmentList;
	}

	/**
	 * @param pastAppointment the pastAppointment to add to the list
	 */
	public void addPastAppointment(Appointment pastAppointment) {
		pastAppointmentList.add(pastAppointment);
		
	}

	
}
