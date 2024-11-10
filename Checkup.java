/*
	File Name: Checkup
	Author: Luke
	Class: ICS4U1
	Date: Jun 14, 2024
	Purpose: Class that holds info on checkups
*/

import java.time.LocalDate;
import java.time.LocalTime;

public class Checkup extends Appointment {
    private Doctor doctor;
    private Medicine solution;

   //Constructor taking in general appointment details as well as the involved doctor and solution to the patient's issue.
    public Checkup(int id, LocalDate date, LocalTime time, Doctor doctor, Medicine solution) {
        super(id, date, time);
        this.doctor = doctor;
        this.solution = solution;
    }

   //Getters.
    public Doctor getDoctor() {
        return doctor;
    }

    public Medicine getSolution() {
        return solution;
    }

   //Returns checkup details in CSV format.
    @Override
    public String toCSV() {
        return getId() + "," + getDate() + "," + getTime() + ",Checkup," + (doctor != null ? doctor.getId() : "") + "," + (solution != null ? solution.getName() : "");
    }

   //Returns a checkup object based on a CSV String.
    public static Checkup fromCSV(String csv, UserManagement userManagement, MedicineManagement medicineManagement) {
        String[] parts = csv.split(",");
        Doctor doctor = userManagement.findDoctorById(Integer.parseInt(parts[4]));
        Medicine solution = medicineManagement.findMedicineByName(parts[5]);
        return new Checkup(Integer.parseInt(parts[0]), LocalDate.parse(parts[1]), LocalTime.parse(parts[2]), doctor, solution);
    }
    
   //Displays checkup details.
   @Override
   public void displayDetails() {
      System.out.println("Checkup ID: " + getId());
      System.out.println("Date: " + getDate());
      System.out.println("Time: " + getTime());
      System.out.println("Doctor: " + (doctor != null ? doctor.getFirstName() + " " + doctor.getLastName() : "N/A"));
      System.out.println("Solution: " + (solution != null ? solution.getName() : "N/A"));
   }
}
