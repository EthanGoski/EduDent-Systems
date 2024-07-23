# 1 Introduction

The Campus Dental Clinic at the University of Regina faces many problems including managing patient records, making appointments, billing, and maintaining inventory. As a result, this poses a burden on administration leading to longer waiting times for patients as well as mistakes in record-keeping. In response to this problem, we developed a full-fledged software application using Java Programming Language that is aimed at automating and streamlining all activities of the clinic.

The proposed dental clinic management system has been designed to provide an integrated solution which can handle different aspects of the clinic's operations. This will enable receptionists to efficiently add patients’ information, schedule appointments, and manage patient records. Dentists will be able to seamlessly view their daily appointments, update patient records, and prescribe drugs. Additionally, the system will have other features such as appointment reminders and safe user management modules that enhance secure operation.

In sections following this one, we present detailed descriptions of the design requirements of this system, implementation details used, testing strategies applied, and future work. The section starts by discussing design requirements which are objectives and constraints for the system then implementation details which mainly address architecture and testing.

# 2 Design Problem

## 2.1 Problem Definition

The University of Regina Campus Dentist Clinic is committed to delivering top-notch dental care to students, faculty, and staff. Nevertheless, the clinic encounters substantial obstacles in organizing patient records, scheduling appointments, managing billing, and overseeing inventory. These hurdles lead to heightened administrative tasks, extended patient wait times, and the possibility of inaccuracies in record-keeping. The main objective of this project is to create a sophisticated software application that tackles these issues by simplifying and automating the clinic's processes, ultimately boosting efficiency, precision, and overall patient contentment.

## 2.2 Design Requirements

### 2.2.1 Functions

The key functions for the Dental Clinic Management System mainly include:
1. **Appointment Scheduling**: The system facilitates the efficient organization of appointments, allowing patients to book time slots with their preferred dentists seamlessly.
2. **Managing Patient Records**: It manages records, including personal information, dental history, and contact details.
3. **Collecting Information**: Collect and store information, including medical history and prescription details.
4. **Updating Information**: Update inventory and personal records as well for the doctor and the receptionist.

### 2.2.2 Objectives

The primary objectives of the Dental Clinic Management System are to be:
1. **Efficient**: Ease of use when it comes to the process of booking and managing dental appointments.
2. **Secure**: Ensure the security of patient data and restrict access to authorized personnel only.
3. **Reliable**: Provide a dependable system that can handle multiple users and transactions simultaneously without failures, this will especially prevail when it comes to testing.
4. **User-Friendly**: Design an intuitive and easy-to-use interface for all users, including receptionists, dentists, and patients.
5. **Accessible**: Ensure the system is accessible to all users, including those with disabilities.
6. **Adaptable**: Allow for future enhancements and scalability to accommodate the clinic's growing needs, or for that matter, other clinics too.

### 2.2.3 Constraints

The constraints for the Dental Clinic Management System are the following:
1. **Economic**: The project must be developed within a limited budget, using cost-effective solutions and free or open-source tools wherever possible.
2. **Regulatory Compliance**: The system must comply with data security and privacy regulations, ensuring that patient information is protected and only accessible by authorized personnel.
3. **Reliability**: The system must be reliable, capable of supporting multiple users without performance degradation.
4. **Ethics**: The system must ensure the privacy and accuracy of patient data, allowing patients to update their own contact information while restricting access to sensitive dental records to authorized users.

# 3 Solution

In this section, we present an overview of the different solutions brainstormed for implementing the Dental Clinic Management System. Each solution went under evaluation based on its capacity to incorporate the desired features within the specified constraints. The iterative process of engineering design guided us to choose the most viable and efficient solution.

## 3.1 Solution 1

The initial solution entailed creating a straightforward, independent desktop application using Java Swing for the user interface and a basic file-based system for data storage. This approach was simple to execute and demanded minimal resources.

**Reasons for Not Selecting Solution 1:**
1. **Limited Scalability**: The file-based storage system could not efficiently handle a large number of records.
2. **Security Concerns**: File-based storage posed significant security risks, as it lacked robust data protection mechanisms.
3. **Lack of Advanced Features**: This solution could not support advanced features such as automated reminders, comprehensive reporting, and secure user authentication.

## 3.2 Solution 2

The second solution improved upon the first by incorporating a relational database management system (RDBMS) for data storage and using JavaFX for a more modern and responsive user interface. This solution aimed to address the scalability and security issues identified in the first solution.

**Description of Solution 2:**
1. **Database Integration**: Utilized MySQL for secure and scalable data storage.
2. **Modern UI**: Implemented a responsive user interface using JavaFX.
3. **Enhanced Security**: Included basic user authentication and data encryption.

**Reasons for Not Selecting Solution 2:**
1. **Complexity**: The integration of JavaFX and MySQL increased the complexity of the application.
2. **Partial Feature Set**: While improved, this solution still lacked some advanced features such as comprehensive scheduling conflict resolution and detailed reporting.
## 3.3 Final Solution

The final solution builds upon the improvements of the second solution, incorporating additional features and ensuring all constraints are satisfied. This solution uses a compiler-based architecture, providing a centralized platform accessible to all users through a compiler.

**Description of the Final Solution:**
1. **Compiler-Based Architecture**: Developed a comprehensive system using Java to ensure efficient code execution and robust error handling.
2. **Standalone Application**: Implemented as a standalone desktop application, providing a user-friendly interface through JavaFX.
3. **Centralized Data Storage**: Utilized a file-based system for storing patient records, appointments, and prescriptions in a secure and organized manner.
4. **Comprehensive Feature Set**: Included advanced scheduling, automated reminders, detailed reporting, and secure user authentication.

**Comparison Table**

| Feature/Constraint      | Solution 1     | Solution 2   | Final Solution |
|-------------------------|----------------|--------------|----------------|
| Scalability             | Low            | Improved     | High           |
| Security                | Low            | Medium       | High           |
| Advanced Scheduling     | No             | Partial      | Yes            |
| Automated Reminders     | No             | Yes          | Yes            |
| Detailed Reporting      | No             | Partial      | Yes            |
| User Authentication     | Basic          | Improved     | Robust         |
| Complexity              | Medium         | High         | Low            |

**Additional Comparison Table**

| Feature                    | This Solution                                             | Other Solutions                                          |
|----------------------------|-----------------------------------------------------------|----------------------------------------------------------|
| User Roles                 | Separate roles for doctors and receptionists              | Limited or no role separation                             |
| Appointment Management     | Detailed appointment scheduling and viewing capabilities  | Basic or no appointment management                        |
| Prescription Handling      | Efficient prescription management and tracking            | No integrated prescription handling                       |
| Usability                  | User-friendly interface with clear navigation             | Complicated or outdated interfaces                        |
| Expandability              | Designed with future scalability in mind                  | Limited to current features with no expansion options     |

**Reasons for Selecting the Final Solution:**
Since our main focus is on testing, the final solution offers the most comprehensive feature set, addressing all functional and non-functional requirements. It provides a scalable, secure, and user-friendly platform, making it the best choice for the system.

#### 3.3.1 Components
The final solution incorporates several key components, each serving a specific purpose to ensure smooth operation and management of the clinical system. Below is a block diagram (Fig. 1) representing the connectivity and interaction between the components.

<img width="464" alt="Screenshot 2024-07-22 at 4 56 36 PM" src="https://github.com/user-attachments/assets/49429cd1-c645-4059-bc99-f8a7f6320665">

**Fig. 1 - Block Diagram of Clinical Management System**


**Components Used:**
1. **User Authentication Module**: Handles login/logout functionality for different user roles.
2. **Appointment Scheduler**: Manages patient appointments, including adding, updating, and viewing appointments.
3. **Patient Management System**: Stores and manages patient information.
4. **Prescription Management System**: Allows doctors to create and manage prescriptions (could be expanded for connecting databases).
5. **Database**: Stores all data securely, including user information, patient details, appointments, and prescriptions.
6. **User Interface (UI)**: Provides an intuitive interface for interaction with the system.



#### 3.3.2 Features

**Table: Features of the Clinical Management System**

| Feature                          | Description                                                                                     |
|----------------------------------|-------------------------------------------------------------------------------------------------|
| User Authentication              | Secure login/logout functionality for doctors and receptionists                                 |
| Appointment Management           | Scheduling, updating, and viewing patient appointments                                          |
| Patient Information Management   | Storing and managing detailed patient records                                                   |
| Prescription Handling            | Creating, updating, and tracking prescriptions                                                  |
| Role-Based Access Control        | Ensuring that users can only access information and functionality pertinent to their role       |
| Intuitive User Interface         | Easy-to-use interface with clear navigation and usability                                       |
| Data Security                    | Secure storage and handling of all sensitive information                                        |

#### 3.3.3 Environmental, Societal, Safety, and Economic Considerations
The engineering design took into account several critical considerations:

**Environmental**:
- Reduced paper use through digital record-keeping, contributing to environmental conservation.
- Energy-efficient software development practices to minimize carbon footprint.

**Societal**:
- Improved patient care through efficient management and streamlined operations.
- Enhanced accessibility to medical records for authorized personnel, improving healthcare delivery.

**Economic**:
- Cost-effective development using open-source technologies.
- Scalable design allowing for future expansion without significant additional costs.

**Safety**:
- Data encryption to ensure patient confidentiality.
- Regular software updates and security patches to protect against vulnerabilities.

## 3.3.4 Test Cases and Results (Solution Implementation)
To ensure the robustness and reliability of the prototype, several test suites were designed:

## Solution Implementation

### MVP Descriptions
| MVP                         | Accounts for                                           | Testing                          | Conclusion                                                                                           |
|-----------------------------|--------------------------------------------------------|----------------------------------|------------------------------------------------------------------------------------------------------|
| 1. Managing Patients        | Adding, Removing, Updating, Viewing, Searching Patients| Unit                             | Works well and allows for basic patient management functionality. More features could improve usability. |
| 2. Scheduling Appointments  | Adding, Removing, Updating, Viewing, Handling Conflicts| Unit, Integration                | Handles scheduling well but could benefit from better conflict resolution and reminders.               |
| 3. Managing Prescriptions   | Adding, Removing, Updating, Viewing Prescriptions      | Unit, Integration, System        | Effective for prescription management but could be enhanced with prescription validation and alerts.    |

### Explanation:
### MVP 1: Managing Patients

Accounts for: Basic CRUD (Create, Read, Update, Delete) operations on patient records.
Testing: Unit tests focus on individual functionalities like adding, removing, and updating patient information.
Conclusion: The system effectively manages patient records but could benefit from additional features for enhanced usability.
### MVP 2: Scheduling Appointments

Accounts for: Scheduling-related functionalities including adding, removing, updating appointments, and handling conflicts.
Testing: Both unit and integration tests ensure that individual functionalities and their interactions are working correctly.
Conclusion: The appointment scheduling system works well but could be improved with better conflict resolution strategies and reminders for appointments.
### MVP 3: Managing Prescriptions

#### Accounts for: Managing prescription-related tasks including adding, removing, updating, and viewing prescriptions.
Testing: Comprehensive tests including unit, integration, and system tests to cover all aspects of prescription management.
Conclusion: The system is effective in managing prescriptions but could be enhanced with features like prescription validation and alert systems for better patient safety.
This table should provide a clear and concise overview of the MVPs, their functionalities, testing methods, and conclusions. 

## Class Diagram 
![CDentist drawio-4](https://github.com/mazenabid/ClinicalManagementSystem-Java/assets/87061766/5cffe072-2b28-4303-a575-ec3e2a6c4fd9)

### Unit Testing
Unit testing was conducted on all three MVPs, focusing on critical functions that are essential to the system's operation. This includes adding and managing patients, scheduling appointments, and managing prescriptions.

### Control Flow Graphs
#### MVP 1: Managing Patients Control Flow Graph
<img width="829" alt="Patients" src="https://github.com/mazenabid/ClinicalManagementSystem-Java/assets/87061766/22aad3a8-3b96-4ba0-8f5c-57ce54e401f0">

#### Prime Paths for Managing Patients Control Flow Graph

1. **Path 1:** `1 → 2 → 4`
   - Start → Enter patient name, ID, and contact info → Patient Exists? (Yes) → Update patient info → Save patient info to the database → End

2. **Path 2:** `1 → 3 → 4`
   - Start → Enter patient name, ID, and contact info → Patient Exists? (No) → Create new patient → Save patient info to the database → End


#### MVP 2: Scheduling Appointments Control Flow Graph
<img width="867" alt="Appointment" src="https://github.com/mazenabid/ClinicalManagementSystem-Java/assets/87061766/b2b0e625-2f7d-4eea-ae46-a688ab237960">

#### Prime Paths for Scheduling Appointments Control Flow Graph

1. **Path 1:** `1 → 2 → 3 → 4`
   - Start → Enter appointment ID, date, time, patient ID, and doctor username → Conflict Exists? (Yes) → Resolve appointment conflict → Save appointment to the database → Send appointment reminder to patient and doctor → End

2. **Path 2:** `1 → 3 → 4`
   - Start → Enter appointment ID, date, time, patient ID, and doctor username → Conflict Exists? (No) → Save appointment to the database → Send appointment reminder to patient and doctor → End


#### MVP 3: Managing Prescriptions Control Flow Graph
<img width="910" alt="Prescriptions" src="https://github.com/mazenabid/ClinicalManagementSystem-Java/assets/87061766/4ba65629-6708-402c-8f39-6b953f15c4d8">

#### Prime Paths for Managing Prescriptions Control Flow Graph

1. **Path 1:** `1 → 2 → 4 → 5`
   - Start → Enter prescription ID, patient ID, medication, dosage, instructions, and doctor username → Prescription Exists? (Yes) → Update existing prescription → Save prescription info to the database → Send prescription details to the patient → End

2. **Path 2:** `1 → 3 → 4 → 5`
   - Start → Enter prescription ID, patient ID, medication, dosage, instructions, and doctor username → Prescription Exists? (No) → Create new prescription → Save prescription info to the database → Send prescription details to the patient → End

## Prime Paths
Prime paths are a set of paths that cover all possible scenarios in the control flow graphs for each MVP. These paths ensure comprehensive testing of all functionalities. A  Summary of Prime Paths in Numbers are as follows:

### Managing Patients:
1. Path 1: `1 → 2 → 4`
2. Path 2: `1 → 3 → 4`

### Scheduling Appointments:
1. Path 1: `1 → 2 → 3 → 4`
2. Path 2: `1 → 3 → 4`

### Managing Prescriptions:
1. Path 1: `1 → 2 → 4 → 5`
2. Path 2: `1 → 3 → 4 → 5`


## Test Paths and Test Cases
Test cases were derived from the prime paths to ensure that all critical paths in the control flow graphs are tested. This includes both positive and negative test cases to cover all edge cases and potential issues.

### Test Cases Table

| **MVP**                   | **Test Case**                         | **Path**           | **Description**                                                         | **Steps**                                                                                                 | **Test Values**                                                                                              | **Expected Result**                                                                                            |
|---------------------------|---------------------------------------|--------------------|--------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------|
| Managing Patients         | Update Existing Patient Info          | `1 → 2 → 4`        | Update an existing patient's information                                 | 1. Enter patient name, ID, and contact info (existing patient)<br>2. Check if the patient exists<br>3. Update patient info<br>4. Save patient info to the database         | Patient Name: John Doe<br>Patient ID: P001<br>Contact Info: 555-1234<br>New Contact Info: 555-5678             | The patient's info is successfully updated and saved in the database.                                           |
| Managing Patients         | Create New Patient                    | `1 → 3 → 4`        | Create a new patient                                                     | 1. Enter patient name, ID, and contact info (new patient)<br>2. Check if the patient exists<br>3. Create new patient<br>4. Save patient info to the database             | Patient Name: Jane Smith<br>Patient ID: P002<br>Contact Info: 555-0000                                         | The new patient's info is successfully created and saved in the database.                                       |
| Scheduling Appointments   | Resolve Appointment Conflict          | `1 → 2 → 3 → 4`    | Resolve a conflict when scheduling an appointment                        | 1. Enter appointment ID, date, time, patient ID, and doctor username<br>2. Check if a conflict exists<br>3. Resolve the conflict<br>4. Save appointment to the database<br>5. Send appointment reminder to patient and doctor | Appointment ID: A001<br>Date: 2024-07-10<br>Time: 10:00 AM<br>Patient ID: P001<br>Doctor Username: doc1        | The appointment conflict is resolved, and the appointment is saved and reminders are sent.                      |
| Scheduling Appointments   | Save Appointment without Conflict     | `1 → 3 → 4`        | Save an appointment without any conflicts                                | 1. Enter appointment ID, date, time, patient ID, and doctor username<br>2. Check if a conflict exists<br>3. Save appointment to the database<br>4. Send appointment reminder to patient and doctor | Appointment ID: A002<br>Date: 2024-07-11<br>Time: 11:00 AM<br>Patient ID: P002<br>Doctor Username: doc2        | The appointment is saved and reminders are sent without any conflicts.                                          |
| Managing Prescriptions    | Update Existing Prescription          | `1 → 2 → 4 → 5`    | Update an existing prescription                                          | 1. Enter prescription ID, patient ID, medication, dosage, instructions, and doctor username<br>2. Check if the prescription exists<br>3. Update existing prescription<br>4. Save prescription info to the database<br>5. Send prescription details to the patient | Prescription ID: RX001<br>Patient ID: P001<br>Medication: Ibuprofen<br>Dosage: 200mg<br>Instructions: Take twice daily<br>Doctor Username: doc1<br>New Dosage: 300mg | The existing prescription is updated, saved in the database, and details are sent to the patient.              |
| Managing Prescriptions    | Create New Prescription               | `1 → 3 → 4 → 5`    | Create a new prescription                                                | 1. Enter prescription ID, patient ID, medication, dosage, instructions, and doctor username<br>2. Check if the prescription exists<br>3. Create new prescription<br>4. Save prescription info to the database<br>5. Send prescription details to the patient | Prescription ID: RX002<br>Patient ID: P002<br>Medication: Paracetamol<br>Dosage: 500mg<br>Instructions: Take thrice daily<br>Doctor Username: doc2 | The new prescription is created, saved in the database, and details are sent to the patient.                   |


# Integration Testing

## Def-Use Graphs

### Managing Patients Def-Use Graph

```mermaid
graph TD
    A[Initialize Patient Details] --> B[Enter patient name, ID, and contact info]
    B --> C{Patient Exists?}
    C -- Yes --> D[Update patient info]
    C -- No --> E[Create new patient]
    D --> F[Save patient info to the database]
    E --> F[Save patient info to the database]
```
### Scheduling Appointments Def-Use Graph
```mermaid
graph TD
    A[Initialize Appointment Details] --> B[Enter appointment ID, date, time, patient ID, and doctor username]
    B --> C{Conflict Exists?}
    C -- Yes --> D[Resolve appointment conflict]
    C -- No --> E[Save appointment to the database]
    D --> E[Save appointment to the database]
    E --> F[Send appointment reminder to patient and doctor]
```

### Managing Prescriptions Def-Use Graph
```mermaid
graph TD
    A[Initialize Prescription Details] --> B[Enter prescription ID, patient ID, medication, dosage, instructions, and doctor username]
    B --> C{Prescription Exists?}
    C -- Yes --> D[Update existing prescription]
    C -- No --> E[Create new prescription]
    D --> F[Save prescription info to the database]
    E --> F[Save prescription info to the database]
    F --> G[Send prescription details to the patient]
```

## DU Paths and Test Cases

### DU Paths for Managing Patients

**DU Path 1:** `Initialize Patient Details -> Enter patient name, ID, and contact info -> Patient Exists? -> Update patient info -> Save patient info to the database`

**DU Path 2:** `Initialize Patient Details -> Enter patient name, ID, and contact info -> Patient Exists? -> Create new patient -> Save patient info to the database`

### Test Cases for Managing Patients

| **Test Case**                         | **Path**                          | **Description**                                                         | **Test Values**                                                                                              | **Expected Result**                                                                                            |
|---------------------------------------|-----------------------------------|--------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------|
| Update Existing Patient Info          | Initialize -> Enter -> Exists? -> Update -> Save | Update an existing patient's information                                 | Patient Name: John Doe, Patient ID: P001, Contact Info: 555-1234, New Contact Info: 555-5678                   | The patient's info is successfully updated and saved in the database.                                           |
| Create New Patient                    | Initialize -> Enter -> Exists? -> Create -> Save | Create a new patient                                                     | Patient Name: Jane Smith, Patient ID: P002, Contact Info: 555-0000                                             | The new patient's info is successfully created and saved in the database.                                       |

### DU Paths for Scheduling Appointments

**DU Path 1:** `Initialize Appointment Details -> Enter appointment ID, date, time, patient ID, and doctor username -> Conflict Exists? -> Resolve appointment conflict -> Save appointment to the database -> Send appointment reminder to patient and doctor`

**DU Path 2:** `Initialize Appointment Details -> Enter appointment ID, date, time, patient ID, and doctor username -> Conflict Exists? -> Save appointment to the database -> Send appointment reminder to patient and doctor`

### Test Cases for Scheduling Appointments

| **Test Case**                         | **Path**                                             | **Description**                                                         | **Test Values**                                                                                              | **Expected Result**                                                                                            |
|---------------------------------------|------------------------------------------------------|--------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------|
| Resolve Appointment Conflict          | Initialize -> Enter -> Conflict Exists? -> Resolve -> Save -> Send | Resolve a conflict when scheduling an appointment                        | Appointment ID: A001, Date: 2024-07-10, Time: 10:00 AM, Patient ID: P001, Doctor Username: doc1                | The appointment conflict is resolved, and the appointment is saved and reminders are sent.                      |
| Save Appointment without Conflict     | Initialize -> Enter -> Conflict Exists? -> Save -> Send | Save an appointment without any conflicts                                | Appointment ID: A002, Date: 2024-07-11, Time: 11:00 AM, Patient ID: P002, Doctor Username: doc2                | The appointment is saved and reminders are sent without any conflicts.                                          |

### DU Paths for Managing Prescriptions

**DU Path 1:** `Initialize Prescription Details -> Enter prescription ID, patient ID, medication, dosage, instructions, and doctor username -> Prescription Exists? -> Update existing prescription -> Save prescription info to the database -> Send prescription details to the patient`

**DU Path 2:** `Initialize Prescription Details -> Enter prescription ID, patient ID, medication, dosage, instructions, and doctor username -> Prescription Exists? -> Create new prescription -> Save prescription info to the database -> Send prescription details to the patient`

### Test Cases for Managing Prescriptions

| **Test Case**                         | **Path**                                            | **Description**                                                         | **Test Values**                                                                                              | **Expected Result**                                                                                            |
|---------------------------------------|-----------------------------------------------------|--------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------|
| Update Existing Prescription          | Initialize -> Enter -> Exists? -> Update -> Save -> Send | Update an existing prescription                                          | Prescription ID: RX001, Patient ID: P001, Medication: Ibuprofen, Dosage: 200mg, Instructions: Take twice daily, Doctor Username: doc1, New Dosage: 300mg | The existing prescription is updated, saved in the database, and details are sent to the patient.              |
| Create New Prescription               | Initialize -> Enter -> Exists? -> Create -> Save -> Send | Create a new prescription                                                | Prescription ID: RX002, Patient ID: P002, Medication: Paracetamol, Dosage: 500mg, Instructions: Take thrice daily, Doctor Username: doc2 | The new prescription is created, saved in the database, and details are sent to the patient.                   |


# System Testing

System Testing was done on the entire Dental Clinic Management System. To accomplish this, we extracted a Finite State Machine and used node coverage, a form of graph coverage, to test it. We did not use logic coverage since we did not have hardcoded predicates to guard the transition between states. If we did have predicates dictating the transition in our code, we would have used logic coverage.

## Finite State Machine

```mermaid
stateDiagram
    [*] --> Initialize
    Initialize --> EnterPatientDetails: Enter patient details
    EnterPatientDetails --> CheckPatientExists: Check if patient exists
    CheckPatientExists --> UpdatePatientInfo: Update patient info if exists
    CheckPatientExists --> CreateNewPatient: Create new patient if not exists
    UpdatePatientInfo --> SavePatientInfo: Save updated patient info
    CreateNewPatient --> SavePatientInfo: Save new patient info
    SavePatientInfo --> [*]
    
    Initialize --> EnterAppointmentDetails: Enter appointment details
    EnterAppointmentDetails --> CheckConflict: Check for conflicts
    CheckConflict --> ResolveConflict: Resolve conflict if exists
    CheckConflict --> SaveAppointment: Save appointment if no conflict
    ResolveConflict --> SaveAppointment: Save resolved appointment
    SaveAppointment --> SendReminders: Send appointment reminders
    SendReminders --> [*]
    
    Initialize --> EnterPrescriptionDetails: Enter prescription details
    EnterPrescriptionDetails --> CheckPrescriptionExists: Check if prescription exists
    CheckPrescriptionExists --> UpdatePrescription: Update prescription if exists
    CheckPrescriptionExists --> CreateNewPrescription: Create new prescription if not exists
    UpdatePrescription --> SavePrescription: Save updated prescription
    CreateNewPrescription --> SavePrescription: Save new prescription
    SavePrescription --> SendPrescriptionDetails: Send prescription details
    SendPrescriptionDetails --> [*]
```

## ECLIPSE Test Cases & Test Coverages
Now that we have all the theoritical components and the diagrams in place, it is time to check our tests on Eclispse, which the whole point of our project.

### JUnit test 
The JUnit test for our test folder in the project shows that we have 71 tests that run wih no errors or failures.

<img width="1250" alt="Screenshot 2024-07-22 at 4 39 49 PM" src="https://github.com/user-attachments/assets/a171c7c5-6fb9-4f29-9cc1-93ebef2b1e12">

### Test Coverage
The test coverage is arguably the most important part of testing our code for the project. Below you can see that we achieved a 100% test coverage on most files. You can also check each percentage for each file in the folder called `Test Coverage` in this repository.

![888A3838-A16E-40D7-B9D2-9E986AD918C6_share](https://github.com/user-attachments/assets/4f52509a-86bc-42dd-9a57-2874b2b7a06d)

- **User.java Test Coverage (80%)**
  - The test coverage for `User.java` reached 80%.
  - This was because the tests included checks for passwords, which are hardcoded.
  - Testing password-related functionality was deemed unnecessary since we are not connected to a backend database like MySQL.

- **Appointment.java Test Coverage (98.6%)**
  - The test coverage for `Appointment.java` achieved 98.6%.
  - We did not achieve 100% coverage due to the nature of a function within the class. This function compares two appointments and returns    true if they are identical or false if they are different. It also checks if any individual components within each appointment are the      same. However, since the initial comparison often returns true, the checks for individual components do not proceed further.

- **Main Method Test Coverage (0%)**
  - We did not test the main method as it is uncommon and unnecessary.
  - Consequently, the main method shows 0% coverage.

- **Overall Test Coverage (99.1%)**
  - Despite the above points, we reached an overall test coverage of 99.1% for our test cases.

#### 3.3.5 Limitations
Despite its strengths, the solution has some limitations:

- **Scalability**: While designed to be scalable, the current implementation may face performance issues with a significantly large user base.
- **User Training**: very simple training is required for users to fully utilize the system’s capabilities.
- **Integration**: Limited integration with other third-party healthcare systems, which could restrict interoperability, especially if our plan was to be used for the university, we would connect a large database with thousand of students, which could be a potential problem.

# 4 Teamwork

Since this is a group project, tasks were distributed fairly among team members. Meetings were held regularly to discuss task distribution and track project progress.

## 4.1 Meeting 1

**Time:** June 10, 2024, 10:00 AM to 11:00 AM  
**Agenda:** Distribution of Project Tasks

| Team Member      | Previous Task Completion State | Next Task |
|------------------|--------------------------------|-----------|
| Mazen Abid       | N/A                            | Task 1    |
| Ethan Goski      | N/A                            | Task 2    |
| Froillo Raquinio | N/A                            | Task 3    |

## 4.2 Meeting 2

**Time:** June 17, 2024, 2:00 PM to 3:00 PM  
**Agenda:** Review of Individual Progress

| Team Member      | Previous Task Completion State | Next Task       |
|------------------|--------------------------------|-----------------|
| Mazen Abid       | Task 1                         | 80% Task 1, Task 5 |
| Ethan Goski      | Task 2                         | 50% Task 2      |
| Froillo Raquinio | Task 3                         | 60% Task 6      |

## 4.3 Meeting 3

**Time:** June 24, 2024, 1:00 PM to 2:00 PM  
**Agenda:** Mid-Project Review

| Team Member      | Previous Task Completion State | Next Task       |
|------------------|--------------------------------|-----------------|
| Mazen Abid       | Task 1, Task 5                 | 100%, 50% Task 5, Task 7 |
| Ethan Goski      | Task 2                         | 80% Task 2, Task 8 |
| Froillo Raquinio | Task 6                         | 100% Task 9     |

## 4.4 Meeting 4

**Time:** July 22, 2024, 3:00 PM to 4:00 PM  
**Agenda:** Final Review and Testing

| Team Member      | Previous Task Completion State | Next Task       |
|------------------|--------------------------------|-----------------|
| Mazen Abid       | Task 5, Task 7                 | 100%, 90% Task 10 |
| Ethan Goski      | Task 2, Task 8                 | 100%, 70% Task 11 |
| Froillo Raquinio | Task 9                         | 100% Task 12    |

## Task List

1. Requirements Gathering: Collect detailed requirements for the Dental Clinic Management System.
2. Initial Design: Create an initial design and architecture for the system.
3. Backend Development: Develop the backend logic and data handling using Java.
4. Frontend Development: Develop the user interface using JavaFX if possible.
5. Database Setup: Configure the file-based storage system for data management.
6. Integration: Integrate the backend and frontend components if possible.
7. Unit Testing: Write and execute unit tests for individual components.
8. Integration Testing: Conduct integration testing to ensure components work together.
9. System Testing: Perform end-to-end testing of the entire system.
10. User Acceptance Testing: Ensure the system meets user requirements and expectations.
11. Documentation: Create comprehensive documentation for the system.
12. Final Review and Adjustments: Conduct a final review and make necessary adjustments.

# 5 Project Management

## Gantt Chart

Below is the Gantt chart showing the progress of our work, including tasks, their predecessors, slack time, and the critical path.
![ChartOnFig](https://github.com/user-attachments/assets/dc30a732-3434-41d6-9682-83bd7b78f11a)


## Critical Path

The critical path includes the following tasks:
1. Project Kickoff
2. Requirements Gathering
3. Initial Design
4. Final Design
5. Backend Development
6. Integration
7. System Testing
8. User Acceptance Testing
9. Documentation
10. Final Review and Adjustments
11. Project Completion

## Slack Time

Slack time for non-critical tasks (e.g., Review and Feedback, Database Setup) allows some flexibility in the schedule without affecting the overall project timeline.


# 6 Conclusion and Future Work

## Conclusion

In this project, we successfully designed and implemented the Dental Clinic Management System, meeting the project's functional and non-functional requirements. The key achievements include:
1. Efficiently scheduling appointments for patients with dentists.
2. Managing basic patient records, including personal information and contact details.
3. User login functionality for doctors and receptionists.
4. Allowing doctors to assign and manage patient prescriptions.
5. Enabling doctors to view their scheduled appointments for the day.
6. Allowing receptionists to add, edit, and delete patient information.
7. Storing data securely in a file-based system.

By achieving these objectives, we satisfied the constraints of security, scalability, reliability, and user-friendliness.

## Future Work

While the final solution meets the current needs of the University of Regina Campus Dentist Clinic, there are opportunities for future improvements:
1. **Visual Representations**: Develop dashboards for visualizing key metrics such as patient statistics, appointment schedules, and prescription details.
2. **Enhanced Appointment Scheduling**: Implement features for rescheduling and canceling appointments more efficiently, with automated notifications.
3. **Comprehensive Clinic Management**: Integrate billing, inventory management, and patient feedback mechanisms into a more holistic system.
4. **Interactive Features**: Incorporate more interactive features, such as patient portals for accessing dental records and booking appointments online.
5. **Advanced Reporting**: Enhance reporting capabilities to provide deeper insights into clinic operations and patient care trends.
6. **Machine Learning**: Explore the integration of machine learning algorithms to predict patient no-shows, optimize appointment schedules, and personalize patient care.

