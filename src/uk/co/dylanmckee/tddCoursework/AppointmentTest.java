package uk.co.dylanmckee.tddCoursework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Purpose: A JUnit test class to test the Appointment model class for CSC2021 Test Driven Development.
 * Author: Dylan McKee
 * Date: 26/11/2015
 */
public class AppointmentTest extends AbstractLoggingJUnitTest {

    // Some constants to use in the testing of the Appointment class fields.
    private static final String TEST_DESCRIPTION = "A test appointment!";
    private static final Date TEST_DATE = new Date();
    private static final Patient TEST_PATIENT = new Patient(1);

    // A private instance of the Appointment to test with; to be constructed before each test in setUp, and destroyed after each test in tearDown
    private Appointment testAppointment;

    @Before
    public void setUp() throws Exception {
        // Create a testing instance of Appointment before each test.
        testAppointment = new Appointment();

    }

    @After
    public void tearDown() throws Exception {
        // Destroy the appointment after each test.
        testAppointment = null;

    }

    /**
     * Ensure the Appointment constructor correctly instantiates a new appointment.
     */
    @Test
    public void testConstructor() {
        // Ensure the test Appointment instance exists and was constructed properly...
        assertNotNull(testAppointment);

    }

    /**
     * Ensure the appointment description can be set and retrieved.
     */
    @Test
    public void testDescriptionSetAndGet() {
        // Set the appointment description...
        testAppointment.setDescription(TEST_DESCRIPTION);

        // Get the appointment description...
        String description = testAppointment.getDescription();

        // Check equality
        assertEquals(TEST_DESCRIPTION, description);

    }

    /**
     * Ensure the appointment date can be set and retrieved.
     */
    @Test
    public void testDateSetAndGet() {
        // Set the appointment date...
        testAppointment.setDate(TEST_DATE);

        // Get the date...
        Date date = testAppointment.getDate();

        // Check equality
        assertEquals(TEST_DATE, date);

    }

    /**
     * Ensure the patient reference for the appointment can be set and retrieved.
     */
    @Test
    public void testPatientSetAndGet() {
        // Set the appointment's associated patient...
        testAppointment.setPatient(TEST_PATIENT);

        // Get the appointment's associated patient...
        Patient thePatient = testAppointment.getPatient();

        // Check that the patient is equal...
        assertEquals(TEST_PATIENT, thePatient);

    }

    /**
     * Ensure that two Appointment instances with identical fields are marked as being equal to each other.
     */
    @Test
    public void testEquals() {
        // Set some test values for the test appointment instance, to compare to...
        testAppointment.setDate(TEST_DATE);
        testAppointment.setDescription(TEST_DESCRIPTION);
        testAppointment.setPatient(TEST_PATIENT);

        // Create an appointment with equal values to the test appointment...
        Appointment anotherAppointment = new Appointment();
        anotherAppointment.setDate(TEST_DATE);
        anotherAppointment.setDescription(TEST_DESCRIPTION);
        anotherAppointment.setPatient(TEST_PATIENT);

        assertEquals(testAppointment, anotherAppointment);

    }


}
