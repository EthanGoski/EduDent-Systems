package dentalClinic;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the Prescription class.
 * This class tests various functionalities of the Prescription class,
 * ensuring the correctness of getters, setters, and other methods.
 */
public class PrescriptionTest {
    private Prescription prescription;
    private Patient patient;
    private Doctor doctor;
    private ClinicManagement clinic;
/****************************************************************************\
    /**
     * Sets up the test environment before each test.
     * Initializes a sample patient, doctor, and prescription.
     */
    @Before
    public void setUp() {
    	 clinic = new ClinicManagement();
        patient = new Patient("John Doe", "P001", "555-1234");
        doctor = new Doctor("doc1", "password",clinic);
        prescription = new Prescription("RX001", patient, "Ibuprofen", "200mg", "Take twice daily", doctor);
    }
/****************************************************************************\
    /**
     * Tests the getPrescriptionID method.
     * Ensures that the method returns the correct prescription ID.
     */
    @Test
    public void testGetPrescriptionID() {
        assertEquals("RX001", prescription.getPrescriptionID());
    }
/****************************************************************************\
    /**
     * Tests the getMedication method.
     * Ensures that the method returns the correct medication.
     */
    @Test
    public void testGetMedication() {
        assertEquals("Ibuprofen", prescription.getMedication());
    }
/****************************************************************************\
    /**
     * Tests the getDosage method.
     * Ensures that the method returns the correct dosage.
     */
    @Test
    public void testGetDosage() {
        assertEquals("200mg", prescription.getDosage());
    }
/****************************************************************************\
    /**
     * Tests the getInstructions method.
     * Ensures that the method returns the correct instructions for taking the medication.
     */
    @Test
    public void testGetInstructions() {
        assertEquals("Take twice daily", prescription.getInstructions());
    }
/****************************************************************************\
    /**
     * Tests the getPatient method.
     * Ensures that the method returns the correct patient associated with the prescription.
     */
    @Test
    public void testGetPatient() {
        assertEquals(patient, prescription.getPatient());
    }
/****************************************************************************\
    /**
     * Tests the getDoctor method.
     * Ensures that the method returns the correct doctor who prescribed the medication.
     */
    @Test
    public void testGetDoctor() {
        assertEquals(doctor, prescription.getDoctor());
    }

    /**
     * Tests the toString method.
     * Ensures that the method returns the correct string representation of the prescription.
     */
    @Test
    public void testPrescriptionToString() {
    	System.out.println(prescription.toString());
        String expected = "Prescription [ID=RX001, Patient=Patient [Name=John Doe, ID=P001, Contact=555-1234], Medication=Ibuprofen, Dosage=200mg, Instructions=Take twice daily, Doctor="+doctor+"]";
        assertEquals(expected, prescription.toString());
       
    }
}
