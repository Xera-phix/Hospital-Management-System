/*
	File Name: Main
	Author: Luke
	Class: ICS4U1
	Date: Jun 14, 2024
	Purpose: Has the main class the user interacts with to use the program's functionalities.
*/

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HospitalBookingSystem system = new HospitalBookingSystem();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Hospital Booking System");
            System.out.println("1. Manage Patients");
            System.out.println("2. Manage Appointments");
            System.out.println("3. Manage Medicines");
            System.out.println("4. Manage Doctors");
            System.out.println("5. Save Data");
            System.out.println("6. Load Data");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    managePatients(system, scanner);
                    break;
                case 2:
                    manageAppointments(system, scanner);
                    break;
                case 3:
                    manageMedicines(system, scanner);
                    break;
                case 4:
                    manageDoctors(system, scanner);
                    break;
                case 5:
                    saveData(system);
                    break;
                case 6:
                    loadData(system);
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
        System.out.println("Thank you for using the Hospital Booking System!");
    }

    private static void managePatients(HospitalBookingSystem system, Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("Manage Patients");
            System.out.println("1. Add Patient");
            System.out.println("2. Sort Patients by Name");
            System.out.println("3. Search Patient by Name");
            System.out.println("4. Display All Patients");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add patient logic
                    System.out.print("Enter patient first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter patient last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter patient ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter patient username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter patient password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter patient contact info: ");
                    String contactInfo = scanner.nextLine();
                    Patient patient = new Patient(id, firstName, lastName, username, password, contactInfo);
                    system.addPatient(patient);
                    break;
                case 2:
                    // Sort patients by name
                    system.sortPatientsByName();
                    break;
                case 3:
                    // Search patient by name
                    System.out.print("Enter patient last name to search: ");
                    String searchPatientName = scanner.nextLine();
                    Patient foundPatient = system.searchPatientByName(searchPatientName);
                    if (foundPatient != null) {
                        foundPatient.displayInfo();
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;
                case 4:
                    // Display all patients
                    system.displayAllPatients();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void manageAppointments(HospitalBookingSystem system, Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("Manage Appointments");
            System.out.println("1. Book Appointment");
            System.out.println("2. Cancel Appointment");
            System.out.println("3. Sort Appointments by Date");
            System.out.println("4. Search Appointment by ID");
            System.out.println("5. Display All Appointments");
            System.out.println("6. Book Surgery");
            System.out.println("7. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Book appointment logic
                    System.out.print("Enter appointment ID: ");
                    int appointmentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter appointment date (YYYY-MM-DD): ");
                    String dateStr = scanner.nextLine();
                    LocalDate date = LocalDate.parse(dateStr);
                    System.out.print("Enter appointment time (HH:MM): ");
                    String timeStr = scanner.nextLine();
                    LocalTime time = LocalTime.parse(timeStr);
                    Appointment appointment = new Checkup(appointmentId, date, time, null, null); // Placeholder for doctor and solution
                    system.bookAppointment(appointment);
                    break;
                case 2:
                    // Cancel appointment logic
                    System.out.print("Enter appointment ID to cancel: ");
                    int cancelId = scanner.nextInt();
                    system.cancelAppointment(cancelId);
                    break;
                case 3:
                    // Sort appointments by date
                    system.sortAppointmentsByDate();
                    break;
                case 4:
                    // Search appointment by ID
                    System.out.print("Enter appointment ID to search: ");
                    int searchAppointmentId = scanner.nextInt();
                    Appointment foundAppointment = system.searchAppointmentById(searchAppointmentId);
                    if (foundAppointment != null) {
                        foundAppointment.displayDetails();
                    } else {
                        System.out.println("Appointment not found.");
                    }
                    break;
                case 5:
                    // Display all appointments
                    system.displayAllAppointments();
                    break;
                case 6:
                    // Book surgery logic
                    System.out.print("Enter surgery ID: ");
                    int surgeryId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter surgery date (YYYY-MM-DD): ");
                    String surgeryDateStr = scanner.nextLine();
                    LocalDate surgeryDate = LocalDate.parse(surgeryDateStr);
                    System.out.print("Enter surgery time (HH:MM): ");
                    String surgeryTimeStr = scanner.nextLine();
                    LocalTime surgeryTime = LocalTime.parse(surgeryTimeStr);
                    List<Doctor> doctors = new ArrayList<>();
                    System.out.print("Enter number of doctors: ");
                    int numberOfDoctors = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    for (int i = 0; i < numberOfDoctors; i++) {
                        System.out.print("Enter doctor ID: ");
                        int docId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        Doctor doctor = system.findDoctorById(docId);
                        if (doctor != null) {
                            doctors.add(doctor);
                        } else {
                            System.out.println("Doctor with ID " + docId + " not found.");
                        }
                    }
                    System.out.print("Enter procedure description: ");
                    String procedure = scanner.nextLine();
                    Appointment surgery = new Surgery(surgeryId, surgeryDate, surgeryTime, doctors, procedure);
                    system.bookAppointment(surgery);
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void manageDoctors(HospitalBookingSystem system, Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("Manage Doctors");
            System.out.println("1. Add Doctor");
            System.out.println("2. Sort Doctors by Name");
            System.out.println("3. Search Doctor by Name");
            System.out.println("4. Display All Doctors");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add doctor logic
                    System.out.print("Enter doctor first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter doctor last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter doctor ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter doctor username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter doctor password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter doctor degree: ");
                    String degree = scanner.nextLine();
                    Doctor doctor = new Doctor(id, firstName, lastName, username, password, degree);
                    system.addDoctor(doctor);
                    break;
                case 2:
                    // Sort doctors by name
                    system.sortDoctorsByName();
                    break;
                case 3:
                    // Search doctor by name
                    System.out.print("Enter doctor last name to search: ");
                    String searchDoctorName = scanner.nextLine();
                    Doctor foundDoctor = system.searchDoctorByName(searchDoctorName);
                    if (foundDoctor != null) {
                        foundDoctor.displayInfo();
                    } else {
                        System.out.println("Doctor not found.");
                    }
                    break;
                case 4:
                    // Display all doctors
                    system.displayAllDoctors();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void manageMedicines(HospitalBookingSystem system, Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("Manage Medicines");
            System.out.println("1. Add Medicine");
            System.out.println("2. Remove Medicine");
            System.out.println("3. Update Medicine Stock");
            System.out.println("4. View All Medicines");
            System.out.println("5. Restock Medicine");
            System.out.println("6. View Medicine Details");
            System.out.println("7. Sort Medicines by Name");
            System.out.println("8. Sort Medicines by Expiry Date");
            System.out.println("9. Search Medicine by Name");
            System.out.println("10. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add medicine logic
                    System.out.print("Enter medicine name: ");
                    String medName = scanner.nextLine();
                    System.out.print("Enter expiry date (YYYYMMDD): ");
                    int expiryDate = scanner.nextInt();
                    System.out.print("Enter stock quantity: ");
                    int stock = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Is it prescription medicine? (yes/no): ");
                    String isPrescription = scanner.nextLine();
                    if (isPrescription.equalsIgnoreCase("yes")) {
                        System.out.print("Enter instructions: ");
                        String instructions = scanner.nextLine();
                        Medicine prescriptionDrug = new PrescriptionDrug(medName, expiryDate, stock, instructions);
                        system.addMedicine(prescriptionDrug);
                    } else {
                        Medicine otc = new OverTheCounter(medName, expiryDate, stock);
                        system.addMedicine(otc);
                    }
                    break;
                case 2:
                    // Remove medicine logic
                    System.out.print("Enter medicine name to remove: ");
                    String removeMedName = scanner.nextLine();
                    system.removeMedicine(removeMedName);
                    break;
                case 3:
                    // Update medicine stock
                    System.out.print("Enter medicine name to update: ");
                    String updateMedName = scanner.nextLine();
                    System.out.print("Enter new stock quantity: ");
                    int newStock = scanner.nextInt();
                    system.updateStock(updateMedName, newStock);
                    break;
                case 4:
                    // View all medicines
                    system.displayAllMedicines();
                    break;
                case 5:
                    // Restock medicine
                    System.out.print("Enter medicine name to restock: ");
                    String restockMedName = scanner.nextLine();
                    System.out.print("Enter additional stock quantity: ");
                    int additionalStock = scanner.nextInt();
                    system.restockMedicine(restockMedName, additionalStock);
                    break;
                case 6:
                    // View medicine details
                    System.out.print("Enter medicine name to view details: ");
                    String detailsMedName = scanner.nextLine();
                    Medicine medicine = system.viewMedicineDetails(detailsMedName);
                    if (medicine != null) {
                        medicine.displayInfo();
                    } else {
                        System.out.println("Medicine not found.");
                    }
                    break;
                case 7:
                    // Sort medicines by name
                    system.sortMedicinesByName();
                    break;
                case 8:
                    // Sort medicines by expiry date
                    system.sortMedicinesByExpiryDate();
                    break;
                case 9:
                    // Search medicine by name
                    System.out.print("Enter medicine name to search: ");
                    String searchMedicineName = scanner.nextLine();
                    Medicine foundMedicine = system.searchMedicineByName(searchMedicineName);
                    if (foundMedicine != null) {
                        foundMedicine.displayInfo();
                    } else {
                        System.out.println("Medicine not found.");
                    }
                    break;
                case 10:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

   //Saves all data.
    private static void saveData(HospitalBookingSystem system) {
        try {
            system.savePatientsToFile("patients.txt");
            system.saveDoctorsToFile("doctors.txt");
            system.saveAppointmentsToFile("appointments.txt");
            system.saveMedicinesToFile("medicines.txt");
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
   
   //Loads all data.
    private static void loadData(HospitalBookingSystem system) {
        try {
            system.loadPatientsFromFile("patients.txt");
            system.loadDoctorsFromFile("doctors.txt");
            system.loadAppointmentsFromFile("appointments.txt");
            system.loadMedicinesFromFile("medicines.txt");
            System.out.println("Data loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
