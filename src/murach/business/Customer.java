/*
 * Author: Kevin Alvarado
 * Date: 12/8/2022
 * 
 * Description: This program asks you to enter a command to interact with the app
 */

package murach.business;

public class Customer {

    private String firstName;
    private String lastName;
    private String email;

    public Customer() {
        this("", "", "");
    }

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return firstName + " " + lastName;
    }
}