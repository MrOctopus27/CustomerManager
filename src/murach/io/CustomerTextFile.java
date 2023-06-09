/*
 * Author: Kevin Alvarado
 * Date: 12/8/2022
 * 
 * Description: This program asks you to enter a command to interact with the app
 */

package murach.io;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import murach.business.Customer;

public class CustomerTextFile {
    private static final String FIELD_SEP = "\t";
    private static final Path customersPath = Paths.get("customers.txt");
    private static final File customersFile = customersPath.toFile();
    private static List<Customer> customers = getCustomers();

    private CustomerTextFile() {}

    public static List<Customer> getCustomers() {
        if (customers != null) {
            return customers;
        }
        customers = new ArrayList<>();
        if (Files.exists(customersPath)) { 
            try (BufferedReader in = new BufferedReader(
                                     new FileReader(customersFile))) {
                String line;
                while ((line = in.readLine()) != null) {
                    String[] columns = line.split(FIELD_SEP);
                    String firstName = columns[0];
                    String lastName = columns[1];
                    String email = columns[2];
                    Customer p = new Customer(
                            firstName, lastName, email);
                    customers.add(p);
                }
            } catch (IOException e) {
                System.out.println(e);
                return null;
            }
        }
        return customers;
    }
    public static Customer getCustomer(String email) {
        for (Customer c : customers) {
            if (c.getEmail().equals(email)) {
                return c;
            }
        }
        return null;
    }

    public static boolean addCustomer(Customer c) {
        customers.add(c);
        return saveCustomers();
    }

    public static boolean deleteCustomer(Customer c) {
        customers.remove(c);
        return saveCustomers();
    }

    public static boolean updateCustomer(Customer newCustomer) {
        Customer oldCustomer = getCustomer(newCustomer.getEmail());
        int i = customers.indexOf(oldCustomer);
        customers.remove(i);
        customers.add(i, newCustomer);
        return saveCustomers();
    }

    private static boolean saveCustomers() {
        try (PrintWriter out = new PrintWriter(
            new BufferedWriter(
            new FileWriter(customersFile)))) {
            for (Customer c : customers) {
                out.print(c.getFirstName() + FIELD_SEP);
                out.print(c.getLastName() + FIELD_SEP);
                out.println(c.getEmail());
            }
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }

        return true;
    }
}