package dentalClinic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Manages the operations of the dental clinic.
 * 
 * This includes maintaining lists of:
 *  - Doctors
 *  - Receptionists
 *  - Patients
 *  - Appointments
 *  - Prescriptions
 */
public class ClinicManagement {
    // List of doctors in the clinic
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
     * Constructs a new ClinicManagement instance.
     * Initializes the lists for doctors, receptionists, patients, appointments, and prescriptions.
     */
    public ClinicManagement() {
        this.doctors = new ArrayList<>();
        this.receptionists = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.appointments = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }
/****************************************************************************\
    /**
     * Adds a new doctor to the clinic.
     *
     * @param doctor Doctor to be added.
     */
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }
/****************************************************************************\
    /**
     * Adds a new receptionist to the clinic.
     *
     * @param receptionist Receptionist to be added.
     */
    public void addReceptionist(Receptionist receptionist) {
        receptionists.add(receptionist);
    }
/****************************************************************************\
    /**
     * Adds a new patient to the clinic.
     *
     * @param patient Patient to be added.
     */
    public void addPatient(Patient patient) {
        patients.add(patient);
    }
/****************************************************************************\
    /**
     * Adds a new appointment to the clinic.
     *
     * @param appointment Appointment to be added.
     */
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }
/****************************************************************************\
    /**
     * Adds a new prescription to the clinic.
     *
     * @param prescription Prescription to be added.
     */
    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }
/****************************************************************************\
    /**
     * Returns the list of doctors in the clinic.
     *
     * @return List of doctors.
     */
    public List<Doctor> getDoctors() {
        return doctors;
    }
/****************************************************************************\
    /**
     * Returns the list of receptionists in the clinic.
     *
     * @return List of receptionists.
     */
    public List<Receptionist> getReceptionists() {
        return receptionists;
    }
/****************************************************************************\
    /**
     * Returns the list of patients in the clinic.
     *
     * @return List of patients.
     */
    public List<Patient> getPatients() {
        return patients;
    }
/****************************************************************************\
    /**
     * Returns the list of appointments in the clinic.
     *
     * @return List of appointments.
     */
    public List<Appointment> getAppointments() {
        return appointments;
    }
/****************************************************************************\
    /**
     * Returns the list of prescriptions in the clinic.
     *
     * @return List of prescriptions.
     */
    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }
    /**
     * Retrieves a list of appointments for a specific patient.
     *
     * @param patient The patient whose appointments are to be retrieved.
     * @return List of appointments for the specified patient.
     */
    public List<Appointment> getAppointmentsByPatient(Patient patient) {
        return appointments.stream()
                .filter(appointment -> appointment.getPatient().equals(patient))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a list of prescriptions for a specific patient.
     *
     * @param patient The patient whose prescriptions are to be retrieved.
     * @return List of prescriptions for the specified patient.
     */
    public List<Prescription> getPrescriptionsByPatient(Patient patient) {
        return prescriptions.stream()
                .filter(prescription -> prescription.getPatient().equals(patient))
                .collect(Collectors.toList());
    }
}
