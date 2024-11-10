/*
	File Name: Medicine
	Author: Luke and Jing
	Class: ICS4U1
	Date: Jun 14, 2024
	Purpose: Holds info on medicines.
*/

public abstract class Medicine {
    private String name;
    private int expiryDate;
    private int stock;

   //Constructor.
    public Medicine(String name, int expiryDate, int stock) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.stock = stock;
    }

   //Getters.
    public String getName() {
        return name;
    }

    public int getExpiryDate() {
        return expiryDate;
    }

    public int getStock() {
        return stock;
    }

   //Returns a String in CSV format.
    public abstract String toCSV();

   //Display info.
    public abstract void displayInfo();

   //Returns a medicine object using a CSV String.
    public static Medicine fromCSV(String csv) {
        String[] parts = csv.split(",");
        if (parts[0].equals("OverTheCounter")) {
            return OverTheCounter.fromCSV(csv);
        } else if (parts[0].equals("PrescriptionDrug")) {
            return PrescriptionDrug.fromCSV(csv);
        }
        return null;
    }
}
