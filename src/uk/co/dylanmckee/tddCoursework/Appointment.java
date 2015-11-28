package uk.co.dylanmckee.tddCoursework;

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

    /**
     * Overriding the hashcode to add date, description and patient fields to it.
     *
     * @return an integer unique to the field values of this particular Appointment instance.
     */
    @Override
    public int hashCode() {
        //pick a prime number to multiply all of the fields by
        int prime = 31;

        //declare the hashcode, set it equal to a prime number
        int hashcode = 17;

        //multiply the prime by the hashcode (a prime to begin with too), then add the description's hashcode...
        hashcode = prime * hashcode + description.hashCode();

        //now multiply the prime by the hashcode again and add on the date's hashcode...
        hashcode = prime * hashcode + patient.hashCode();

        //now multiply the prime by the hashcode again and add on the date's hashcode...
        hashcode = prime * hashcode + date.hashCode();

        //and finally return our hashcode
        return hashcode;

    }


    /**
     * Overriding the standard equals method to check for equality between Appointments, checking their date, description
     * and patient fields for equality. Only if both of these fields are equal is the
     * Appointment considered equal. Overriding hashcode also to facilitate this field equality checking.
     *
     * @param o the object to compare for equality.
     * @return a boolean which will be true if the objects are equal, and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        //firstly, if the memory addresses are entirely equal, then obviously return yes...
        if (this == o) {
            return true;
        }

        //make sure the other object's not null, because they cannot be equal if so...
        if (o == null) {
            return false;
        }

        //now check the instance types, if they're not the same, there's no chance of them being equal
        if (!(o instanceof Appointment)) {
            //definitely definitely cannot be equal then...
            return false;
        }

        //okay, now let's cast object to a Appointment, and check its fields...
        Appointment otherAppointment = (Appointment) o;

        //use the overridden hashCode method of Appointment to check for field value equality...
        if (this.hashCode() == otherAppointment.hashCode()) {
            //definitely equal then...
            return true;
        }

        //otherwise, it's just not equal.
        return false;

    }

}
