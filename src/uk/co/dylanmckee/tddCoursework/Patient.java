package uk.co.dylanmckee.tddCoursework;

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

    /**
     * Overriding the hashcode to add name, address, telephone number, DoB and past appointment fields to it.
     *
     * @return an integer unique to the field values of this particular Patient instance.
     */
    @Override
    public int hashCode() {
        //pick a prime number to multiply all of the fields by
        int prime = 31;

        //declare the hashcode, set it equal to a prime number
        int hashcode = 17;

        //multiply the prime by the hashcode (a prime to begin with too), then add patient ID...
        hashcode = prime * hashcode + id;

        //now multiply the prime by the hashcode again and add on the address' hashcode...
        hashcode = prime * hashcode + name.hashCode();

        //now multiply the prime by the hashcode again and add on the address' hashcode...
        hashcode = prime * hashcode + address.hashCode();

        //now multiply the prime by the hashcode again and add on the telephone number's hashcode...
        hashcode = prime * hashcode + telephoneNumber.hashCode();

        //now multiply the prime by the hashcode again and add on the DoB's hashcode...
        hashcode = prime * hashcode + dob.hashCode();

        //now multiply the prime by the hashcode again and add on the past appointment array's hashcode...
        hashcode = prime * hashcode + pastAppointmentList.hashCode();

        //and finally return our hashcode
        return hashcode;

    }


    /**
     * Overriding the standard equals method to check for equality between Patients, checking their id, name, address,
     * telephone number, DoB and past appointments fields for equality. Only if both of these fields are equal is the
     * Patient considered equal. Overriding hashcode also to facilitate this field equality checking.
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
        if (!(o instanceof Patient)) {
            //definitely definitely cannot be equal then...
            return false;
        }

        //okay, now let's cast object to a Patient, and check its fields...
        Patient otherPatient = (Patient) o;

        //use the overridden hashCode method of Appointment to check for field value equality...
        if (this.hashCode() == otherPatient.hashCode()) {
            //definitely equal then...
            return true;
        }

        //otherwise, it's just not equal.
        return false;

    }

}
