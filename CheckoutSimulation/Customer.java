/**
 * File: DecisiomMakingSimulation.java
 * Author: Junnan Shimizu
 * Date: 10/30/2021
 */

import java.util.ArrayList;

public abstract class Customer {
    int numItems;
    int timeSteps;

    // Constructor method. (By default, the number of time steps is zero.)
    public Customer(int num_items) {
        this.numItems = num_items;
        this.timeSteps = 0;
    }

    // Constructor method.
    public Customer(int num_items, int time_steps) {
        this.numItems = num_items;
        this.timeSteps = time_steps;
    }

    // Increments the number of time steps.
    public void incrementTime() {
        this.timeSteps++;
    }

    // Returns the number of time steps
    public int getTime(){
        return this.timeSteps;
    }

    // Decrements the number of items (indicating another item has been paid for).
    public void giveUpItem() {
        this.numItems--;
    }

    // Returns the number of items.
    public int getNumItems(){
        return this.numItems;
    }

    // Since this is an abstract method, there is no body.
    public abstract int chooseLine(ArrayList<CheckoutAgent> checkouts);

    // For testing purposes.
    public static void main(String[] args){
        Customer test = new PickyCustomer(1, 1);
        ArrayList<CheckoutAgent> agents = new ArrayList<CheckoutAgent>();
        System.out.println(test.getTime());
        System.out.println(test.getNumItems());

        test.incrementTime();
        test.giveUpItem();

        System.out.println(test.getTime());
        System.out.println(test.getNumItems());
    }
}
