/*
	File Name: Doctor
	Author: Luke and Dickson
	Class: ICS4U1
	Date: Jun 14, 2024
	Purpose: Holds info on doctors.
*/

public class Doctor extends User {
    private String degree;

   //Constructor taking in general user fields as well as degree of education.
    public Doctor(int id, String firstName, String lastName, String username, String password, String degree) {
        super(id, firstName, lastName, username, password, degree);
        this.degree = degree;
    }

   //Getters
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

   //Returns a String of doctor fields in CSV format.
    public String toCSV() {
        return getId() + "," + getFirstName() + "," + getLastName() + "," + getUsername() + "," + getPassword() + "," + degree;
    }
   
   //Returns a doctor object based on a CSV String.
    public static Doctor fromCSV(String csv) {
        String[] parts = csv.split(",");
        return new Doctor(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4], parts[5]);
    }

   //Displays doctor details.
    @Override
    public void displayInfo() {
        System.out.println("Doctor ID: " + getId());
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Degree: " + degree);
        System.out.println("Contact: " + getUsername());
    }
}
