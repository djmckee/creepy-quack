package uk.co.dylanmckee.tddCoursework;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Purpose: A simple model class to model a Patient.
 * Author: Dylan McKee
 * Date: 26/11/2015
 */
public class Patient {
    /**
     * The id of the patient, to be passed and set only once in the constructor.
     */
    private final int id;

    /**
     * The full name of the patient, as a string.
     */
    private String name;

    /**
     * The street address of the patient, as a string.
     */
    private String address;

    /**
     * The telephone number of the patient, stored as a string.
     */
    private String telephoneNumber;

    /**
     * The patient's date of birth, stored as a Java Date object.
     */
    private Date dob;

    /**
     * A list of past appointments (Appointment objects) for the patient.
     */
    private final List<Appointment> pastAppointmentList  = new ArrayList<Appointment>();

    /**
     * The constructor accepts a patient id and constructs a new Patient instance.
     * @param id the id of the patient, as an integer.
     */
    public Patient(int id) {
        // Set the id to whatever we've been passed
        this.id = id;

    }

    /**
     * Get the patient ID (no setter as this field is final & immutable)
     * @return the id number
     */
    public int getId() {
        return id;
    }

    /**
     * Get the patient's full name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the patient's full name
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the patient's street address
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the patient's street address
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get the patient's phone number
     * @return the telephoneNumber
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * Set the patient's phone number
     * @param telephoneNumber the telephoneNumber to set
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    /**
     * Get the patient's date of birth
     * @return return the DoB
     */
    public Date getDob() {
        return dob;
    }

    /**
     * Set the patient's date of birth
     * @param dob - the new DoB
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * Returns a list of past appointments attended by this patient.
     * @return the pastAppointmentList
     */
    public List<Appointment> getPastAppointments() {
        return pastAppointmentList;
    }

    /**
     * Adds a past appointment to the list of past appointments for the patient.
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
        if (name != null) hashcode = prime * hashcode + name.hashCode();

        //now multiply the prime by the hashcode again and add on the address' hashcode...
        if (address != null) hashcode = prime * hashcode + address.hashCode();

        //now multiply the prime by the hashcode again and add on the telephone number's hashcode...
        if (telephoneNumber != null) hashcode = prime * hashcode + telephoneNumber.hashCode();

        //now multiply the prime by the hashcode again and add on the DoB's hashcode...
        if (dob != null) hashcode = prime * hashcode + dob.hashCode();

        //now multiply the prime by the hashcode again and add on the past appointment array's hashcode...
        if (pastAppointmentList != null) hashcode = prime * hashcode + pastAppointmentList.hashCode();

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
        if (hashCode() == otherPatient.hashCode()) {
            //definitely equal then...
            return true;
        }

        //otherwise, it's just not equal.
        return false;

    }

}
