/**
 * File: DecisiomMakingSimulation.java
 * Author: Junnan Shimizu
 * Date: 10/30/2021
 */

import java.util.Random;
import java.util.ArrayList;

public class RandomCustomerSimulation {
    // Test function that creates a new LandscapeDisplay and populates it with 5 checkouts and 99 customers.
    public static void main(String[] args) throws InterruptedException {
        Random gen = new Random();
        ArrayList<CheckoutAgent> checkouts = new ArrayList<CheckoutAgent>(5);

        for(int i=0;i<5;i++) {
            CheckoutAgent checkout = new CheckoutAgent( i*100+50, 480 );
            checkouts.add( checkout );
        }
        Landscape scape = new Landscape(500,500, checkouts);
        LandscapeDisplay display = new LandscapeDisplay(scape);

        for (int j = 0; j < 101; j++) {
            Customer cust = new RandomCustomer(1+gen.nextInt(10));
            int choice = cust.chooseLine( checkouts );
            checkouts.get(choice).addCustomerToQueue( cust );
            scape.updateCheckouts();
            display.repaint();
            if(j % 100 == 0){
                scape.printFinishedCustomerStatistics(j);
            }
            Thread.sleep( 100 );
        }
    }
}