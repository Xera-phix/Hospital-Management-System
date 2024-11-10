/*
	File Name: Surgery
	Author: Luke
	Class: ICS4U1
	Date: Jun 14, 2024
	Purpose: Contains details on a surgery.
*/

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Surgery extends Appointment {
    private List<Doctor> doctors;
    private String procedure;

   //Constructor.
    public Surgery(int id, LocalDate date, LocalTime time, List<Doctor> doctors, String procedure) {
        super(id, date, time);
        this.doctors = doctors;
        this.procedure = procedure;
    }
   
   //Getters.
    public List<Doctor> getDoctors() {
        return doctors;
    }

    public String getProcedure() {
        return procedure;
    }
   
   //Returns the surgery fields as a String in CSV format.
    @Override
    public String toCSV() {
        StringBuilder sb = new StringBuilder();
        sb.append(getId()).append(",").append(getDate()).append(",").append(getTime()).append(",Surgery");
        for (Doctor doctor : doctors) {
            sb.append(",").append(doctor.getId());
        }
        sb.append(",").append(procedure);
        return sb.toString();
    }

   //Displays details on the surgery.
    @Override
    public void displayDetails() {
        System.out.println("Surgery ID: " + getId());
        System.out.println("Date: " + getDate());
        System.out.println("Time: " + getTime());
        System.out.print("Doctors: ");
        for (Doctor doctor : doctors) {
            System.out.print(doctor.getFirstName() + " " + doctor.getLastName() + ", ");
        }
        System.out.println();
        System.out.println("Procedure: " + procedure);
    }
}
