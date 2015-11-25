package com.example.tddCoursework;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppointmentTest extends AbstractLoggingJUnitTest {
	// A private instance of the Appointment to test with; to be constructed before each test in setUp, and destroyed after each test in tearDown
	private Appointment testAppointment;
	
	// Some constants to use in the testing of the Appointment class' fields.
	private static final String TEST_DESCRIPTION = "A test appointment!";
	private static final Date TEST_DATE = new Date();
	private static final Patient TEST_PATIENT = new Patient(1);
	
	@Before
	public void setUp() throws Exception {
		// Create a testing instance of Appointment
		testAppointment = new Appointment();
		
	}

	@After
	public void tearDown() throws Exception {
		// Destroy the appointment
		testAppointment = null;
		
	}

	@Test
	public void testConstructor() {
		// Ensure the test Appointment instance exists and was constructed properly...
		assertNotNull(testAppointment);
		
	}
	
	@Test
	public void testDescription() {
		// Set the appointment description...
		testAppointment.setDescription(TEST_DESCRIPTION);
				
		// Get the appointment description...
		String description = testAppointment.getDescription();
				
		// Check equality
		assertEquals(TEST_DESCRIPTION, description);
		
	}

	@Test
	public void testDate() {
		// Set the appointment date...
		testAppointment.setDate(TEST_DATE);
						
		// Get the date...
		Date date = testAppointment.getDate();
						
		// Check equality
		assertEquals(TEST_DATE, date);
		
	}

	@Test
	public void testPatient() {
		// Set the appointment's associated patient...
		testAppointment.setPatient(TEST_PATIENT);
						
		// Get the appointment's associated patient...
		Patient thePatient = testAppointment.getPatient();
						
		// Check memory reference is the same (they should be the same instance and therefore memory address - because we're using the same TEST_PATIENT instance!)
		assertSame(TEST_PATIENT, thePatient);
		
	}


}
