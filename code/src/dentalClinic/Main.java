package dentalClinic;

import java.util.Scanner;

/**
 * Main class for the Dental Clinic Management System for system messages on the compiler.
 * 
 * Provides a command-line interface for interacting with the system.
 * Supports functionalities for both doctors and receptionists.
 */
public class Main {
    // Scanner for user input
    private static Scanner scanner = new Scanner(System.in);
    // Instance of ClinicManagement to manage clinic data
    private static ClinicManagement clinic = new ClinicManagement();
    // Currently logged-in user
    private static User loggedInUser = null;

/****************************************************************************\
    /**
     * Main method to start the Dental Clinic Management System.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        initializeSampleData();

        while (true) {
            showMainMenu();
        }
    }
/****************************************************************************\
    /**
     * Initializes sample data for demonstration purposes.
     */
    private static void initializeSampleData() {
        // Sample data for demonstration
        Doctor doc1 = new Doctor("doc1", "password");
        Receptionist rec1 = new Receptionist("rec1", "password",clinic);
        clinic.addDoctor(doc1);
        clinic.addReceptionist(rec1);
    }
/****************************************************************************\
    /**
     * Displays the main menu and handles user input.
     */
    private static void showMainMenu() {
        System.out.println("\n=== Welcome to Dental Clinic Management System ===");
        System.out.println("1. Login");
        System.out.println("2. Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // consume newline

        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                System.out.println("Exiting the system. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
/****************************************************************************\
    /**
     * Handles user login.
     */
    private static void login() {
        System.out.print("\nEnter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        loggedInUser = authenticate(username, password);
        if (loggedInUser != null) {
            System.out.println("Login successful!");

            if (loggedInUser instanceof Doctor) {
                showDoctorMenu((Doctor) loggedInUser);
            } else if (loggedInUser instanceof Receptionist) {
                showReceptionistMenu((Receptionist) loggedInUser);
            }
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }
/****************************************************************************\
    /**
     * Authenticates the user based on username and password.
     *
     * @param username Username entered by the user.
     * @param password Password entered by the user.
     * @return User if authentication is successful, otherwise null.
     */
    private static User authenticate(String username, String password) {
        for (Doctor doctor : clinic.getDoctors()) {
            if (doctor.getUsername().equals(username) && doctor.getPassword().equals(password)) {
                return doctor;
            }
        }
        for (Receptionist receptionist : clinic.getReceptionists()) {
            if (receptionist.getUsername().equals(username) && receptionist.getPassword().equals(password)) {
                return receptionist;
            }
        }
        return null;
    }
/****************************************************************************\
    /**
     * Displays the menu for the logged-in doctor.
     *
     * @param doctor Logged-in doctor.
     */
    private static void showDoctorMenu(Doctor doctor) {
        while (true) {
            System.out.println("\n=== Doctor Menu ===");
            System.out.println("1. View Today's Appointments");
            System.out.println("2. Add Prescription");
            System.out.println("3. View Patient Details");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    doctor.viewDailyAppointments();
                    break;
                case 2:
                    addPrescription(doctor);
                    break;
                case 3:
                    viewPatientDetails();
                    break;
                case 4:
                    loggedInUser = null;
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
/****************************************************************************\
    /**
     * Displays the menu for the logged-in receptionist.
     *
     * @param receptionist Logged-in receptionist.
     */
    private static void showReceptionistMenu(Receptionist receptionist) {
        while (true) {
            System.out.println("\n=== Receptionist Menu ===");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Appointment");
            System.out.println("3. View Prescriptions");
            System.out.println("4. View Patient Details");
            System.out.println("5. Edit Patient");
            System.out.println("6. Delete Patient");
            System.out.println("7. Search Patients");
            System.out.println("8. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    addPatient(receptionist);
                    break;
                case 2:
                    addAppointment(receptionist);
                    break;
                case 3:
                    receptionist.viewPrescriptions();
                    break;
                case 4:
                    viewPatientDetails();
                    break;
                case 5:
                    editPatient();
                    break;
                case 6:
                    deletePatient();
                    break;
                case 7:
                    searchPatients();
                    break;
                case 8:
                    loggedInUser = null;
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
/****************************************************************************\
    /**
     * Adds a new patient to the clinic.
     *
     * @param receptionist Logged-in receptionist handling the operation.
     */
    private static void addPatient(Receptionist receptionist) {
        System.out.print("\nEnter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter patient ID: ");
        String patientID = scanner.nextLine();
        System.out.print("Enter contact info: ");
        String contactInfo = scanner.nextLine();

        Patient patient = new Patient(name, patientID, contactInfo);
        receptionist.addPatient(patient);
        clinic.addPatient(patient);

        System.out.println("Patient added successfully.");
    }
/****************************************************************************\
    /**
     * Adds a new appointment to the clinic.
     *
     * @param receptionist Logged-in receptionist handling the operation.
     */
    private static void addAppointment(Receptionist receptionist) {
        System.out.print("\nEnter appointment ID: ");
        String appointmentID = scanner.nextLine();
        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter appointment time (HH:MM AM/PM): ");
        String time = scanner.nextLine();
        System.out.print("Enter patient ID: ");
        String patientID = scanner.nextLine();
        System.out.print("Enter doctor username: ");
        String doctorUsername = scanner.nextLine();

        Patient patient = findPatientByID(patientID);
        Doctor doctor = findDoctorByUsername(doctorUsername);

        if (patient != null && doctor != null) {
            Appointment appointment = new Appointment(appointmentID, date, time, patient, doctor);
            receptionist.addAppointment(appointment);
            doctor.getDailyAppointments().add(appointment);

            System.out.println("Appointment added successfully.");
        } else {
            System.out.println("Invalid patient ID or doctor username.");
        }
    }
/****************************************************************************\
    /**
     * Adds a new prescription to the clinic.
     *
     * @param doctor Logged-in doctor handling the operation.
     */
    private static void addPrescription(Doctor doctor) {
        System.out.print("\nEnter prescription ID: ");
        String prescriptionID = scanner.nextLine();
        System.out.print("Enter patient ID: ");
        String patientID = scanner.nextLine();
        System.out.print("Enter medication: ");
        String medication = scanner.nextLine();
        System.out.print("Enter dosage: ");
        String dosage = scanner.nextLine();
        System.out.print("Enter instructions: ");
        String instructions = scanner.nextLine();

        Patient patient = findPatientByID(patientID);

        if (patient != null) {
            Prescription prescription = new Prescription(prescriptionID, patient, medication, dosage, instructions, doctor);
            doctor.addPrescription(prescription);
            clinic.addPrescription(prescription);

            System.out.println("Prescription added successfully.");
        } else {
            System.out.println("Invalid patient ID.");
        }
    }
/****************************************************************************\
    /**
     * Displays the details of a patient.
     */
    private static void viewPatientDetails() {
        System.out.print("\nEnter patient ID: ");
        String patientID = scanner.nextLine();
        Patient patient = findPatientByID(patientID);

        if (patient != null) {
            System.out.println("Patient Details:");
            System.out.println("Name: " + patient.getName());
            System.out.println("ID: " + patient.getPatientID());
            System.out.println("Contact Info: " + patient.getContactInfo());
        } else {
            System.out.println("Patient not found.");
        }
    }
/****************************************************************************\
    /**
     * Edits the details of an existing patient.
     */
    private static void editPatient() {
        System.out.print("\nEnter patient ID: ");
        String patientID = scanner.nextLine();
        Patient patient = findPatientByID(patientID);

        if (patient != null) {
            System.out.print("Enter new name (leave blank to keep current): ");
            String name = scanner.nextLine();
            if (!name.isBlank()) {
                patient.setName(name);
            }

            System.out.print("Enter new contact info (leave blank to keep current): ");
            String contactInfo = scanner.nextLine();
            if (!contactInfo.isBlank()) {
                patient.setContactInfo(contactInfo);
            }

            System.out.println("Patient details updated successfully.");
        } else {
            System.out.println("Patient not found.");
        }
    }
/****************************************************************************\
    /**
     * Deletes a patient from the clinic.
     */
    private static void deletePatient() {
        System.out.print("\nEnter patient ID: ");
        String patientID = scanner.nextLine();
        Patient patient = findPatientByID(patientID);

        if (patient != null) {
            clinic.getPatients().remove(patient);
            System.out.println("Patient deleted successfully.");
        } else {
            System.out.println("Patient not found.");
        }
    }
/****************************************************************************\
    /**
     * Searches for patients by name or contact information.
     */
    private static void searchPatients() {
        System.out.print("\nEnter search term (name or contact info): ");
        String searchTerm = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (Patient patient : clinic.getPatients()) {
            if (patient.getName().toLowerCase().contains(searchTerm) || 
                patient.getContactInfo().toLowerCase().contains(searchTerm)) {
                System.out.println("Patient ID: " + patient.getPatientID());
                System.out.println("Name: " + patient.getName());
                System.out.println("Contact Info: " + patient.getContactInfo());
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No patients found matching the search term.");
        }
    }
/****************************************************************************\
    /**
     * Finds a patient by their unique ID.
     *
     * @param patientID Unique identifier for the patient.
     * @return Patient if found, otherwise null.
     */
    private static Patient findPatientByID(String patientID) {
        for (Patient patient : clinic.getPatients()) {
            if (patient.getPatientID().equals(patientID)) {
                return patient;
            }
        }
        return null;
    }
/****************************************************************************\
    /**
     * Finds a doctor by their username.
     *
     * @param username Username of the doctor.
     * @return Doctor if found, otherwise null.
     */
    private static Doctor findDoctorByUsername(String username) {
        for (Doctor doctor : clinic.getDoctors()) {
            if (doctor.getUsername().equals(username)) {
                return doctor;
            }
        }
        return null;
    }
}
