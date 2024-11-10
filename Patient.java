/*
	File Name: Patient
	Author: Luke and Dickson
	Class: ICS4U1
	Date: Jun 14, 2024
	Purpose: Contains patient fields.
*/

public class Patient extends User {
   private String contactInfo;

   //Constructor.
   public Patient(int id, String firstName, String lastName, String username, String password, String contactInfo) {
      super(id, firstName, lastName, username, password, "");
      this.contactInfo = contactInfo;
   }

   //Getter.
   public String getContactInfo() {
      return contactInfo;
   }

   //Setter.
   public void setContactInfo(String contactInfo) {
      this.contactInfo = contactInfo;
   }
   
   //Returns a String in CSV format.
   public String toCSV() {
      return getId() + "," + getFirstName() + "," + getLastName() + "," + getUsername() + "," + getPassword() + "," + contactInfo;
   }
   
   //Returns a patient using a CSV String.
   public static Patient fromCSV(String csv) {
      String[] parts = csv.split(",");
      return new Patient(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4], parts[5]);
   }
   
   //Displays information.
   @Override
   public void displayInfo() {
      System.out.println("Patient ID: " + getId());
      System.out.println("Name: " + getFirstName() + " " + getLastName());
      System.out.println("Contact: " + contactInfo);
   }
}
