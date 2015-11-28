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
        int id = patient.getId();
        if (getPatientById(id) != null) {
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
     * Returns a patient with the id passed to this method.
     * @param id the id number of the patient to search for.
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

    /**
     * Returns a list of patients whose names match the name string parameter exactly. An empty list will be returned
     * if no matches are found.
     * @param name the name string to match exactly.
     * @return a List of Patient objects whose names exactly match the name string.
     */
    public List<Patient> getPatientsByName(String name) {
        List<Patient> matches = new ArrayList<Patient>();

        for (Patient patient : patients) {
            String patientName = patient.getName();
            if (patientName != null && patientName.equals(name)) {
                matches.add(patient);
            }
        }

        return matches;
    }

    /**
     * Get all patients from the appointment manager.
     * @return a List of all patients.
     */
    public List<Patient> getPatients() {
        return patients;
    }

    /**
     * Get all appointments from the appointment manager.
     * @return a List of all appointments from the manager instance.
     */
    public List<Appointment> getAppointments() {
        return appointments;
    }
}
