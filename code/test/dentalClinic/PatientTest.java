package dentalClinic;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the Patient class.
 * This class tests various functionalities of the Patient class,
 * ensuring the correctness of getters, setters, and other methods.
 */
public class PatientTest {
    private Patient patient;

/****************************************************************************\
    /**
     * Sets up the test environment before each test.
     * Initializes a sample patient.
     */
    @Before
    public void setUp() {
        patient = new Patient("John Doe", "P001", "555-1234");
    }
/****************************************************************************\
    /**
     * Tests the getName method.
     * Ensures that the method returns the correct patient name.
     */
    @Test
    public void testGetName() {
        assertEquals("John Doe", patient.getName());
    }
/****************************************************************************\
    /**
     * Tests the setName method.
     * Ensures that the patient's name can be correctly updated.
     */
    @Test
    public void testSetName() {
        patient.setName("Jane Doe");
        assertEquals("Jane Doe", patient.getName());
    }
/****************************************************************************\
    /**
     * Tests the getPatientID method.
     * Ensures that the method returns the correct patient ID.
     */
    @Test
    public void testGetPatientID() {
        assertEquals("P001", patient.getPatientID());
    }
/****************************************************************************\
    /**
     * Tests the setContactInfo method.
     * Ensures that the patient's contact information can be correctly updated.
     */
    @Test
    public void testSetContactInfo() {
        patient.setContactInfo("555-0000");
        assertEquals("555-0000", patient.getContactInfo());
    }
/****************************************************************************\
    /**
     * Tests the toString method.
     * Ensures that the method returns the correct string representation of the patient.
     */
    @Test
    public void testToString() {
        String expected = "Patient [Name=John Doe, ID=P001, Contact=555-1234]";
        assertEquals(expected, patient.toString());
    }
}
