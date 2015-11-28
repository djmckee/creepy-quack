package uk.co.dylanmckee.tddCoursework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by djmckee on 28/11/2015.
 */
public class AppointmentManager {
    private final List<Patient> patients = new ArrayList<Patient>();
    private final List<Appointment> appointments = new ArrayList<Appointment>();

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

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
