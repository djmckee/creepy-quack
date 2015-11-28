package uk.co.dylanmckee.tddCoursework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Purpose: A JUnit test class to test the Patient model class for CSC2021 Test Driven Development.
 * Author: Dylan McKee
 * Date: 26/11/2015
 */
public class PatientTest extends AbstractLoggingJUnitTest {

    // Some constants to use in the testing of the Patient class' fields.
    private static final int TEST_PATIENT_ID = 1;
    private static final String TEST_NAME = "Ringo Starr";
    private static final String TEST_ADDRESS = "1 Abbey Road, Smethwick, West Midlands B67 5RD";
    private static final String TEST_PHONE = "0800001066";

    // Used http://www.epochconverter.com/ to convert Ringo Starr's birthday (7th July 1940, 12 noon), from date to epoch to use Java's Date class constructor
    // The Epoch timestamp is: -930484800
    private static final Date TEST_DOB = new Date(-930484800);

    // A private instance of the Patient to test with; to be constructed before each test in setUp, and destroyed after each test in tearDown
    private Patient testPatient;

    @Before
    public void setUp() throws Exception {
        // Instantiate a new patient object for testing before each test is ran.
        testPatient = new Patient(TEST_PATIENT_ID);

    }

    @After
    public void tearDown() throws Exception {
        // Destroy test patient after each test is ran.
        testPatient = null;

    }

    /**
     * Ensure the Patient constructor correctly instantiates a new patient object.
     */
    @Test
    public void testConstructor() {
        // Ensure the test object was created correctly...
        assertNotNull(testPatient);

    }

    /**
     * Ensures that the patient ID is set correctly.
     */
    @Test
    public void testIdGet() {
        // Ensure the test ID equals the constant we intend it to...
        int id = testPatient.getId();
        assertEquals(TEST_PATIENT_ID, id);

    }


    /**
     * Ensures that patient name can be set and retrieved correctly.
     */
    @Test
    public void testNameSetAndGet() {
        // Set the name...
        testPatient.setName(TEST_NAME);

        // Get the name...
        String name = testPatient.getName();

        // Check equality
        assertEquals(TEST_NAME, name);
    }

    /**
     * Ensures patient address can be set and retrieved correctly.
     */
    @Test
    public void testAddressSetAndGet() {
        // Set the address...
        testPatient.setAddress(TEST_ADDRESS);

        // Get the address...
        String address = testPatient.getAddress();

        // Check equality
        assertEquals(TEST_ADDRESS, address);

    }

    /**
     * Ensures patient telephone number can be set and retrieved correctly.
     */
    @Test
    public void testPhoneNumberSetAndGet() {
        // Set the phone number...
        testPatient.setTelephoneNumber(TEST_PHONE);

        // Get the phone number...
        String phoneNumber = testPatient.getTelephoneNumber();

        // Check equality
        assertEquals(TEST_PHONE, phoneNumber);


    }

    /**
     * Ensures the patient date of birth can be set and retrieved correctly.
     */
    @Test
    public void testDobSetAndGet() {
        // Set the dob...
        testPatient.setDob(TEST_DOB);

        // Get the dob...
        Date dob = testPatient.getDob();

        // Check equality
        assertEquals(TEST_DOB, dob);

    }

    /**
     * Ensures past appointments can be added to the patient's list of past appointments,
     * and retrieved back from it correctly
     */
    @Test
    public void testPastAppointmentListInsertionAndRetrieval() {
        // Create a new appointment...
        Appointment pastAppointment = new Appointment();
        pastAppointment.setDate(new Date());

        // Add it to the list...
        testPatient.addPastAppointment(pastAppointment);

        // Ensure the list contains the added past appointment...
        List<Appointment> appointments = testPatient.getPastAppointments();

        boolean containsPastAppointment = appointments.contains(pastAppointment);

        // Flag bool will be set if the list contains said object.
        assertTrue(containsPastAppointment);


    }

    /**
     * Ensures that two patient objects with identical field values are known to be equal.
     */
    @Test
    public void testEquals() {
        // Seed the current patient with test data
        testPatient.setName(TEST_NAME);
        testPatient.setAddress(TEST_ADDRESS);
        testPatient.setTelephoneNumber(TEST_PHONE);
        testPatient.setDob(TEST_DOB);

        // Create a patient with equal fields to test equality with...
        Patient otherPatient = new Patient(TEST_PATIENT_ID);
        otherPatient.setName(TEST_NAME);
        otherPatient.setAddress(TEST_ADDRESS);
        otherPatient.setTelephoneNumber(TEST_PHONE);
        otherPatient.setDob(TEST_DOB);

        // Check they're equal...
        assertEquals(testPatient, otherPatient);

    }

}
