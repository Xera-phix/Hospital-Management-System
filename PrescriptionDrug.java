/*
	File Name: PrescriptionDrug
	Author: Luke and Jing
	Class: ICS4U1
	Date: Jun 14, 2024
	Purpose: Contains prescription drug fields.
*/

public class PrescriptionDrug extends Medicine {
    private String instructions;

   //Constructor.
    public PrescriptionDrug(String name, int expiryDate, int stock, String instructions) {
        super(name, expiryDate, stock);
        this.instructions = instructions;
    }
   
   //Getter.
    public String getInstructions() {
        return instructions;
    }

   //Displays info.
    @Override
    public void displayInfo() {
        System.out.println("Prescription Drug Name: " + getName());
        System.out.println("Expiry Date: " + getExpiryDate());
        System.out.println("Stock: " + getStock());
        System.out.println("Instructions: " + instructions);
    }
}
