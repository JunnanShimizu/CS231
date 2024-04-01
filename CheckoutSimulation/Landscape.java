/**
 * File: DecisiomMakingSimulation.java
 * Author: Junnan Shimizu
 * Date: 10/30/2021
 */

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Landscape {
    int width;
    int height;
    ArrayList<CheckoutAgent> checkoutAgents;
    LinkedList<Customer> finished;

    // Constructor. The list of finished customers should be initialized to an empty list.
    public Landscape(int w, int h, ArrayList<CheckoutAgent> checkouts ) {
        this.width = w;
        this.height = h;
        this.checkoutAgents = checkouts;
        finished = new LinkedList<Customer>();
    }

    // Return the height of the Landscape.
    public int getHeight(){
        return this.height;
    }

    // Return the width of the Landscape.
    public int getWidth() {
        return this.width;
    }

    // Return a string indicating how many checkouts and finished customers are in the landscape.
    public String toString() {
        String result = "";
        result += "Number of Checkouts: " + this.checkoutAgents.size() + "\n";
        result += "Number of Finished Customers: " + this.finished.size();

        return result;
    }

    // Add the Customer to the list of finished customers.
    public void addFinishedCustomer(Customer c ){
        this.finished.add(c);
    }

    // Loop through the CheckoutAgents, calling the draw method on each.
    public void draw( Graphics g ){
        for(CheckoutAgent current : this.checkoutAgents){
            current.draw(g);
        }
    }

    // Updates the state of all CheckoutAgents
    public void updateCheckouts(){
        for(CheckoutAgent current : checkoutAgents){
            current.updateState(this);
        }
    }

    // Prints finished customer statistics
    public void printFinishedCustomerStatistics(int trialNumber){
        double average = 0;
        double standardDeviation = 0;

        System.out.println("Number of Customers:" + trialNumber);

        for(Customer current : finished){
            average += current.getTime();
        }

        average = average/finished.size();
        System.out.println("Average Time: " + average);

        for(Customer current : finished){
            standardDeviation += Math.abs(average - current.getTime());
        }

        standardDeviation = standardDeviation/finished.size();
        System.out.println("Standard Deviation of Time: " + standardDeviation);
    }
}
