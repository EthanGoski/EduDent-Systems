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

/****************************************************************************\
    /**
     * Sets up the test environment before each test.
     * Initializes a sample patient, doctor, and prescription.
     */
    @Before
    public void setUp() {
        patient = new Patient("John Doe", "P001", "555-1234");
        doctor = new Doctor("doc1", "password");
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
/****************************************************************************\
    /**
     * Tests the setMedication method.
     * Ensures that the medication of the prescription can be correctly updated.
     */
//    @Test
//    public void testSetMedication() {
//        prescription.setMedication("Paracetamol");
//        assertEquals("Paracetamol", prescription.getMedication());
//    }
/****************************************************************************\
    /**
     * Tests the setDosage method.
     * Ensures that the dosage of the prescription can be correctly updated.
     */
//    @Test
//    public void testSetDosage() {
//        prescription.setDosage("300mg");
//        assertEquals("300mg", prescription.getDosage());
//    }
/****************************************************************************\
    /**
     * Tests the setInstructions method.
     * Ensures that the instructions for taking the medication can be correctly updated.
     */
//    @Test
//    public void testSetInstructions() {
//        prescription.setInstructions("Take thrice daily");
//        assertEquals("Take thrice daily", prescription.getInstructions());
//    }
/****************************************************************************\
    /**
     * Tests the toString method.
     * Ensures that the method returns the correct string representation of the prescription.
     */
    @Test
    public void testToString() {
    	System.out.println(prescription.toString());
        String expected = "Prescription [ID=RX001, Medication=Ibuprofen, Dosage=200mg, Instructions=Take twice daily, Patient=John Doe, Doctor=doc1]";
        assertEquals(expected, prescription.toString());
    }
}
