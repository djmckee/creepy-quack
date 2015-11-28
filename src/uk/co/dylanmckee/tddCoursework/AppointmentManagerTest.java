package uk.co.dylanmckee.tddCoursework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Purpose: A JUnit test class to test the AppointmentManager class for CSC2021 Test Driven Development.
 * Author: Dylan McKee
 * Date: 26/11/2015
 */
public class AppointmentManagerTest extends AbstractLoggingJUnitTest {
    // A private instance of the AppointmentManager to test with; to be constructed before each test in setUp, and destroyed after each test in tearDown
    private AppointmentManager testAppointmentManager;

    // Some test data to use for test patients when testing the AppointmentManager.
    private final int TEST_PATIENT_ID = 1;
    private final String TEST_PATIENT_NAME = "Test McTest";


    @Before
    public void setUp() throws Exception {
        // Create a new AppointmentManager instance before each test.
        testAppointmentManager = new AppointmentManager();
    }

    @After
    public void tearDown() throws Exception {
        // Destroy the AppointmentManager after each test.
        testAppointmentManager = null;

    }

    /**
     * A test to ensure that the constructor correctly instantiates an AppointmentManager instance.
     */
    @Test
    public void testConstructor() {
        // Check the appointment manager has been constructed...
        assertNotNull(testAppointmentManager);

    }

    /**
     * A test to ensure that multiple appointment managers can exist at the same time; e.g. for different surgeries,
     * as required in the project specification.
     */
    @Test
    public void testCreateMultipleAppointmentManagers() {
        // Create a 2nd AppointmentManager instance, then ensure that the two aren't the same...
        AppointmentManager anotherAppointmentManager = new AppointmentManager();

        // Check they're not the same object reference, meaning that multiple unique instances can co-exist
        assertNotSame(testAppointmentManager, anotherAppointmentManager);

    }

    /**
     * A test to ensure that Patient objects can be created and added to the patient list, and also retrieved from
     * the patient list by ID.
     * Additionally, tests to ensure simple edge case/bounds checking to check for and prevent duplicate patients works.
     */
    @Test
    public void testPatientListInsertionAndRetrival() {
        Patient testPatient = new Patient(TEST_PATIENT_ID);

        // Insert patient...
        testAppointmentManager.addPatient(testPatient);

        // Retrieve patient by ID...
        Patient match = testAppointmentManager.getPatientById(TEST_PATIENT_ID);

        // Ensure the match is the patient we added...
        assertEquals(testPatient, match);

        // Now, do a simple edge case test - ensure that a duplicate patient ID cannot exist...
        Patient otherTestPatient = new Patient(TEST_PATIENT_ID);

        boolean correctExceptionRaised = false;

        try {
            testAppointmentManager.addPatient(otherTestPatient);
        } catch (IllegalArgumentException e) {
            // The illegal argument exception being thrown shows that our duplicate checking code works as expected.
            correctExceptionRaised = true;
        }

        assertTrue(correctExceptionRaised);

    }

    /**
     * A test to ensure a patient can be searched for by exact name and returned.
     */
    @Test
    public void testPatientListSearchByName() {
        Patient testPatient = new Patient(TEST_PATIENT_ID);
        testPatient.setName(TEST_PATIENT_NAME);

        // Insert patient...
        testAppointmentManager.addPatient(testPatient);

        // Retrieve patient by name... (should be the first and only object in the list)
        Patient match = testAppointmentManager.getPatientsByName(TEST_PATIENT_NAME).get(0);

        // Ensure the match is the patient we added...
        assertEquals(testPatient, match);
    }

    /**
     * A test to ensure that patient names can be changed.
     */
    @Test
    public void testPatientNameChange() {
        Patient testPatient = new Patient(TEST_PATIENT_ID);
        testPatient.setName(TEST_PATIENT_NAME);

        String newPatientName = "John Tester-McTest";

        // Insert patient...
        testAppointmentManager.addPatient(testPatient);

        // Retrieve patient by id...
        Patient match = testAppointmentManager.getPatientById(TEST_PATIENT_ID);

        // Change the name...
        match.setName(newPatientName);

        // Retrieve patient again...
        Patient matchAgain = testAppointmentManager.getPatientById(TEST_PATIENT_ID);

        // Ensure the match's name is the new name...
        assertEquals(newPatientName, matchAgain.getName());

    }

    /**
     * A test to ensure that patient addresses can be changed.
     */
    @Test
    public void testPatientAddressChange() {
        Patient testPatient = new Patient(TEST_PATIENT_ID);
        testPatient.setAddress("Claremont Tower, Newcastle-upon-Tyne");

        String newPatientAddress = "1 Infinite Loop, Cupertino, CA";

        // Insert patient...
        testAppointmentManager.addPatient(testPatient);

        // Retrieve patient by id...
        Patient match = testAppointmentManager.getPatientById(TEST_PATIENT_ID);

        // Change the name...
        match.setAddress(newPatientAddress);

        // Retrieve patient again...
        Patient matchAgain = testAppointmentManager.getPatientById(TEST_PATIENT_ID);

        // Ensure the match's name is the new name...
        assertEquals(newPatientAddress, matchAgain.getAddress());

    }

    /**
     * A test to ensure new appointments can be added for patients given their ID.
     */
    @Test
    public void testAddNewAppointment() {
        // Create a test appointment with test patient associated with it.
        Appointment appointment = new Appointment();
        appointment.setDate(new Date());
        appointment.setDescription("A test!");

        Patient patient = new Patient(TEST_PATIENT_ID);
        patient.setName(TEST_PATIENT_NAME);
        appointment.setPatient(patient);

        // Add the test appointment!
        testAppointmentManager.addAppointment(appointment);

        // Get the appointment list, ensure it's in there...
        List<Appointment> appointmentList = testAppointmentManager.getAppointments();

        boolean appointmentAdded = false;

        for (Appointment a : appointmentList) {
            if (a.equals(appointment)) {
                appointmentAdded = true;
            }
        }

        assertTrue(appointmentAdded);

    }

}
