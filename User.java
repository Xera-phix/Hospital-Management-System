/*
	File Name: User
	Author: Luke and Dickson
	Class: ICS4U1
	Date: Jun 14, 2024
	Purpose: Holds info on users.
*/

public abstract class User {
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String degree;

   //Constructor.
    public User(int id, String firstName, String lastName, String username, String password, String degree) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.degree = degree;
    }

   //Getters.
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDegree() {
        return degree;
    }

   //Displays user info.
    public abstract void displayInfo();
}
