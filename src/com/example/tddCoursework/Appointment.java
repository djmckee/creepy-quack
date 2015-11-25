package com.example.tddCoursework;

import java.util.Date;

public class Appointment {
	private Date date;
	private String description;
	private Patient patient;
	
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
		
	}
	
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
		
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
		
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
		
	}
	
	/**
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
		
	}
	
	/**
	 * @param patient the patient to set
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
		
	}

}
