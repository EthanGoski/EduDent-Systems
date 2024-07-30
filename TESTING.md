# Boundary Value Analysis (BVA)

Boundary Value Analysis (BVA) is a software testing technique that involves creating test cases that focus on the values at the boundaries. It is based on the assumption that errors are most likely to occur at the edges of input ranges. BVA helps in identifying defects in the boundaries rather than within the ranges.

### Input Conditions and Boundaries:

1. **Patient ID Length**: The system requires a Patient ID to be exactly 6 characters long.
    - **Boundaries**: 5 (just below), 6 (exact boundary), 7 (just above)
2. **Appointment Time Slots**: Appointments can be scheduled from 9:00 AM to 5:00 PM in 15-minute intervals.
    - **Boundaries**: 8:45 AM (just below), 9:00 AM (start boundary), 5:00 PM (end boundary), 5:15 PM (just above)
3. **Doctor's Daily Appointment Limit**: A doctor can have a maximum of 10 appointments per day.
    - **Boundaries**: 9 (just below), 10 (exact boundary), 11 (just above)

### Test Cases:

| Test Case ID | Input Condition | Boundary Values | Expected Result |
| --- | --- | --- | --- |
| TC1 | Patient ID Length | 5 characters | Error: Patient ID must be 6 characters long. |
| TC2 | Patient ID Length | 6 characters | Success: Patient ID accepted. |
| TC3 | Patient ID Length | 7 characters | Error: Patient ID must be 6 characters long. |
| TC4 | Appointment Time Slots | 8:45 AM | Error: Invalid appointment time. |
| TC5 | Appointment Time Slots | 9:00 AM | Success: Appointment scheduled. |
| TC6 | Appointment Time Slots | 5:00 PM | Success: Appointment scheduled. |
| TC7 | Appointment Time Slots | 5:15 PM | Error: Invalid appointment time. |
| TC8 | Doctor's Daily Appointments | 9 appointments | Success: Appointment added. |
| TC9 | Doctor's Daily Appointments | 10 appointments | Success: Appointment added. |
| TC10 | Doctor's Daily Appointments | 11 appointments | Error: Maximum appointment limit reached. |

# Equivalence Class Testing

Equivalence Class Testing is a black-box testing technique used to reduce the number of test cases by dividing input data into equivalence classes. Each class represents a set of valid or invalid inputs that should be treated similarly by the system. Here's how we can apply this method to the Dental Clinic Management System's features:

### 1. Patient ID Input

### Equivalence Classes:

- **Valid Patient IDs:** 1-6 number characters (e.g., 123456)
- **Invalid Patient IDs:** alphanumeric characters, IDs longer than 6 characters, empty strings

### Test Cases:

| Test Case | Input | Expected Result |
| --- | --- | --- |
| 1 | "P001" | Invalid |
| 2 | "A123B" | Invalid |
| 3 | "!@#123" | Invalid (non-alphanumeric) |
| 4 | "12345678901" | Invalid (more than 10 characters) |
| 5 | "" | Invalid (empty string) |
| 6 | 123456 | Valid |

### 2. Appointment Time

### Equivalence Classes:

- **Valid Times:** Between 9:00 AM and 5:00 PM.
- **Invalid Times:** Outside the range.

### Test Cases:

| Test Case | Input | Expected Result |
| --- | --- | --- |
| 1 | "09:00 AM" | Valid |
| 2 | "10:15 AM" | Valid |
| 3 | "05:15 PM" | Invalid (outside range) |
| 4 | "04:07 PM" | Valid  |
| 5 | "13:00 PM" | Invalid (incorrect format) |

### 3. Doctor's Daily Appointment Limit

### Equivalence Classes:

- **Valid Number of Appointments:** 0-10 appointments
- **Invalid Number of Appointments:** More than 10 appointments

### Test Cases:

| Test Case | Input (Number of Appointments) | Expected Result |
| --- | --- | --- |
| 1 | 0 | Valid |
| 2 | 5 | Valid |
| 3 | 10 | Valid |
| 4 | 11 | Invalid (exceeds limit) |

### 4. Prescription Details

### Equivalence Classes:

- **Valid Prescription Details:** Non-empty medication name, dosage, and instructions
- **Invalid Prescription Details:** Empty fields, non-numeric dosage

### Test Cases:

| Test Case | Medication | Dosage | Instructions | Expected Result |
| --- | --- | --- | --- | --- |
| 1 | "Ibuprofen" | "200mg" | "Take twice daily" | Valid |
| 2 | "" | "500mg" | "Take once daily" | Invalid (empty medication) |
| 3 | "Paracetamol" | "" | "Take as needed" | Invalid (empty dosage) |
| 4 | "Aspirin" | "abc" | "Take daily" | Invalid (non-numeric dosage) |
| 5 | "Amoxicillin" | "500mg" | "" | Invalid (empty instructions) |

---

# State Transition:

Let's consider the **Appointment Scheduling** and **User Authentication** features as examples for State Transition Testing.

### State Diagram for User Authentication

1. **Initial State:** Logged Out
2. **State 1:** Receptionist Logged In
3. **State 2:** Doctor Logged In
4. **Final State:** Logged Out

### Possible Transitions:

- **T1:** Logged Out → Receptionist Logged In (Successful receptionist login)
- **T2:** Logged Out → Doctor Logged In (Successful doctor login)
- **T3:** Any State → Logged Out (Logout action)
- **T4:** Receptionist Logged In → Receptionist Logged In (Invalid login attempt)
- **T5:** Doctor Logged In → Doctor Logged In (Invalid login attempt)

### Test Cases Based on State Transitions:

| Test Case | Initial State | Input | Expected State | Expected Output |
| --- | --- | --- | --- | --- |
| 1 | Logged Out | Receptionist Login | Receptionist Logged In | "Login successful!" |
| 2 | Logged Out | Doctor Login | Doctor Logged In | "Login successful!" |
| 3 | Receptionist Logged In | Logout | Logged Out | "Logged out successfully." |
| 4 | Doctor Logged In | Logout | Logged Out | "Logged out successfully." |
| 5 | Logged Out | Invalid Credentials | Logged Out | "Invalid credentials." |

### State Diagram for Appointment Scheduling

1. **Initial State:** No Appointment
2. **State 1:** Appointment Scheduled
3. **Final State:** Appointment Cancelled

### Possible Transitions:

- **T1:** No Appointment → Appointment Scheduled (Successful appointment scheduling)
- **T2:** Appointment Scheduled → Appointment Cancelled (Successful appointment cancellation)
- **T3:** No Appointment → No Appointment (Invalid scheduling attempt)
- **T4:** Appointment Scheduled → Appointment Scheduled (Invalid cancellation attempt)

### Test Cases Based on State Transitions:

| Test Case | Initial State | Input | Expected State | Expected Output |
| --- | --- | --- | --- | --- |
| 1 | No Appointment | Valid Schedule | Appointment Scheduled | "Appointment scheduled successfully." |
| 2 | Appointment Scheduled | create Appointment | Appointment created | "Appointment created successfully." |
| 3 | No Appointment | Invalid Schedule | No Appointment | "Invalid scheduling attempt." |
| 4 | Appointment Scheduled | Invalid Cancel | Appointment Scheduled | "Invalid cancellation attempt." |

---

# Use Case Testing:

Let's consider the primary use cases for the system:

1. **UC1: User Login**
2. **UC2: Schedule Appointment**
3. **UC3: Cancel Appointment**
4. **UC4: Add Patient Record**
5. **UC5: View Daily Appointments**
6. **UC6: Add Prescription**

Each use case can be expanded into scenarios that describe the typical and alternative paths through the system.

### UC1: User Login

**Primary Scenario: Successful Login**

- **Actor:** User (Doctor/Receptionist)
- **Preconditions:** User has valid credentials.
- **Steps:**
    1. User enters username and password.
    2. System authenticates the credentials.
    3. System grants access based on user role.
- **Postconditions:** User is logged in and can access the system's features.

**Alternative Scenario: Failed Login**

- **Actor:** User (Doctor/Receptionist)
- **Preconditions:** User enters invalid credentials.
- **Steps:**
    1. User enters username and password.
    2. System fails to authenticate credentials.
    3. System displays an error message.
- **Postconditions:** User remains logged out.

### UC2: Schedule Appointment

**Primary Scenario: Appointment Scheduled Successfully**

- **Actor:** Receptionist
- **Preconditions:** Patient and doctor exist in the system; doctor has available time slots.
- **Steps:**
    1. Receptionist selects a patient and a doctor.
    2. Receptionist enters appointment details (date, time).
    3. System checks the doctor's schedule for conflicts.
    4. System schedules the appointment.
    5. System confirms the appointment to the receptionist.
- **Postconditions:** Appointment is scheduled, and notifications are sent to the patient and doctor.

**Alternative Scenario: Doctor's Schedule Full**

- **Actor:** Receptionist
- **Preconditions:** Doctor's schedule is full for the selected date and time.
- **Steps:**
    1. Receptionist selects a patient and a doctor.
    2. Receptionist enters appointment details (date, time).
    3. System checks the doctor's schedule for conflicts.
    4. System finds no available time slots.
    5. System notifies the receptionist of the scheduling conflict.
- **Postconditions:** Appointment is not scheduled.

### UC3: Deleting Patients

**Primary Scenario: Appointment Cancelled Successfully**

- **Actor:** Receptionist
- **Preconditions:** A Patient exists for the system.
- **Steps:**
    1. Receptionist selects an existing patient.
    2. receptionist deletes the patient.
    3. System confirms the removal of the patient.
- **Postconditions:** patient is deleted.

### UC4: Edit Patient Records

**Primary Scenario: Patient Record Added Successfully**

- **Actor:** Receptionist
- **Preconditions:** Patient is already in the system.
- **Steps:**
    1. Receptionist enters patient details (name, ID, contact info).
    2. Receptionist edits and adds the patient record to the database.
    3. System confirms the addition to the receptionist.
- **Postconditions:** Patient record is newly updated to the system.

### UC5: View Daily Appointments

**Primary Scenario: View Appointments**

- **Actor:** Doctor
- **Preconditions:** Doctor is logged in.
- **Steps:**
    1. Doctor requests to view daily appointments.
    2. System retrieves the list of appointments for the day.
    3. System displays the appointments to the doctor.
- **Postconditions:** Doctor views the appointments.

### UC6: Add Prescription

**Primary Scenario: Prescription Added Successfully**

- **Actor:** Doctor
- **Preconditions:** Patient exists in the system.
- **Steps:**
    1. Doctor selects a patient.
    2. Doctor enters prescription details (medication, dosage, instructions).
    3. System adds the prescription to the patient's record.
    4. System confirms the addition to the doctor.
- **Postconditions:** Prescription is added to the patient's record.
