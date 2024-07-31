package dentalClinic;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the Doctor class.
 * This class tests various functionalities of the Doctor class,
 * ensuring the correctness of managing daily appointments and prescriptions.
 */
public class DoctorTest {
    private Doctor doctor;
    private Patient patient;
    private Appointment appointment;
    private Prescription prescription;
    private ClinicManagement clinic;
/****************************************************************************\
    /**
     * Sets up the test environment before each test.
     * Initializes a sample doctor, patient, appointment, and prescription.
     */
    @Before
    public void setUp() {
    	 clinic = new ClinicManagement();
        doctor = new Doctor("doc1", "password",clinic);
        patient = new Patient("John Doe", "P001", "555-1234");
        appointment = new Appointment("A001", "2024-07-05", "10:00 AM", patient, doctor);
        prescription = new Prescription("RX001", patient, "Ibuprofen", "200mg", "Take twice daily", doctor);
    }
/****************************************************************************\
    /**
     * Tests viewing daily appointments for a doctor.
     * Ensures that the doctor's daily appointments list is not empty after adding an appointment.
     */
    @Test
    public void testViewDailyAppointments() {
        doctor.getDailyAppointments().add(appointment);
        assertFalse(doctor.getDailyAppointments().isEmpty());
        doctor.viewDailyAppointments();;
    }
/****************************************************************************\
    /**
     * Tests adding a prescription to a doctor.
     * Ensures that the prescription is correctly added to the doctor's list of prescriptions.
     */
    @Test
    public void testAddPrescription() {
        doctor.addPrescription(prescription);
        assertTrue(doctor.getPrescriptions().contains(prescription));
    }
/****************************************************************************\
    /**
     * Tests removing a prescription from a doctor.
     * Ensures that the prescription is correctly removed from the doctor's list of prescriptions.
     */
    @Test
    public void testRemovePrescription() {
        doctor.addPrescription(prescription);
        doctor.getPrescriptions().remove(prescription);
        assertFalse(doctor.getPrescriptions().contains(prescription));
    }
/****************************************************************************\
    /**
     * Tests updating a prescription.
     * Ensures that the dosage of the prescription can be correctly updated.
     */
//    @Test
//    public void testUpdatePrescription() {
//        doctor.addPrescription(prescription);
//        prescription.setDosage("300mg");
//        assertEquals("300mg", doctor.getPrescriptions().get(0).getDosage());
//    }
}
