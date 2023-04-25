/*
 * Author: Kevin Alvarado

 * Date: 12/8/2022
 * 
 * Description: This program asks you to enter a command to interact with the app
 */

package murach.ui;

import java.util.List;


import javax.swing.JOptionPane;

import murach.business.Customer;
import murach.io.CustomerTextFile;

public class Main {

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Welcome to the Customer Maintenance application\n");
        displayMenu();


        String action;
        while (true) {

        	action = JOptionPane.showInputDialog(null, "Enter a command: ");

            if (action.equalsIgnoreCase("list")) {
                displayAllCustomers();
            } else if (action.equalsIgnoreCase("add")) {
                addCustomer();
            } else if (action.equalsIgnoreCase("del") || action.equalsIgnoreCase("delete")) {
                deleteCustomer();
            } else if (action.equalsIgnoreCase("help") || action.equalsIgnoreCase("menu")) {
                displayMenu();
            } else if (action.equalsIgnoreCase("exit") || action.equalsIgnoreCase("quit")) {
                quit();
            } else {
                JOptionPane.showMessageDialog(null, "Error! Not a valid command.\n");
            }
        }
    }

    public static void displayMenu() {
        JOptionPane.showMessageDialog(null, "COMMAND MENU");
        JOptionPane.showMessageDialog(null, "list    - List all customers" + "\n" +
        		"add     - Add a customer" + "\n" +
        		"del     - Delete a customer" + "\n" + 
        		"help    - Show this menu" + "\n" + 
        		"exit    - Exit this application\n");

    }

    public static void displayAllCustomers() {
        JOptionPane.showMessageDialog(null, "CUSTOMER LIST");

        List<Customer> customers = CustomerTextFile.getCustomers();
        Customer c;
        final int NAME_SIZE = 25;
        StringBuilder sb = new StringBuilder();
        for (Customer customer : customers) {
            c = customer;
            sb.append(StringUtils.padWithSpaces(
                    c.getName(), NAME_SIZE + 2));
            sb.append(c.getEmail());
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void addCustomer() {
        String firstName = JOptionPane.showInputDialog(null,"Enter first name: ");
        String lastName = JOptionPane.showInputDialog(null,"Enter last name: ");
        String email = JOptionPane.showInputDialog(null,"Enter customer email: ");

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        CustomerTextFile.addCustomer(customer);

        JOptionPane.showMessageDialog(null, firstName + " " + lastName
                + " has been added.\n");
    }

    public static void deleteCustomer() {
        String email = JOptionPane.showInputDialog(null,"Enter email to delete: ");

        Customer c = CustomerTextFile.getCustomer(email);

        System.out.println();
        if (c != null) {
            CustomerTextFile.deleteCustomer(c);
            JOptionPane.showMessageDialog(null, c.getName()
                    + " has been deleted.\n");
        } else {
            JOptionPane.showMessageDialog(null, "No customer matches that email.\n");
        }
    }
    
    public static void quit() {
    	JOptionPane.showMessageDialog(null,"Bye.\n");
        System.exit(0);
    }
}