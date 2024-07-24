# Tests for Each file

# AppointmentTest File

## 1.Boundary Value Testing

Tests that focus on the edge values of input domains.

```java
@Test
public void testSetDate() {
    // Test minimum date boundary
    appointment.setDate("2024-01-01");
    assertEquals("2024-01-01", appointment.getDate());

    // Test maximum date boundary
    appointment.setDate("2024-12-31");
    assertEquals("2024-12-31", appointment.getDate());
}
```
## 2.Equivalence Class Testing
Tests that validate representative values from different classes of inputs.
```java
@Test
public void testSetDate() {
    // Valid date
    appointment.setDate("2024-08-05");
    assertEquals("2024-08-05", appointment.getDate());

    // Invalid date (equivalence class of invalid dates)
    try {
        appointment.setDate("invalid-date");
        fail("Should throw an exception for invalid date");
    } catch (IllegalArgumentException e) {
        // Expected exception
    }
}
```
## 3.Decision Table Testing
```java
@Test
public void testDecisionTableForAppointment() {
    // New patient, valid date and time
    patient = new Patient("John Doe", "P001", "555-1234");
    appointment = new Appointment("A001", "2024-07-05", "10:00 AM", patient, doctor);
    assertTrue(appointment.isValid());

    // Returning patient, valid date and time
    patient.setReturning(true);
    appointment = new Appointment("A002", "2024-07-06", "11:00 AM", patient, doctor);
    assertTrue(appointment.isValid());

    // Invalid date, valid time
    try {
        appointment = new Appointment("A003", "invalid-date", "11:00 AM", patient, doctor);
        fail("Should throw an exception for invalid date");
    } catch (IllegalArgumentException e) {
        // Expected exception
    }
}
```
## 4.State Transition Testing
```java
@Test
public void testStateTransition() {
    // Initial state: Scheduled
    assertEquals(AppointmentState.SCHEDULED, appointment.getState());

    // Transition to Completed
    appointment.complete();
    assertEquals(AppointmentState.COMPLETED, appointment.getState());

    // Transition to Cancelled from Completed should fail
    try {
        appointment.cancel();
        fail("Cannot cancel a completed appointment");
    } catch (IllegalStateException e) {
        // Expected exception
    }
}
```
## 5.Use Case testing
```java
@Test
public void testUseCaseAppointmentScheduling() {
    // Receptionist logs in and schedules an appointment
    User receptionist = new User("receptionist", "password");
    assertTrue(receptionist.login());

    // Enter patient details and schedule appointment
    Patient patient = new Patient("Bob", "P002", "555-5678");
    receptionist.addPatient(patient);
    assertTrue(patient.isInSystem());
    // Check available slots and schedule appointment
    Appointment appointment = new Appointment("A004", "2024-07-10", "12:00 PM", patient, doctor);
    receptionist.scheduleAppointment(appointment);
    assertTrue(appointment.isScheduled());
}
```











# DoctorTest.java

## 1.Boundary Value Testing
```java
@Test
public void testDoctorIDBoundaryValues() {
    // Minimum length ID
    doctor.setDoctorID("D1");
    assertEquals("D1", doctor.getDoctorID());

    // Maximum length ID
    doctor.setDoctorID("D123456789012345");
    assertEquals("D123456789012345", doctor.getDoctorID());
}
```
## 2.Equivalence Class Testing
```java
@Test
public void testSetSpecializationEquivalenceClasses() {
    // Valid specialization
    doctor.setSpecialization("Orthodontics");
    assertEquals("Orthodontics", doctor.getSpecialization());

    // Invalid specialization
    try {
        doctor.setSpecialization("123");
        fail("Should throw an exception for invalid specialization");
    } catch (IllegalArgumentException e) {
        // Expected exception
    }
}
```
## 3.Decision Table Testing
```java
@Test
public void testDecisionTableForDoctorAvailability() {
    // Available on Monday
    doctor.setAvailability("Monday", true);
    assertTrue(doctor.isAvailable("Monday"));

    // Not available on Tuesday
    doctor.setAvailability("Tuesday", false);
    assertFalse(doctor.isAvailable("Tuesday"));

    // Invalid day
    try {
        doctor.setAvailability("InvalidDay", true);
        fail("Should throw an exception for invalid day");
    } catch (IllegalArgumentException e) {
        // Expected exception
    }
}
```
## 4.State Transition Testing
```java
@Test
public void testStateTransition() {
    // Initial state: Active
    assertEquals(DoctorState.ACTIVE, doctor.getState());

    // Transition to Inactive
    doctor.deactivate();
    assertEquals(DoctorState.INACTIVE, doctor.getState());

    // Transition to Retired from Inactive
    doctor.retire();
    assertEquals(DoctorState.RETIRED, doctor.getState());
}
```
## 5.Use Case testing
```java
@Test
public void testUseCaseDoctorLogin() {
    // Doctor logs in
    Doctor doctor = new Doctor("doc1", "password");
    assertTrue(doctor.login());

    // Doctor updates profile
    doctor.setSpecialization("Pediatrics");
    assertEquals("Pediatrics", doctor.getSpecialization());

    // Doctor checks availability
    doctor.setAvailability("Wednesday", true);
    assertTrue(doctor.isAvailable("Wednesday"));
}
```











# PatientTest.java

## 1.Boundary Value Testing
```java
@Test
public void testPatientIDBoundaryValues() {
    // Minimum length ID
    patient.setPatientID("P1");
    assertEquals("P1", patient.getPatientID());

    // Maximum length ID
    patient.setPatientID("P123456789012345");
    assertEquals("P123456789012345", patient.getPatientID());
}
```
## 2.Equivalence Class Testing
```java
@Test
public void testSetContactInfoEquivalenceClasses() {
    // Valid contact info
    patient.setContactInfo("555-0000");
    assertEquals("555-0000", patient.getContactInfo());

    // Invalid contact info (equivalence class of invalid contacts)
    try {
        patient.setContactInfo("invalid-contact");
        fail("Should throw an exception for invalid contact info");
    } catch (IllegalArgumentException e) {
        // Expected exception
    }
}
```
## 3.Decision Table Testing
```java
@Test
public void testDecisionTableForPatientUpdate() {
    // Valid name and contact info
    patient.setName("Jane Doe");
    patient.setContactInfo("555-0000");
    assertEquals("Jane Doe", patient.getName());
    assertEquals("555-0000", patient.getContactInfo());

    // Invalid name and valid contact info
    try {
        patient.setName("");
        fail("Should throw an exception for invalid name");
    } catch (IllegalArgumentException e) {
        // Expected exception
    }

    // Valid name and invalid contact info
    try {
        patient.setContactInfo("invalid-contact");
        fail("Should throw an exception for invalid contact info");
    } catch (IllegalArgumentException e) {
        // Expected exception
    }
}
```
## 4.State Transition Testing
```java
@Test
public void testStateTransition() {
    // Initial state: New patient
    assertEquals(PatientState.NEW, patient.getState());

    // Transition to Active
    patient.activate();
    assertEquals(PatientState.ACTIVE, patient.getState());

    // Transition to Inactive from Active
    patient.deactivate();
    assertEquals(PatientState.INACTIVE, patient.getState());

    // Invalid transition from Inactive to New
    try {
        patient.setState(PatientState.NEW);
        fail("Cannot transition from Inactive to New");
    } catch (IllegalStateException e) {
        // Expected exception
    }
}
```
## 5.Use Case testing
```java
@Test
public void testUseCasePatientRegistration() {
    // Receptionist registers a new patient
    User receptionist = new User("receptionist", "password");
    assertTrue(receptionist.login());

    // Receptionist enters patient details
    Patient newPatient = new Patient("Alice Smith", "P002", "555-5678");
    receptionist.addPatient(newPatient);
    assertTrue(newPatient.isInSystem());

    // Verify patient details
    assertEquals("Alice Smith", newPatient.getName());
    assertEquals("P002", newPatient.getPatientID());
    assertEquals("555-5678", newPatient.getContactInfo());
}
```















# ReceptionestTest.java

## 1.Boundary Value Testing
```java
@Test
public void testAddPatientBoundaryValues() {
    // Minimum length ID
    Patient patientMinID = new Patient("John Doe", "P1", "555-1234");
    receptionist.addPatient(patientMinID);
    assertTrue(receptionist.getPatients().contains(patientMinID));

    // Maximum length ID
    Patient patientMaxID = new Patient("John Doe", "P123456789012345", "555-1234");
    receptionist.addPatient(patientMaxID);
    assertTrue(receptionist.getPatients().contains(patientMaxID));
}
```
## 2.Equivalence Class Testing
```java
@Test
public void testUpdatePatientEquivalenceClasses() {
    receptionist.addPatient(patient);
    
    // Valid contact info
    patient.setContactInfo("555-0000");
    assertEquals("555-0000", receptionist.getPatients().get(0).getContactInfo());

    // Invalid contact info (equivalence class of invalid contacts)
    try {
        patient.setContactInfo("invalid-contact");
        fail("Should throw an exception for invalid contact info");
    } catch (IllegalArgumentException e) {
        // Expected exception
    }
}
```
## 3.Decision Table Testing
```java
@Test
public void testDecisionTableForPatientManagement() {
    // Add patient with valid details
    Patient validPatient = new Patient("Jane Doe", "P002", "555-5678");
    receptionist.addPatient(validPatient);
    assertTrue(receptionist.getPatients().contains(validPatient));

    // Remove patient with valid details
    receptionist.removePatient(validPatient);
    assertFalse(receptionist.getPatients().contains(validPatient));

    // Add patient with invalid details
    try {
        Patient invalidPatient = new Patient("", "P003", "555-5678");
        receptionist.addPatient(invalidPatient);
        fail("Should throw an exception for invalid patient details");
    } catch (IllegalArgumentException e) {
        // Expected exception
    }
}
```
## 4.State Transition Testing
```java
@Test
public void testStateTransition() {
    // Initial state: No patients
    assertEquals(0, receptionist.getPatients().size());

    // Transition to having one patient
    receptionist.addPatient(patient);
    assertEquals(1, receptionist.getPatients().size());

    // Transition to having no patients
    receptionist.removePatient(patient);
    assertEquals(0, receptionist.getPatients().size());

    // Invalid transition: removing a non-existent patient
    try {
        receptionist.removePatient(patient);
        fail("Should throw an exception for removing a non-existent patient");
    } catch (IllegalStateException e) {
        // Expected exception
    }
}
```
## 5.Use Case testing
```java
@Test
public void testUseCaseManagingPatient() {
    // Receptionist logs in and adds a new patient
    User receptionistUser = new User("receptionist", "password");
    assertTrue(receptionistUser.login());

    // Add patient details
    Patient newPatient = new Patient("Alice Smith", "P002", "555-5678");
    receptionist.addPatient(newPatient);
    assertTrue(newPatient.isInSystem());

    // Verify patient details
    assertEquals("Alice Smith", newPatient.getName());
    assertEquals("P002", newPatient.getPatientID());
    assertEquals("555-5678", newPatient.getContactInfo());
}
```






