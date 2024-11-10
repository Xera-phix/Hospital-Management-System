/*
	File Name: AppointmentManagement
	Author: Luke
	Class: ICS4U1
	Date: Jun 14, 2024
	Purpose: Class that handles appointment functionalities (e.g. cancelling, sorting).
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppointmentManagement {
    private List<Appointment> appointments;

   //Constructor.
    public AppointmentManagement() {
        this.appointments = new ArrayList<>();
    }

    //Saves appointments to a file.
    public void saveAppointmentsToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Appointment appointment : appointments) {
                writer.write(appointment.toCSV());
                writer.newLine();
            }
        }
    }

    //Loads appointments from a file.
    public void loadAppointmentsFromFile(String filename, UserManagement userManagement, MedicineManagement medicineManagement) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                appointments.add(Appointment.fromCSV(line, userManagement, medicineManagement));
            }
        }
    }

    //Adds a given appointment.
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }
   
   //Cancels the given appointment based on its ID.
    public void cancelAppointment(int id) {
        appointments.removeIf(appointment -> appointment.getId() == id);
    }

   //Returns an appointment using its given ID.
    public Appointment searchAppointmentById(int id) {
        for (Appointment appointment : appointments) {
            if (appointment.getId() == id) {
                return appointment;
            }
        }
        return null;
    }
   
   //Sorts appointments by date.
    public void sortAppointmentsByDate() {
        Appointment[] appointmentArray = appointments.toArray(new Appointment[0]);
        SortingAndSearchingUtils.quickSortAppointmentsByDate(appointmentArray, 0, appointmentArray.length - 1);
        appointments = new ArrayList<>(Arrays.asList(appointmentArray));
    }

   //Displays all appointments.
    public void displayAllAppointments() {
        for (Appointment appointment : appointments) {
            appointment.displayDetails();
        }
    }
}
