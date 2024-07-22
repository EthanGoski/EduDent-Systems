package dentalClinic;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the Appointment class.
 * This class tests various functionalities of the Appointment class,
 * ensuring the correctness of getters, setters, and other methods.
 */
public class DentalClinicTotalTest {
    private Appointment appointment;
    private Patient patient;
    private Doctor doctor;
    private ClinicManagement clinic;
    private Receptionist receptionist;
    private Patient patient2;
    private Appointment appointment2;
    private Prescription prescription;
    private Prescription prescription2;
    
    private List<Doctor> doctors;
    // List of receptionists in the clinic
    private List<Receptionist> receptionists;
    // List of patients in the clinic
    private List<Patient> patients;
    // List of appointments in the clinic
    private List<Appointment> appointments;
    // List of prescriptions in the clinic
    private List<Prescription> prescriptions;

/****************************************************************************\
    /**
     * Sets up the test environment before each test.
     * Initializes a sample patient, doctor, and appointment.
     */
    @Before
    public void setUp() {
        patient = new Patient("John Doe", "P001", "555-1234");
        doctor = new Doctor("doc1", "password");
        appointment = new Appointment("A001", "2024-07-05", "10:00 AM", patient, doctor);
        clinic = new ClinicManagement();
        receptionist = new Receptionist("rec1", "password",clinic);
        prescription = new Prescription("RX001", patient, "Ibuprofen", "200mg", "Take twice daily", doctor);
        patient2 = new Patient("Jane Smith", "P002", "555-5678");
        appointment2 = new Appointment("A002", "2024-07-05", "11:00 AM", patient2, doctor);
        prescription2 = new Prescription("RX002", patient2, "Paracetamol", "500mg", "Take thrice daily", doctor);
        receptionist = new Receptionist("rec1", "password",clinic);
        new Appointment("A001", "2024-07-05", "10:00 AM", patient, new Doctor("doc1", "password"));
    }
/****************************************************************************\
    /**
     * Tests the getAppointmentID method.
     * Ensures that the method returns the correct appointment ID.
     */
    @Test
    public void testGetAppointmentID() {
        assertEquals("A001", appointment.getAppointmentID());
    }
/****************************************************************************\
    /**
     * Tests the getDate method.
     * Ensures that the method returns the correct appointment date.
     */
    @Test
    public void testGetDate() {
        assertEquals("2024-07-05", appointment.getDate());
    }
/****************************************************************************\
    /**
     * Tests the setDate method.
     * Ensures that the date of the appointment can be correctly updated.
     */
    @Test
    public void testSetDate() {
        appointment.setDate("2024-08-05");
        assertEquals("2024-08-05", appointment.getDate());
    }
/****************************************************************************\
    /**
     * Tests the getTime method.
     * Ensures that the method returns the correct appointment time.
     */
    @Test
    public void testGetTime() {
        assertEquals("10:00 AM", appointment.getTime());
    }
/****************************************************************************\
    /**
     * Tests the setTime method.
     * Ensures that the time of the appointment can be correctly updated.
     */
    @Test
    public void testSetTime() {
        appointment.setTime("11:00 AM");
        assertEquals("11:00 AM", appointment.getTime());
    }
/****************************************************************************\
    /**
     * Tests the getPatient method.
     * Ensures that the method returns the correct patient associated with the appointment.
     */
    @Test
    public void testGetPatient() {
        assertEquals(patient, appointment.getPatient());
    }
/****************************************************************************\
    /**
     * Tests the getDoctor method.
     * Ensures that the method returns the correct doctor associated with the appointment.
     */
    @Test
    public void testGetDoctor() {
        assertEquals(doctor, appointment.getDoctor());
    }
/****************************************************************************\
    /**
     * Tests the toString method.
     * Ensures that the method returns the correct string representation of the appointment.
     */
    @Test
    public void testToString() {
        String expected = "Appointment [ID=A001, Date=2024-07-05, Time=10:00 AM, Patient=John Doe, Doctor=doc1]";
        assertEquals(expected, appointment.toString());
    }
/****************************************************************************\
    /**
     * Tests the equals method for appointment equality.
     * Ensures that two appointments with the same details are considered equal.
     */
    @Test
    public void testAppointmentEquality() {
        Appointment anotherAppointment = new Appointment("A001", "2024-07-05", "10:00 AM", patient, doctor);
        assertEquals(appointment, anotherAppointment);
    }
/****************************************************************************\
    /**
     * Tests the equals method for appointment inequality.
     * Ensures that two appointments with different details are not considered equal.
     */
    @Test
    public void testAppointmentInequality() {
        Appointment differentAppointment = new Appointment("A002", "2024-07-06", "11:00 AM", patient, doctor);
        assertNotEquals(appointment, differentAppointment);
    }
/****************************************************************************\
    /**
     * Tests that an appointment with a null patient is handled correctly.
     * Ensures that the patient field can be null.
     */
    @Test
    public void testNullPatient() {
        Appointment appointmentWithNullPatient = new Appointment("A003", "2024-07-07", "12:00 PM", null, doctor);
        assertNull(appointmentWithNullPatient.getPatient());
    }
/****************************************************************************\
    /**
     * Tests that an appointment with a null doctor is handled correctly.
     * Ensures that the doctor field can be null.
     */
    @Test
    public void testNullDoctor() {
        Appointment appointmentWithNullDoctor = new Appointment("A004", "2024-07-08", "01:00 PM", patient, null);
        assertNull(appointmentWithNullDoctor.getDoctor());
    }
/****************************************************************************\
    /**
     * Tests the setPatient method.
     * Ensures that the patient associated with the appointment can be correctly updated.
     */
    @Test
    public void testChangePatient() {
        Patient newPatient = new Patient("Jane Smith", "P002", "555-5678");
        appointment.setPatient(newPatient);
        assertEquals(newPatient, appointment.getPatient());
    }
/****************************************************************************\
    /**
     * Tests the setDoctor method.
     * Ensures that the doctor associated with the appointment can be correctly updated.
     */
    @Test
    public void testChangeDoctor() {
        Doctor newDoctor = new Doctor("doc2", "newpassword");
        appointment.setDoctor(newDoctor);
        assertEquals(newDoctor, appointment.getDoctor());
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
    doctor.viewDailyAppointments();
}
@Test
public void testGetPatientAppointments() {
    Appointment appointment = new Appointment("A001", "2024-07-05", "10:00 AM", patient, new Doctor("doc1", "password"));
    clinic.addAppointment(appointment);
	clinic.getAppointmentsByPatient(patient);
	System.out.println("hi" + clinic.getAppointmentsByPatient(patient));
}
@Test
public void testGetPatientPrescriptions() {

	Prescription prescription = new Prescription("RX001", patient, "Ibuprofen", "200mg", "Take twice daily",  new Doctor("doc1", "password"));
	clinic.addPrescription(prescription);
	clinic.getPrescriptionsByPatient(patient);
	System.out.println(clinic.getPrescriptionsByPatient(patient));
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
public void testPatientToString() {
    String expected = "Patient [Name=John Doe, ID=P001, Contact=555-1234]";
    assertEquals(expected, patient.toString());
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
/**
 * Tests the toString method.
 * Ensures that the method returns the correct string representation of the prescription.
 */
@Test
public void testPrescriptionToString() {
	System.out.println(prescription.toString());
    String expected = "Prescription [ID=RX001, Medication=Ibuprofen, Dosage=200mg, Instructions=Take twice daily, Patient=John Doe, Doctor=doc1]";
    assertEquals(expected, prescription.toString());
}
/****************************************************************************\
/**
 * Tests removing a patient from the receptionist's list.
 * Ensures that the patient is correctly removed from the receptionist's list of patients.
 */
@Test
public void testReceptionistRemovePatient() {
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
public void testReceptionistAddAppointment() {
    Appointment appointment = new Appointment("A001", "2024-07-05", "10:00 AM", patient, new Doctor("doc1", "password"));
    receptionist.addAppointment(appointment);
    // Assuming getAppointments() method exists in the clinic management
   assertTrue(clinic.getAppointments().contains(appointment));
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

}
