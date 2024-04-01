/**
 * File: DecisiomMakingSimulation.java
 * Author: Junnan Shimizu
 * Date: 10/30/2021
 */

import java.util.ArrayList;

public class PickyCustomer extends Customer{

    /*
    Constructor. This should call the super class's constructor with the given
    number of items and num_lines as the initial value for the time steps.
    The PickyCustomer examines the lengths of all the lines before choosing one,
    so its initial time needs to reflect that.
     */
    public PickyCustomer( int num_items, int num_lines ) {
        super(num_items, num_lines);
    }

    // Returns the index of the CheckoutAgent with the shortest line.
    public int chooseLine(ArrayList<CheckoutAgent> checkouts) {
        int min = Integer.MAX_VALUE;
        int shortestLine = -1;
        for(int i = 0; i < checkouts.size(); i++){
            if(checkouts.get(i).getNumInQueue() < min){
                min = checkouts.get(i).getNumInQueue();
                shortestLine = i;
            }
        }
        return shortestLine;
    }
}
