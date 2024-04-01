/**
 * File: DecisiomMakingSimulation.java
 * Author: Junnan Shimizu
 * Date: 10/30/2021
 */

import java.awt.*;

public class CheckoutAgent {
    int x;
    int y;
    MyQueue<Customer> queue;

    // Constructor. The queue should be initialized to an empty MyQueue<Customer>.
    public CheckoutAgent(int x, int y) {
        this.x = x;
        this.y = y;
        queue = new MyQueue<Customer>();
    }

    // Add a Customer to its queue.
    public void addCustomerToQueue( Customer c ){
        this.queue.offer(c);
    }

    // Returns the number of Customers in its queue.
    public int getNumInQueue(){
        return this.queue.getSize();
    }

    /*
    draws the CheckoutAgent as a rectangle near the bottom of the window with
    a height proportional to the number of Customers in the queue. A height of 10*N
    (where N is the number of customers in the queue) and width of 10 should work.
    Assume that (this.x,this.y) is the bottom left corner of the rectangle.
     */
    public void draw(Graphics g) {
        g.drawRect(this.x, this.y - 10*this.getNumInQueue(), 10, 10*this.getNumInQueue());
    }

    /*
    updateState() should do the following:
    Loop through the Customers in its queue, calling incrementTime
    Examine the Customer at the front of the queue. If there is no Customer (it is null),
    then there is nothing more to do. Otherwise, call the giveUpItem method on the Customer
    in the front of the queue. If the Customer then has 0 items, remove it from the queue
    and have the Landscape add it to its list of finished Customers.
     */
    public void updateState(Landscape scape){
        for(Customer current : queue){
            current.incrementTime();
        }
        if(queue.peak() != null){
            queue.peak().giveUpItem();
            if(queue.peak().numItems == 0){
                Customer temp = queue.poll();
                scape.addFinishedCustomer(temp);
            }
        }
    }

    // For testing purposes.
    public static void main(String[] args){ //testing methods
        CheckoutAgent test = new CheckoutAgent(10, 10);
        Customer customer1 = new PickyCustomer(3, 2);
        test.addCustomerToQueue(customer1);
        System.out.println("" + test.getNumInQueue());
    }
}
