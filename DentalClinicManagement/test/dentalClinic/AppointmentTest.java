package dentalClinic;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the Appointment class.
 * This class tests various functionalities of the Appointment class,
 * ensuring the correctness of getters, setters, and other methods.
 */
public class AppointmentTest {
    private Appointment appointment;
    private Patient patient;
    private Doctor doctor;

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
}
