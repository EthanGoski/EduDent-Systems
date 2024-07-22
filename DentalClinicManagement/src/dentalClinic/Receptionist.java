package dentalClinic;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a receptionist and their role in the dental clinic.
 * 
 * Inherits from the User class.
 * Manages:
 *  - Patients
 */
public class Receptionist extends User {
    // List of patients managed by the receptionist
    private List<Patient> patients;
    private ClinicManagement clinicManagement;
/****************************************************************************\
 /**
 * Constructs a new Receptionist instance.
 *
 * @param username Username of the receptionist.
 * @param password Password of the receptionist.
 */
public Receptionist(String username, String password, ClinicManagement clinicManagement) {
	super(username, password);
    this.patients = new ArrayList<>();
    this.clinicManagement = clinicManagement;
}

/****************************************************************************\
    /**
     * Adds a new patient to the list of patients managed by the receptionist.
     *
     * @param patient Patient to be added.
     */
    public void addPatient(Patient patient) {
        patients.add(patient);
    }
/****************************************************************************\
    /**
     * Adds a new appointment to the clinic's appointment list.
     *
     * @param appointment Appointment to be added.
     */
    public void addAppointment(Appointment appointment) {
        ClinicManagement clinicManagement = new ClinicManagement();
        clinicManagement.addAppointment(appointment);
    }
/****************************************************************************\
    /**
     * Prints the list of pending prescriptions to the console.
     * Each prescription is printed on a new line.
     */
    public void viewPrescriptions() {
        List<Prescription> prescriptions = clinicManagement.getPrescriptions();
        System.out.println("Pending Prescriptions:");
        for (Prescription prescription : prescriptions) {
            System.out.println(prescription);
        }
    }
/****************************************************************************\
    /**
     * Returns the list of patients managed by the receptionist.
     *
     * @return List of patients.
     */
    public List<Patient> getPatients() {
        return patients;
    }
}
