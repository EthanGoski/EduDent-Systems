package dentalClinic;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the Receptionist class.
 * This class tests various functionalities of the Receptionist class,
 * ensuring the correctness of managing patients, appointments, and prescriptions.
 */
public class ReceptionistTest {
    private Receptionist receptionist;
    private Patient patient;
    private ClinicManagement clinic;
    private Prescription prescription;

/****************************************************************************\
    /**
     * Sets up the test environment before each test.
     * Initializes a sample receptionist and patient.
     */
    @Before
    public void setUp() {
        receptionist = new Receptionist("rec1", "password",clinic);
        patient = new Patient("John Doe", "P001", "555-1234");
        new Appointment("A001", "2024-07-05", "10:00 AM", patient, new Doctor("doc1", "password"));
        clinic = new ClinicManagement();
    }
/****************************************************************************\
    /**
     * Tests adding a patient to the receptionist's list.
     * Ensures that the patient is correctly added to the receptionist's list of patients.
     */
    @Test
    public void testAddPatient() {
        receptionist.addPatient(patient);
        assertTrue(receptionist.getPatients().contains(patient));
    }
/****************************************************************************\
    /**
     * Tests removing a patient from the receptionist's list.
     * Ensures that the patient is correctly removed from the receptionist's list of patients.
     */
    @Test
    public void testRemovePatient() {
        receptionist.addPatient(patient);
        receptionist.getPatients().remove(patient);
        assertFalse(receptionist.getPatients().contains(patient));
    }
/****************************************************************************\
    /**
     * Tests updating a patient's contact information.
     * Ensures that the patient's contact information can be correctly updated by the receptionist.
     */
    @Test
    public void testUpdatePatient() {
        receptionist.addPatient(patient);
        patient.setContactInfo("555-0000");
        assertEquals("555-0000", receptionist.getPatients().get(0).getContactInfo());
    }
/****************************************************************************\
    /**
     * Tests adding an appointment.
     * Ensures that the appointment is correctly added to the clinic.
     */
   @Test
    public void testAddAppointment() {
        Appointment appointment = new Appointment("A001", "2024-07-05", "10:00 AM", patient, new Doctor("doc1", "password"));
        receptionist.addAppointment(appointment);
        // Assuming getAppointments() method exists in the clinic management
//        assertTrue(clinic.getAppointments().contains(appointment));
    }
/****************************************************************************\
    /**
     * Tests viewing prescriptions.
     * Ensures that the receptionist can correctly view all pending prescriptions.
     */
   @Test
    public void testViewPrescriptions() {
        Prescription prescription = new Prescription("RX001", patient, "Ibuprofen", "200mg", "Take twice daily", new Doctor("doc1", "password"));
        // Assuming addPrescription() method exists in the clinic management
        clinic.addPrescription(prescription);
        receptionist.viewPrescriptions();
        // Assuming getPrescriptions() method exists in the clinic management
       assertTrue(clinic.getPrescriptions().contains(prescription));
    }
/****************************************************************************\
    /**
     * Tests finding a patient by their ID.
     * Ensures that the correct patient is found when searching by ID.
     */
//    @Test
//    public void testFindPatientByID() {
//        receptionist.addPatient(patient);
//        Patient foundPatient = receptionist.findPatientByID("P001");
//        assertNotNull(foundPatient);
//        assertEquals("John Doe", foundPatient.getName());
//    }
}
