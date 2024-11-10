/*
	File Name: HospitalBookingSystem
	Author: Luke
	Class: ICS4U1
	Date: Jun 14, 2024
	Purpose: Contains the main functionalities of the program that the user will use.
*/

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class HospitalBookingSystem {
    private UserManagement userManagement;
    private AppointmentManagement appointmentManagement;
    private MedicineManagement medicineManagement;

   //Constructor taking in the three management objects.
    public HospitalBookingSystem() {
        this.userManagement = new UserManagement();
        this.appointmentManagement = new AppointmentManagement();
        this.medicineManagement = new MedicineManagement();
    }
   
   //Adds the given patient.
    public void addPatient(Patient patient) {
        userManagement.addPatient(patient);
    }
   
   //Adds the given doctor.
    public void addDoctor(Doctor doctor) {
        userManagement.addDoctor(doctor);
    }
   
   //Books the given appointment.
    public void bookAppointment(Appointment appointment) {
        appointmentManagement.addAppointment(appointment);
    }

   //Cancels an appointment based on ID.
    public void cancelAppointment(int appointmentId) {
        appointmentManagement.cancelAppointment(appointmentId);
    }

   //Adds a new specified medicine.
    public void addMedicine(Medicine medicine) {
        medicineManagement.addMedicine(medicine);
    }

   //Removes a medicine based on its name.
    public void removeMedicine(String name) {
        medicineManagement.removeMedicine(name);
    }
   
   //Updates stock of medicine given its name and new amount.
    public void updateStock(String name, int newStock) {
        medicineManagement.updateStock(name, newStock);
    }
   
   //Restocks medicine given its name and the additional amount.
    public void restockMedicine(String name, int additionalStock) {
        medicineManagement.restockMedicine(name, additionalStock);
    }

   //Returns a medicine object's details given its name.
    public Medicine viewMedicineDetails(String name) {
        return medicineManagement.viewMedicineDetails(name);
    }

   //Sorts patients by name.
    public void sortPatientsByName() {
        userManagement.sortPatientsByName();
    }
   
   //Sorts doctors by name.
    public void sortDoctorsByName() {
        userManagement.sortDoctorsByName();
    }
   
   //Sorts appointments by date.
    public void sortAppointmentsByDate() {
        appointmentManagement.sortAppointmentsByDate();
    }

   //Sorts medicines by name.
    public void sortMedicinesByName() {
        medicineManagement.sortMedicinesByName();
    }
   
   //Sorts medicines by expiry date.
    public void sortMedicinesByExpiryDate() {
        medicineManagement.sortMedicinesByExpiryDate();
    }

   //Returns a patient using their name.
    public Patient searchPatientByName(String name) {
        return userManagement.searchPatientByName(name);
    }
   
   //Returns a doctor using their name.
    public Doctor searchDoctorByName(String name) {
        return userManagement.searchDoctorByName(name);
    }
   
   //Returns an appointment using its ID.
    public Appointment searchAppointmentById(int appointmentId) {
        return appointmentManagement.searchAppointmentById(appointmentId);
    }
   
   //Returns a medicine using its name.
    public Medicine searchMedicineByName(String name) {
        return medicineManagement.searchMedicineByName(name);
    }
   
   //Displays all medicines.
    public void displayAllMedicines() {
        medicineManagement.displayAllMedicines();
    }
   
   //Displays all appointments.
    public void displayAllAppointments() {
        appointmentManagement.displayAllAppointments();
    }
   
   //Displays all doctors.
    public void displayAllDoctors() {
        userManagement.displayAllDoctors();
    }
   
   //Displays all patients.
    public void displayAllPatients() {
        userManagement.displayAllPatients();
    }
   
   //Returns a doctor using their ID.
    public Doctor findDoctorById(int id) {
        return userManagement.findDoctorById(id);
    }
    
   //Saves patient info.
    public void savePatientsToFile(String filename) throws IOException {
        userManagement.savePatientsToFile(filename);
    }

   //Loads patient info.
    public void loadPatientsFromFile(String filename) throws IOException {
        userManagement.loadPatientsFromFile(filename);
    }

   //Saves doctor info.
    public void saveDoctorsToFile(String filename) throws IOException {
        userManagement.saveDoctorsToFile(filename);
    }
   
   //Loads doctor info.
    public void loadDoctorsFromFile(String filename) throws IOException {
        userManagement.loadDoctorsFromFile(filename);
    }
   
   //Saves appointment info.
    public void saveAppointmentsToFile(String filename) throws IOException {
        appointmentManagement.saveAppointmentsToFile(filename);
    }
   
   //Loads appointment info.
    public void loadAppointmentsFromFile(String filename) throws IOException {
        appointmentManagement.loadAppointmentsFromFile(filename);
    }
   
   //Saves medicine info.
    public void saveMedicinesToFile(String filename) throws IOException {
        medicineManagement.saveMedicinesToFile(filename);
    }

   //Loads medicine info.
    public void loadMedicinesFromFile(String filename) throws IOException {
        medicineManagement.loadMedicinesFromFile(filename);
    }
}
