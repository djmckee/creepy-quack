package uk.co.dylanmckee.tddCoursework;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PatientTest extends AbstractLoggingJUnitTest {
	// A private instance of the Patient to test with; to be constructed before each test in setUp, and destroyed after each test in tearDown
	private Patient testPatient;
	
	// Some constants to use in the testing of the Patient class' fields.
	private static final int TEST_PATIENT_ID = 1;
	private static final String TEST_NAME = "Ringo Starr";
	private static final String TEST_ADDRESS = "1 Abbey Road, Smethwick, West Midlands B67 5RD";
	private static final String TEST_PHONE = "0800001066";
	// Used http://www.epochconverter.com/ to convert Ringo Starr's birthday (7th July 1940, 12 noon), from date to epoch to use Java's Date class constructor
	// The Epoch timestamp is: -930484800
	private static final Date TEST_DOB = new Date(-930484800);
	
	@Before
	public void setUp() throws Exception {
		// Instantiate a new patient object for testing
		testPatient = new Patient(TEST_PATIENT_ID);
		
	}

	@After
	public void tearDown() throws Exception {
		// Destroy test patient.
		testPatient = null;
		
	}

	@Test
	public void testConstructor() {
		// Ensure the test object was created correctly...
		assertNotNull(testPatient);

	}
	
	@Test
	public void testIdGet() {
		// Ensure the test ID equals the constant we intend it to...
		assertEquals(TEST_PATIENT_ID, testPatient.getId());

	}
	

	@Test
	public void testNameSetAndGet() {
		// Set the name...
		testPatient.setName(TEST_NAME);
		
		// Get the name...
		String name = testPatient.getName();
		
		// Check equality
		assertEquals(TEST_NAME, name);
	}
	
	@Test
	public void testAddressSetAndGet() {
        // Set the address...
		testPatient.setAddress(TEST_ADDRESS);
				
		// Get the address...
		String address = testPatient.getAddress();
				
		// Check equality
		assertEquals(TEST_ADDRESS, address);

	}
	
	@Test
	public void testPhoneNumberSetAndGet() {
        // Set the phone number...
		testPatient.setTelephoneNumber(TEST_PHONE);

		// Get the phone number...
		String phoneNumber = testPatient.getTelephoneNumber();

		// Check equality
		assertEquals(TEST_PHONE, phoneNumber);


	}

	@Test
	public void testDobSetAndGet() {
        // Set the dob...
		testPatient.setDob(TEST_DOB);

		// Get the dob...
		Date dob = testPatient.getDob();

		// Check equality
		assertEquals(TEST_DOB, dob);

	}
	
	@Test
	public void testPastAppointmentListInsertionAndRetrival() {
        fail("Not yet implemented");

        // Create a new appointment...
		Appointment pastAppointment = new Appointment();
		pastAppointment.setDate(new Date());
		
		// Add it to the list...
		testPatient.addPastAppointment(pastAppointment);

		// Ensure the list contains the added past appointment...
		List<Appointment> appointments =  testPatient.getPastAppointments();
		
		boolean containsPastAppointment = appointments.contains(pastAppointment);
		
		// Flag bool will be set if the list contains said object.
		assertTrue(containsPastAppointment);
		
		
	}
	
}
