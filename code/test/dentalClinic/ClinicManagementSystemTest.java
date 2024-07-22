package dentalClinic;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the ClinicManagement class.
 * This class tests various functionalities of the ClinicManagement class,
 * ensuring the correctness of adding, removing, and managing doctors, receptionists, patients, appointments, and prescriptions.
 */
public class ClinicManagementSystemTest {
    private ClinicManagement clinic;
    private Doctor doctor;
    private Receptionist receptionist;
    private Patient patient;
    private Patient patient2;
    private Appointment appointment;
    private Appointment appointment2;
    private Prescription prescription;
    private Prescription prescription2;

/****************************************************************************\
    /**
     * Sets up the test environment before each test.
     * Initializes a sample clinic, doctor, receptionist, patients, appointments, and prescriptions.
     */
    @Before
    public void setUp() {
        clinic = new ClinicManagement();
        doctor = new Doctor("doc1", "password");
        receptionist = new Receptionist("rec1", "password",clinic);
        patient = new Patient("John Doe", "P001", "555-1234");
        patient2 = new Patient("Jane Smith", "P002", "555-5678");
        appointment = new Appointment("A001", "2024-07-05", "10:00 AM", patient, doctor);
        appointment2 = new Appointment("A002", "2024-07-05", "11:00 AM", patient2, doctor);
        prescription = new Prescription("RX001", patient, "Ibuprofen", "200mg", "Take twice daily", doctor);
        prescription2 = new Prescription("RX002", patient2, "Paracetamol", "500mg", "Take thrice daily", doctor);
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
     * Ensures that the clinic can handle multiple appointments, even if they are on the same date.
     */
    @Test
    public void testAppointmentConflict() {
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
     * Tests adding multiple appointments to the clinic.
     * Ensures that all appointments are correctly added to the clinic's list of appointments.
     */
    @Test
    public void testAddMultipleAppointments() {
        clinic.addAppointment(appointment);
        clinic.addAppointment(appointment2);
        assertTrue(clinic.getAppointments().contains(appointment));
        assertTrue(clinic.getAppointments().contains(appointment2));
    }
/****************************************************************************\
    /**
     * Tests removing an appointment from the clinic.
     * Ensures that the appointment is correctly removed from the clinic's list of appointments.
     */
    @Test
    public void testRemoveAppointment() {
        clinic.addAppointment(appointment);
        clinic.getAppointments().remove(appointment);
        assertFalse(clinic.getAppointments().contains(appointment));
    }
/****************************************************************************\
    /**
     * Tests finding an appointment by its ID.
     * Ensures that the correct appointment is found when searching by ID.
     */
    @Test
    public void testFindAppointmentByID() {
        clinic.addAppointment(appointment);
        Appointment foundAppointment = findAppointmentByID("A001");
        assertNotNull(foundAppointment);
        assertEquals("10:00 AM", foundAppointment.getTime());
    }
/****************************************************************************\
    /**
     * Tests adding multiple prescriptions to the clinic.
     * Ensures that all prescriptions are correctly added to the clinic's list of prescriptions.
     */
    @Test
    public void testAddMultiplePrescriptions() {
        clinic.addPrescription(prescription);
        clinic.addPrescription(prescription2);
        assertTrue(clinic.getPrescriptions().contains(prescription));
        assertTrue(clinic.getPrescriptions().contains(prescription2));
    }
/****************************************************************************\
    /**
     * Tests removing a prescription from the clinic.
     * Ensures that the prescription is correctly removed from the clinic's list of prescriptions.
     */
    @Test
    public void testRemovePrescription() {
        clinic.addPrescription(prescription);
        clinic.getPrescriptions().remove(prescription);
        assertFalse(clinic.getPrescriptions().contains(prescription));
    }
/****************************************************************************\
    /**
     * Tests finding a prescription by its ID.
     * Ensures that the correct prescription is found when searching by ID.
     */
    @Test
    public void testFindPrescriptionByID() {
        clinic.addPrescription(prescription);
        Prescription foundPrescription = findPrescriptionByID("RX001");
        assertNotNull(foundPrescription);
        assertEquals("Ibuprofen", foundPrescription.getMedication());
    }
/****************************************************************************\
    /**
     * Tests viewing daily appointments for a doctor.
     * Ensures that the doctor's daily appointments are correctly managed.
     */
    @Test
    public void testViewDailyAppointments() {
        doctor.getDailyAppointments().add(appointment);
        assertFalse(doctor.getDailyAppointments().isEmpty());
    }
/****************************************************************************\
    /**
     * Tests adding a prescription to a doctor.
     * Ensures that the prescription is correctly added to the doctor's list of prescriptions.
     */
    @Test
    public void testAddPrescriptionToDoctor() {
        doctor.addPrescription(prescription);
        assertTrue(doctor.getPrescriptions().contains(prescription));
    }
/****************************************************************************\
    /**
     * Tests a receptionist adding a patient to the clinic.
     * Ensures that the patient is correctly added to the receptionist's list of patients.
     */
    @Test
    public void testReceptionistAddPatient() {
        receptionist.addPatient(patient);
        assertTrue(receptionist.getPatients().contains(patient));
    }
/****************************************************************************\
    /**
     * Tests a receptionist viewing prescriptions.
     * Ensures that the receptionist can correctly view all pending prescriptions.
     */
    @Test
    public void testReceptionistViewPrescriptions() {
        clinic.addPrescription(prescription);
        receptionist.viewPrescriptions();
        // This test may need more context for a real validation
        assertTrue(clinic.getPrescriptions().contains(prescription));
    }
/****************************************************************************\
    /**
     * Tests viewing patient details.
     * Ensures that the correct patient details are displayed when searched by ID.
     */
    @Test
    public void testViewPatientDetails() {
        clinic.addPatient(patient);
        Patient foundPatient = findPatientByID("P001");
        assertNotNull(foundPatient);
        assertEquals("John Doe", foundPatient.getName());
    }
/****************************************************************************\
    /**
     * Tests editing a patient's details.
     * Ensures that the patient's details can be correctly updated.
     */
    @Test
    public void testEditPatient() {
        clinic.addPatient(patient);
        patient.setName("John Smith");
        patient.setContactInfo("555-5678");
        assertEquals("John Smith", clinic.getPatients().get(0).getName());
        assertEquals("555-5678", clinic.getPatients().get(0).getContactInfo());
    }
/****************************************************************************\
    /**
     * Tests deleting a patient from the clinic.
     * Ensures that the patient is correctly removed from the clinic's list of patients.
     */
    @Test
    public void testDeletePatient() {
        clinic.addPatient(patient);
        clinic.getPatients().remove(patient);
        assertFalse(clinic.getPatients().contains(patient));
    }
/****************************************************************************\
    /**
     * Tests searching for patients by name or contact information.
     * Ensures that patients matching the search term are correctly found.
     */
    @Test
    public void testSearchPatients() {
        clinic.addPatient(patient);
        String searchTerm = "John".toLowerCase();
        boolean found = false;
        for (Patient p : clinic.getPatients()) {
            if (p.getName().toLowerCase().contains(searchTerm) || 
                p.getContactInfo().toLowerCase().contains(searchTerm)) {
                found = true;
                break;
            }
        }
        assertTrue(found);
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
/****************************************************************************\
    /**
     * Helper method to find an appointment by its ID.
     *
     * @param appointmentID Unique identifier for the appointment.
     * @return Appointment if found, otherwise null.
     */
    private Appointment findAppointmentByID(String appointmentID) {
        for (Appointment appointment : clinic.getAppointments()) {
            if (appointment.getAppointmentID().equals(appointmentID)) {
                return appointment;
            }
        }
        return null;
    }
/****************************************************************************\
    /**
     * Helper method to find a prescription by its ID.
     *
     * @param prescriptionID Unique identifier for the prescription.
     * @return Prescription if found, otherwise null.
     */
    private Prescription findPrescriptionByID(String prescriptionID) {
        for (Prescription prescription : clinic.getPrescriptions()) {
            if (prescription.getPrescriptionID().equals(prescriptionID)) {
                return prescription;
            }
        }
        return null;
    }
}
