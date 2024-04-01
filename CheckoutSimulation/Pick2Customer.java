/**
 * File: DecisiomMakingSimulation.java
 * Author: Junnan Shimizu
 * Date: 10/30/2021
 */

import java.util.ArrayList;

public class Pick2Customer extends Customer{

    /* Constructor. This should call the super class's constructor with
    the given number of items and 2 as the initial value for the time steps.
    The Pick2Customer spends two time-step choosing a line because it randomly
    examines two lines before picking one.
     */
    public Pick2Customer( int num_items ){
        super(num_items, 2);
    }

    /* Returns the index of the shorter of two randomly chosen queues.
    (Note: write your code to ensure that there are two different lines chosen.)
     */
    public int chooseLine(ArrayList<CheckoutAgent> checkouts) {
        int index1 = (int)(Math.random() * checkouts.size());
        int index2 = (int)(Math.random() * checkouts.size());

        while(index1 == index2){
            index2 = (int)(Math.random() * checkouts.size());
        }

        if(checkouts.get(index1).getNumInQueue() > checkouts.get(index2).getNumInQueue()){
            return index2;
        }else if(checkouts.get(index1).getNumInQueue() < checkouts.get(index2).getNumInQueue()){
            return index1;
        }else{
            return index1;
        }
    }
}
