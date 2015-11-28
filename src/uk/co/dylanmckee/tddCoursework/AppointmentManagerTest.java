package uk.co.dylanmckee.tddCoursework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;

public class AppointmentManagerTest extends AbstractLoggingJUnitTest {
    // A private instance of the AppointmentManager to test with; to be constructed before each test in setUp, and destroyed after each test in tearDown
    private AppointmentManager testAppointmentManager;

    @Before
    public void setUp() throws Exception {
        testAppointmentManager = new AppointmentManager();
    }

    @After
    public void tearDown() throws Exception {
        testAppointmentManager = null;

    }

    @Test
    public void testConstructor() {
        // Check the appointment manager has been constructed...
        assertNotNull(testAppointmentManager);

    }

    @Test
    public void testCreateMultipleAppointmentManagers() {
        // Create a 2nd AppointmentManager instance, then ensure that the two aren't the same...
        AppointmentManager anotherAppointmentManager = new AppointmentManager();

        // Check they're not the same object reference, meaning that multiple unique instances can co-exist
        assertNotSame(testAppointmentManager, anotherAppointmentManager);

    }

    @Test
    public void testPatientListInsertionAndRetrival() {

        fail("Not yet implemented");

    }

    @Test
    public void testPatientListSearch() {
        fail("Not yet implemented");
    }

    @Test
    public void testPatientNameChange() {
        fail("Not yet implemented");
    }

    @Test
    public void testPatientAddressChange() {
        fail("Not yet implemented");
    }

    @Test
    public void testAddNewAppointment() {
        fail("Not yet implemented");
    }

}
