/*
	File Name: Appointment
	Author: Luke
	Class: ICS4U1
	Date: Jun 14, 2024
	Purpose: Class that holds info on appointments.
*/

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Appointment {
    private int id;
    private LocalDate date;
    private LocalTime time;

   //Constructor taking in an id, day, and time of the day.
    public Appointment(int id, LocalDate date, LocalTime time) {
        this.id = id;
        this.date = date;
        this.time = time;
    }
   
   //Getters.
    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }
   
   //Returns appointment details in CSV format.
    public abstract String toCSV();

   //Returns an appointment based on a CSV String.
    public static Appointment fromCSV(String csv, UserManagement userManagement, MedicineManagement medicineManagement) {
        String[] parts = csv.split(",");
        int id = Integer.parseInt(parts[0]);
        LocalDate date = LocalDate.parse(parts[1]);
        LocalTime time = LocalTime.parse(parts[2]);
        String type = parts[3];

        if (type.equals("Checkup")) {
            Doctor doctor = userManagement.findDoctorById(Integer.parseInt(parts[4]));
            Medicine solution = medicineManagement.findMedicineByName(parts[5]);
            return new Checkup(id, date, time, doctor, solution);
        } else if (type.equals("Surgery")) {
            List<Doctor> doctors = new ArrayList<>();
            for (int i = 4; i < parts.length; i++) {
                doctors.add(userManagement.findDoctorById(Integer.parseInt(parts[i])));
            }
            return new Surgery(id, date, time, doctors, "Some Procedure"); // Placeholder for procedure
        }
        return null;
    }

   //Displays appointment details.
    public abstract void displayDetails();
}
