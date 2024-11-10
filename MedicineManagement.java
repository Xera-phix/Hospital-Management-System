/*
	File Name: MedicineManagement
	Author: Luke
	Class: ICS4U1
	Date: Jun 14, 2024
	Purpose: Handles medicine functionalities (e.g. updating stock).
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MedicineManagement {
    private List<Medicine> medicines;

   //Constructor.
    public MedicineManagement() {
        this.medicines = new ArrayList<>();
    }

    //Save medicines to file
    public void saveMedicinesToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Medicine medicine : medicines) {
                writer.write(medicine.toCSV());
                writer.newLine();
            }
        }
    }

    // Load medicines from file
    public void loadMedicinesFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                medicines.add(Medicine.fromCSV(line));
            }
        }
    }
    
    //Adds the given medicine.
    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }
   
   //Removes the named medicine.
    public void removeMedicine(String name) {
        medicines.removeIf(medicine -> medicine.getName().equalsIgnoreCase(name));
    }

   //Updates the stock of the named medicine with the given amount.
    public void updateStock(String name, int newStock) {
        for (Medicine medicine : medicines) {
            if (medicine.getName().equalsIgnoreCase(name)) {
                medicine.setStock(newStock);
                return;
            }
        }
    }

   //Restocks the named medicine with the given amount.
    public void restockMedicine(String name, int additionalStock) {
        for (Medicine medicine : medicines) {
            if (medicine.getName().equalsIgnoreCase(name)) {
                medicine.setStock(medicine.getStock() + additionalStock);
                return;
            }
        }
    }

   //Returns the named medicine for displaying details.
    public Medicine viewMedicineDetails(String name) {
        for (Medicine medicine : medicines) {
            if (medicine.getName().equalsIgnoreCase(name)) {
                return medicine;
            }
        }
        return null;
    }

   //Sorts medicines by name.
    public void sortMedicinesByName() {
        Medicine[] medicineArray = medicines.toArray(new Medicine[0]);
        SortingAndSearchingUtils.quickSortMedicinesByName(medicineArray, 0, medicineArray.length - 1);
        medicines = new ArrayList<>(java.util.Arrays.asList(medicineArray));
    }

   //Sorts medicines by expiry date.
    public void sortMedicinesByExpiryDate() {
        Medicine[] medicineArray = medicines.toArray(new Medicine[0]);
        SortingAndSearchingUtils.quickSortMedicinesByExpiryDate(medicineArray, 0, medicineArray.length - 1);
        medicines = new ArrayList<>(java.util.Arrays.asList(medicineArray));
    }

   //Searches for named medicine.
    public Medicine searchMedicineByName(String name) {
        return SortingAndSearchingUtils.linearSearchMedicineByName(medicines.toArray(new Medicine[0]), name);
    }
    
    //Searches for named medicine.
    public Medicine findMedicineByName(String name) {
        for (Medicine medicine : medicines) {
            if (medicine.getName().equalsIgnoreCase(name)) {
                return medicine;
            }
        }
        return null;
    }

   //Displays all medicines.
    public void displayAllMedicines() {
        for (Medicine medicine : medicines) {
            medicine.displayInfo();
        }
    }
}
