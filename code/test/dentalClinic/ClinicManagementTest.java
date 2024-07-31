package dentalClinic;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the ClinicManagement class.
 * This class tests various functionalities of the ClinicManagement class,
 * ensuring the correctness of adding, removing, and managing doctors, receptionists, patients, appointments, and prescriptions.
 */
public class ClinicManagementTest {
    private ClinicManagement clinic;
    private Doctor doctor;
    private Receptionist receptionist;
    private Patient patient;
    private Appointment appointment;
    private Prescription prescription;

/****************************************************************************\
    /**
     * Sets up the test environment before each test.
     * Initializes a sample clinic, doctor, receptionist, patient, appointment, and prescription.
     */
    @Before
    public void setUp() {
        clinic = new ClinicManagement();
        doctor = new Doctor("doc1", "password",clinic);
        receptionist = new Receptionist("rec1", "password",clinic);
        patient = new Patient("John Doe", "P001", "555-1234");
        appointment = new Appointment("A001", "2024-07-05", "10:00 AM", patient, doctor);
        prescription = new Prescription("RX001", patient, "Ibuprofen", "200mg", "Take twice daily", doctor);
    }
/****************************************************************************\
    /**
     * Tests adding a doctor to the clinic.
     * Ensures that the doctor is correctly added to the clinic's list of doctors.
     */
    @Test
    public void testAddDoctor() {
        clinic.addDoctor(doctor);
        assertTrue(clinic.getDoctors().contains(doctor));
    }
/****************************************************************************\
    /**
     * Tests adding a receptionist to the clinic.
     * Ensures that the receptionist is correctly added to the clinic's list of receptionists.
     */
    @Test
    public void testAddReceptionist() {
        clinic.addReceptionist(receptionist);
        assertTrue(clinic.getReceptionists().contains(receptionist));
    }
/****************************************************************************\
    /**
     * Tests adding a patient to the clinic.
     * Ensures that the patient is correctly added to the clinic's list of patients.
     */
    @Test
    public void testAddPatient() {
        clinic.addPatient(patient);
        assertTrue(clinic.getPatients().contains(patient));
    }
/****************************************************************************\
    /**
     * Tests adding an appointment to the clinic.
     * Ensures that the appointment is correctly added to the clinic's list of appointments.
     */
    @Test
    public void testAddAppointment() {
        clinic.addAppointment(appointment);
        assertTrue(clinic.getAppointments().contains(appointment));
    }
/****************************************************************************\
    /**
     * Tests adding a prescription to the clinic.
     * Ensures that the prescription is correctly added to the clinic's list of prescriptions.
     */
    @Test
    public void testAddPrescription() {
        clinic.addPrescription(prescription);
        assertTrue(clinic.getPrescriptions().contains(prescription));
    }
/****************************************************************************\
    /**
     * Tests removing a doctor from the clinic.
     * Ensures that the doctor is correctly removed from the clinic's list of doctors.
     */
    @Test
    public void testRemoveDoctor() {
        clinic.addDoctor(doctor);
        clinic.getDoctors().remove(doctor);
        assertFalse(clinic.getDoctors().contains(doctor));
    }
/****************************************************************************\
    /**
     * Tests editing a patient's details.
     * Ensures that the patient's details can be correctly updated.
     */
    @Test
    public void testEditPatientDetails() {
        clinic.addPatient(patient);
        patient.setName("John Smith");
        patient.setContactInfo("555-5678");
        assertEquals("John Smith", clinic.getPatients().get(0).getName());
        assertEquals("555-5678", clinic.getPatients().get(0).getContactInfo());
    }
/****************************************************************************\
    /**
     * Tests viewing a non-existent patient.
     * Ensures that searching for a patient that does not exist returns null.
     */
    @Test
    public void testViewNonExistentPatient() {
        Patient nonExistentPatient = findPatientByID("P999");
        assertNull(nonExistentPatient);
    }
/****************************************************************************\
    /**
     * Tests handling of appointment conflicts.
     * Ensures that the clinic can handle multiple appointments, even if they are on the same date and time.
     */
    @Test
    public void testAppointmentConflict() {
        Patient patient2 = new Patient("Jane Smith", "P002", "555-5678");
        Appointment appointment2 = new Appointment("A002", "2024-07-05", "10:00 AM", patient2, doctor);
        clinic.addAppointment(appointment);
        clinic.addAppointment(appointment2);
        assertTrue(clinic.getAppointments().contains(appointment));
        assertTrue(clinic.getAppointments().contains(appointment2));
    }
/****************************************************************************\
    /**
     * Tests adding multiple patients to the clinic.
     * Ensures that all patients are correctly added to the clinic's list of patients.
     */
    @Test
    public void testAddMultiplePatients() {
        clinic.addPatient(patient);
        Patient patient2 = new Patient("Jane Smith", "P002", "555-5678");
        clinic.addPatient(patient2);
        assertTrue(clinic.getPatients().contains(patient));
        assertTrue(clinic.getPatients().contains(patient2));
    }
/****************************************************************************\
    /**
     * Tests removing a patient from the clinic.
     * Ensures that the patient is correctly removed from the clinic's list of patients.
     */
    @Test
    public void testRemovePatient() {
        clinic.addPatient(patient);
        clinic.getPatients().remove(patient);
        assertFalse(clinic.getPatients().contains(patient));
    }
/****************************************************************************\
    /**
     * Tests updating a patient's contact information.
     * Ensures that the patient's contact information can be correctly updated.
     */
    @Test
    public void testUpdatePatientInfo() {
        clinic.addPatient(patient);
        patient.setContactInfo("555-0000");
        assertEquals("555-0000", clinic.getPatients().get(0).getContactInfo());
    }
/****************************************************************************\
    /**
     * Tests finding a patient by their ID.
     * Ensures that the correct patient is found when searching by ID.
     */
    @Test
    public void testFindPatientByID() {
        clinic.addPatient(patient);
        Patient foundPatient = findPatientByID("P001");
        assertNotNull(foundPatient);
        assertEquals("John Doe", foundPatient.getName());
    }
/****************************************************************************\
    /**
     * Helper method to find a patient by their ID.
     *
     * @param patientID Unique identifier for the patient.
     * @return Patient if found, otherwise null.
     */
    private Patient findPatientByID(String patientID) {
        for (Patient patient : clinic.getPatients()) {
            if (patient.getPatientID().equals(patientID)) {
                return patient;
            }
        }
        return null;
    }
}
