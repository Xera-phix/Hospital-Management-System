/*
	File Name: UserManagement
	Author: Luke
	Class: ICS4U1
	Date: Jun 14, 2024
	Purpose: Handes user functionalities.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class UserManagement {
    private List<Patient> patients;
    private List<Doctor> doctors;

   //Constructor.
    public UserManagement() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
    }

    //Save patients to file
    public void savePatientsToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Patient patient : patients) {
                writer.write(patient.toCSV());
                writer.newLine();
            }
        }
    }

    //Load patients from file
    public void loadPatientsFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                patients.add(Patient.fromCSV(line));
            }
        }
    }

    //Save doctors to file
    public void saveDoctorsToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Doctor doctor : doctors) {
                writer.write(doctor.toCSV());
                writer.newLine();
            }
        }
    }

    //Load doctors from file
    public void loadDoctorsFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                doctors.add(Doctor.fromCSV(line));
            }
        }
    }

   //Adds given patient.
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

   //Adds given doctor.
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

   //Returns doctor using ID.
    public Doctor findDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }
   
   //Sorts patients by name.
    public void sortPatientsByName() {
        Patient[] patientArray = patients.toArray(new Patient[0]);
        SortingAndSearchingUtils.quickSortPatientsByName(patientArray, 0, patientArray.length - 1);
        patients = new ArrayList<>(Arrays.asList(patientArray));
    }
   
   //Sorts doctors by name.
    public void sortDoctorsByName() {
        Doctor[] doctorArray = doctors.toArray(new Doctor[0]);
        SortingAndSearchingUtils.quickSortDoctorsByName(doctorArray, 0, doctorArray.length - 1);
        doctors = new ArrayList<>(Arrays.asList(doctorArray));
    }
   
   //Returns the named patient.
    public Patient searchPatientByName(String name) {
        for (Patient patient : patients) {
            if (patient.getLastName().equalsIgnoreCase(name)) {
                return patient;
            }
        }
        return null;
    }

   //Returns the named doctor.
    public Doctor searchDoctorByName(String name) {
        for (Doctor doctor : doctors) {
            if (doctor.getLastName().equalsIgnoreCase(name)) {
                return doctor;
            }
        }
        return null;
    }

   //Displays all doctors.
    public void displayAllDoctors() {
        for (Doctor doctor : doctors) {
            doctor.displayInfo();
        }
    }
   
   //Displays all patients.
    public void displayAllPatients() {
        for (Patient patient : patients) {
            patient.displayInfo();
        }
    }
}
