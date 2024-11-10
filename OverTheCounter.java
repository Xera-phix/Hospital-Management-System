/*
	File Name: OverTheCounter
	Author: Luke and Jing
	Class: ICS4U1
	Date: Jun 14, 2024
	Purpose: Contains OTC drug details.
*/

public class OverTheCounter extends Medicine {
    
    //Constructor.
    public OverTheCounter(String name, int expiryDate, int stock) {
        super(name, expiryDate, stock);
    }

   //Displays info.
    @Override
    public void displayInfo() {
        System.out.println("OTC Medicine Name: " + getName());
        System.out.println("Expiry Date: " + getExpiryDate());
        System.out.println("Stock: " + getStock());
    }
}
