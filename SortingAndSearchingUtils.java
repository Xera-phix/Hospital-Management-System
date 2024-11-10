/*
	File Name: SortingAndSearchingUtils
	Author: Luke
	Class: ICS4U1
	Date: Jun 14, 2024
	Purpose: Algorithms for sorting and searching the various objects in the program.
*/

import java.util.Arrays;

public class SortingAndSearchingUtils {
   
   //Quick sorts patients by name.
    public static void quickSortPatientsByName(Patient[] patients, int low, int high) {
        if (low < high) {
            int pi = partitionPatientsByName(patients, low, high);
            quickSortPatientsByName(patients, low, pi - 1);
            quickSortPatientsByName(patients, pi + 1, high);
        }
    }
   
   //Returns the pivot index to be used for the above method.
    private static int partitionPatientsByName(Patient[] patients, int low, int high) {
        Patient pivot = patients[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (patients[j].getLastName().compareTo(pivot.getLastName()) <= 0) {
                i++;
                Patient temp = patients[i];
                patients[i] = patients[j];
                patients[j] = temp;
            }
        }
        Patient temp = patients[i + 1];
        patients[i + 1] = patients[high];
        patients[high] = temp;
        return i + 1;
    }
   
   //Quick sorts doctors by name.
    public static void quickSortDoctorsByName(Doctor[] doctors, int low, int high) {
        if (low < high) {
            int pi = partitionDoctorsByName(doctors, low, high);
            quickSortDoctorsByName(doctors, low, pi - 1);
            quickSortDoctorsByName(doctors, pi + 1, high);
        }
    }
   
   //Returns the pivot index to be used for the above method.
    private static int partitionDoctorsByName(Doctor[] doctors, int low, int high) {
        Doctor pivot = doctors[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (doctors[j].getLastName().compareTo(pivot.getLastName()) <= 0) {
                i++;
                Doctor temp = doctors[i];
                doctors[i] = doctors[j];
                doctors[j] = temp;
            }
        }
        Doctor temp = doctors[i + 1];
        doctors[i + 1] = doctors[high];
        doctors[high] = temp;
        return i + 1;
    }
   
   //Quick sorts appointments by date.
    public static void quickSortAppointmentsByDate(Appointment[] appointments, int low, int high) {
        if (low < high) {
            int pi = partitionAppointmentsByDate(appointments, low, high);
            quickSortAppointmentsByDate(appointments, low, pi - 1);
            quickSortAppointmentsByDate(appointments, pi + 1, high);
        }
    }
   
   //Returns the pivot index to be used for the above method.
    private static int partitionAppointmentsByDate(Appointment[] appointments, int low, int high) {
        Appointment pivot = appointments[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (appointments[j].getDate().isBefore(pivot.getDate())) {
                i++;
                Appointment temp = appointments[i];
                appointments[i] = appointments[j];
                appointments[j] = temp;
            }
        }
        Appointment temp = appointments[i + 1];
        appointments[i + 1] = appointments[high];
        appointments[high] = temp;
        return i + 1;
    }
   
   //Quick sorts medicines by name.
    public static void quickSortMedicinesByName(Medicine[] medicines, int low, int high) {
        if (low < high) {
            int pi = partitionMedicinesByName(medicines, low, high);
            quickSortMedicinesByName(medicines, low, pi - 1);
            quickSortMedicinesByName(medicines, pi + 1, high);
        }
    }

   //Returns the pivot index to be used for the above method.
    private static int partitionMedicinesByName(Medicine[] medicines, int low, int high) {
        Medicine pivot = medicines[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (medicines[j].getName().compareTo(pivot.getName()) <= 0) {
                i++;
                Medicine temp = medicines[i];
                medicines[i] = medicines[j];
                medicines[j] = temp;
            }
        }
        Medicine temp = medicines[i + 1];
        medicines[i + 1] = medicines[high];
        medicines[high] = temp;
        return i + 1;
    }

   //Quick sorts medicines by expiry date.
    public static void quickSortMedicinesByExpiryDate(Medicine[] medicines, int low, int high) {
        if (low < high) {
            int pi = partitionMedicinesByExpiryDate(medicines, low, high);
            quickSortMedicinesByExpiryDate(medicines, low, pi - 1);
            quickSortMedicinesByExpiryDate(medicines, pi + 1, high);
        }
    }
   
   //Returns the pivot index to be used for the above method.
    private static int partitionMedicinesByExpiryDate(Medicine[] medicines, int low, int high) {
        Medicine pivot = medicines[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (medicines[j].getExpiryDate() < pivot.getExpiryDate()) {
                i++;
                Medicine temp = medicines[i];
                medicines[i] = medicines[j];
                medicines[j] = temp;
            }
        }
        Medicine temp = medicines[i + 1];
        medicines[i + 1] = medicines[high];
        medicines[high] = temp;
        return i + 1;
    }
   
   //Searches for sequentially and returns the medicine object with the given name.
    public static Medicine linearSearchMedicineByName(Medicine[] medicines, String name) {
        for (Medicine medicine : medicines) {
            if (medicine.getName().equalsIgnoreCase(name)) {
                return medicine;
            }
        }
        return null;
    }
}
