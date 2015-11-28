package uk.co.dylanmckee.tddCoursework;

import java.util.ArrayList;
import java.util.List;


/**
 * Purpose: An AppointmentManager implementation for CSC2021 Test Driven Development work.
 * Author: Dylan McKee
 * Date: 26/11/2015
 */
public class AppointmentManager {
    /**
     * A list to store the patients in.
     */
    private final List<Patient> patients = new ArrayList<Patient>();

    /**
     * A list to store the appointments to manage in.
     */
    private final List<Appointment> appointments = new ArrayList<Appointment>();

    /**
     * Adds a patient to the patients list; after checking the ID is unique.
     * @param patient the patient to add to the patients list.
     */
    public void addPatient(Patient patient) {
        if (getPatientById(patient.getId()) != null) {
            // Patient already exists!
            throw new IllegalArgumentException("Patient already exists!");
        }

        // Patient instance is unique; add it.
        patients.add(patient);
    }

    /**
     * Adds the appointment to the appointments list.
     * @param appointment the appointment to add to the appointments list.
     */
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    /**
     *
     * @param id
     * @return the matching patient with the specified id, or null if a matching patient does not exist.
     */
    public Patient getPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }

        return null;

    }

    public List<Patient> getPatientsByName(String name) {
        List<Patient> matches = new ArrayList<Patient>();

        for (Patient patient : patients) {
            if (patient.getName() != null && patient.getName().equals(name)) {
                matches.add(patient);
            }
        }

        return matches;
    }

    public List<Patient> getPatients() {
        return patients;
    }


    public List<Appointment> getAppointments() {
        return appointments;
    }
}