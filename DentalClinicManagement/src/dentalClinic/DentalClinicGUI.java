package dentalClinic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DentalClinicGUI {
    private JFrame frame;
    private JPanel panel;
    private JButton loginButton;
    private JButton signUpButton;
    private JButton backButton;
    private JButton signOutButton;
    private JButton addButton;
    private JButton addAppointmentButton;
    private JButton viewButton;
    private JButton addPrescriptionButton;
    private JButton viewAppointmentsButton;
    private JButton viewPatientDetailsButton;
    private JComboBox<Patient> patientComboBox;
    private JTextArea displayArea;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private ClinicManagement clinicManagement;
    private User loggedInUser;

    public DentalClinicGUI() {
        // Initialize ClinicManagement
        clinicManagement = new ClinicManagement();
        initializeSampleData();

        // Create the main frame
        frame = new JFrame("Dental Clinic Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Show login screen
        showLoginScreen();

        // Set frame visibility
        frame.setVisible(true);
    }

    private void showLoginScreen() {
        panel = new JPanel();
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(10, 20, 80, 25);
        panel.add(usernameLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(100, 20, 165, 25);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 50, 165, 25);
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 150, 25);
        panel.add(loginButton);

        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(170, 80, 150, 25);
        panel.add(signUpButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authenticateUser();
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSignUpScreen();
            }
        });

        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
    }

    private void showSignUpScreen() {
        panel = new JPanel();
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(10, 20, 80, 25);
        panel.add(usernameLabel);

        JTextField signUpUsernameField = new JTextField(20);
        signUpUsernameField.setBounds(100, 20, 165, 25);
        panel.add(signUpUsernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField signUpPasswordField = new JPasswordField(20);
        signUpPasswordField.setBounds(100, 50, 165, 25);
        panel.add(signUpPasswordField);

        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setBounds(10, 80, 80, 25);
        panel.add(roleLabel);

        String[] roles = {"Doctor", "Receptionist"};
        JComboBox<String> roleComboBox = new JComboBox<>(roles);
        roleComboBox.setBounds(100, 80, 165, 25);
        panel.add(roleComboBox);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(10, 110, 150, 25);
        panel.add(registerButton);

        backButton = new JButton("Back");
        backButton.setBounds(170, 110, 150, 25);
        panel.add(backButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = signUpUsernameField.getText();
                String password = new String(signUpPasswordField.getPassword());
                String role = (String) roleComboBox.getSelectedItem();

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Username and password cannot be empty.");
                } else {
                    if (role.equals("Doctor")) {
                        clinicManagement.addDoctor(new Doctor(username, password));
                    } else {
                        clinicManagement.addReceptionist(new Receptionist(username, password, clinicManagement));
                    }
                    JOptionPane.showMessageDialog(frame, "Registration successful!");
                    showLoginScreen();
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLoginScreen();
            }
        });

        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
    }

    private void authenticateUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        loggedInUser = authenticate(username, password);
        if (loggedInUser != null) {
            JOptionPane.showMessageDialog(frame, "Login successful!");
            showMainMenu();
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid credentials. Please try again.");
        }
    }

    private User authenticate(String username, String password) {
        for (Doctor doctor : clinicManagement.getDoctors()) {
            if (doctor.getUsername().equals(username) && doctor.getPassword().equals(password)) {
                return doctor;
            }
        }
        for (Receptionist receptionist : clinicManagement.getReceptionists()) {
            if (receptionist.getUsername().equals(username) && receptionist.getPassword().equals(password)) {
                return receptionist;
            }
        }
        return null;
    }

    private void showMainMenu() {
        panel = new JPanel();
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Logged in as: " + loggedInUser.getUsername() + " (" + loggedInUser.getClass().getSimpleName() + ")");
        userLabel.setBounds(10, 10, 300, 25);
        panel.add(userLabel);

        if (loggedInUser instanceof Receptionist) {
            addButton = new JButton("Add Patient");
            addButton.setBounds(10, 40, 150, 25);
            panel.add(addButton);

            addAppointmentButton = new JButton("Add Appointment");
            addAppointmentButton.setBounds(10, 70, 150, 25);
            panel.add(addAppointmentButton);

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addPatient();
                }
            });

            addAppointmentButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addAppointment();
                }
            });
        } else if (loggedInUser instanceof Doctor) {
            addPrescriptionButton = new JButton("Add Prescription");
            addPrescriptionButton.setBounds(10, 40, 150, 25);
            panel.add(addPrescriptionButton);

            viewAppointmentsButton = new JButton("View Appointments");
            viewAppointmentsButton.setBounds(10, 70, 150, 25);
            panel.add(viewAppointmentsButton);

            addPrescriptionButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addPrescription();
                }
            });

            viewAppointmentsButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    viewAppointments();
                }
            });
        }

        viewButton = new JButton("View Patients");
        viewButton.setBounds(10, 100, 150, 25);
        panel.add(viewButton);

        // Add patient selection components
        patientComboBox = new JComboBox<>(clinicManagement.getPatients().toArray(new Patient[0]));
        patientComboBox.setBounds(10, 130, 150, 25);
        panel.add(patientComboBox);

        viewPatientDetailsButton = new JButton("View Patient Details");
        viewPatientDetailsButton.setBounds(10, 160, 150, 25);
        panel.add(viewPatientDetailsButton);

        signOutButton = new JButton("Sign Out");
        signOutButton.setBounds(10, 190, 150, 25);
        panel.add(signOutButton);

        displayArea = new JTextArea();
        displayArea.setBounds(10, 220, 450, 130);
        panel.add(displayArea);

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewPatients();
            }
        });

        viewPatientDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Patient selectedPatient = (Patient) patientComboBox.getSelectedItem();
                if (selectedPatient != null) {
                    showPatientDetails(selectedPatient);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a patient.");
                }
            }
        });

        signOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loggedInUser = null;
                showLoginScreen();
            }
        });

        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
    }

    private void addPatient() {
        String name = JOptionPane.showInputDialog(frame, "Enter patient name:");
        String id = JOptionPane.showInputDialog(frame, "Enter patient ID:");
        String contact = JOptionPane.showInputDialog(frame, "Enter contact info:");

        if (name != null && id != null && contact != null) {
            Patient newPatient = new Patient(name, id, contact);
            clinicManagement.addPatient(newPatient);
            displayArea.append("Added patient: " + name + ", ID: " + id + ", Contact: " + contact + "\n");
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid input. Patient not added.");
        }
    }

    private void addAppointment() {
        String appointmentID = JOptionPane.showInputDialog(frame, "Enter appointment ID:");
        String date = JOptionPane.showInputDialog(frame, "Enter appointment date (YYYY-MM-DD):");
        String time = JOptionPane.showInputDialog(frame, "Enter appointment time (HH:MM AM/PM):");
        String patientID = JOptionPane.showInputDialog(frame, "Enter patient ID:");
        String doctorUsername = JOptionPane.showInputDialog(frame, "Enter doctor username:");

        Patient patient = findPatientByID(patientID);
        Doctor doctor = findDoctorByUsername(doctorUsername);

        if (patient != null && doctor != null && appointmentID != null && date != null && time != null) {
            Appointment newAppointment = new Appointment(appointmentID, date, time, patient, doctor);
            clinicManagement.addAppointment(newAppointment);
            doctor.getDailyAppointments().add(newAppointment);
            displayArea.append("Added appointment: " + appointmentID + ", Date: " + date + ", Time: " + time + ", Patient: " + patient.getName() + ", Doctor: " + doctor.getUsername() + "\n");
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid input. Appointment not added.");
        }
    }

    private void addPrescription() {
        String prescriptionID = JOptionPane.showInputDialog(frame, "Enter prescription ID:");
        String patientID = JOptionPane.showInputDialog(frame, "Enter patient ID:");
        String medication = JOptionPane.showInputDialog(frame, "Enter medication:");
        String dosage = JOptionPane.showInputDialog(frame, "Enter dosage:");
        String instructions = JOptionPane.showInputDialog(frame, "Enter instructions:");

        Patient patient = findPatientByID(patientID);
        if (patient != null && prescriptionID != null && medication != null && dosage != null && instructions != null) {
            Prescription newPrescription = new Prescription(prescriptionID, patient, medication, dosage, instructions, (Doctor) loggedInUser);
            clinicManagement.addPrescription(newPrescription);
            displayArea.append("Added prescription for patient ID: " + patientID + "\n");
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid input. Prescription not added.");
        }
    }

    private void viewAppointments() {
        Doctor doctor = (Doctor) loggedInUser;
        List<Appointment> appointments = doctor.getDailyAppointments();
        displayArea.setText(""); // Clear the display area
        for (Appointment appointment : appointments) {
            displayArea.append("Appointment: " + appointment.getAppointmentID() + ", Date: " + appointment.getDate() + ", Time: " + appointment.getTime() + ", Patient: " + appointment.getPatient().getName() + "\n");
        }
    }

    private void viewPatients() {
        List<Patient> patients = clinicManagement.getPatients();
        displayArea.setText(""); // Clear the display area
        for (Patient patient : patients) {
            displayArea.append("Patient: " + patient.getName() + ", ID: " + patient.getPatientID() + ", Contact: " + patient.getContactInfo() + "\n");
        }
    }

    private void showPatientDetails(Patient patient) {
        JFrame detailsFrame = new JFrame("Patient Details");
        detailsFrame.setSize(400, 300);
        detailsFrame.setLayout(new BorderLayout());

        JTextArea detailsArea = new JTextArea();
        detailsArea.setEditable(false);
        detailsArea.setText(getPatientDetails(patient));

        detailsFrame.add(new JScrollPane(detailsArea), BorderLayout.CENTER);
        detailsFrame.setVisible(true);
    }

    private String getPatientDetails(Patient patient) {
        StringBuilder details = new StringBuilder();
        details.append("Patient ID: ").append(patient.getPatientID()).append("\n");
        details.append("Name: ").append(patient.getName()).append("\n");
        details.append("Contact: ").append(patient.getContactInfo()).append("\n\n");

        details.append("Appointments:\n");
        for (Appointment appointment : clinicManagement.getAppointmentsByPatient(patient)) {
            details.append(appointment).append("\n");
        }

        details.append("\nPrescriptions:\n");
        for (Prescription prescription : clinicManagement.getPrescriptionsByPatient(patient)) {
            details.append(prescription).append("\n");
        }

        return details.toString();
    }

    private Patient findPatientByID(String patientID) {
        for (Patient patient : clinicManagement.getPatients()) {
            if (patient.getPatientID().equals(patientID)) {
                return patient;
            }
        }
        return null;
    }

    private Doctor findDoctorByUsername(String username) {
        for (Doctor doctor : clinicManagement.getDoctors()) {
            if (doctor.getUsername().equals(username)) {
                return doctor;
            }
        }
        return null;
    }

    private void initializeSampleData() {
        // Sample data for demonstration
        Doctor doc1 = new Doctor("doc1", "password");
        Receptionist rec1 = new Receptionist("rec1", "password", clinicManagement);
        clinicManagement.addDoctor(doc1);
        clinicManagement.addReceptionist(rec1);
    }

    public static void main(String[] args) {
        new DentalClinicGUI();
    }
}
