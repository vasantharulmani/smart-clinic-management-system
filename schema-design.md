# Smart Clinic Management System - MySQL Database Schema

This database design includes 4 core tables with relationships, field names, data types, and keys defined.

### 1. Patients Table
* patient_id (INT, Primary Key, Auto Increment)
* first_name (VARCHAR(50), Not Null)
* last_name (VARCHAR(50), Not Null)
* email (VARCHAR(100), Unique, Not Null)
* phone_number (VARCHAR(15))
* password_hash (VARCHAR(255), Not Null)

### 2. Doctors Table
* doctor_id (INT, Primary Key, Auto Increment)
* first_name (VARCHAR(50), Not Null)
* last_name (VARCHAR(50), Not Null)
* specialty (VARCHAR(100), Not Null)
* email (VARCHAR(100), Unique, Not Null)
* available_times (TEXT)

### 3. Appointments Table
* appointment_id (INT, Primary Key, Auto Increment)
* patient_id (INT, Foreign Key referencing Patients.patient_id)
* doctor_id (INT, Foreign Key referencing Doctors.doctor_id)
* appointment_time (DATETIME, Not Null)
* status (VARCHAR(20))

### 4. Prescriptions Table
* prescription_id (INT, Primary Key, Auto Increment)
* appointment_id (INT, Foreign Key referencing Appointments.appointment_id)
* medication_details (TEXT, Not Null)
* dosage (VARCHAR(100))
* created_at (TIMESTAMP, Default Current_Timestamp)
