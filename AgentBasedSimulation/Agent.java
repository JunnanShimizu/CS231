/**
 * File: SocialAgent.java
 * Author: Junnan Shimizu
 * Date: 10/23/2021
 */

import java.awt.*;

public class Agent {
    protected double x;
    protected double y;

    // a constructor that sets the position.
    public Agent(double x0, double y0) {
        this.x = x0;
        this.y = y0;
    }

    // returns the x position.
    public double getX(){
        return this.x;
    }

    // returns the y position.
    public double getY() {
        return this.y;
    }

    // sets the x position.
    public void setX( double newX ){
        if(newX < 0){
            this.x = 0;
        }else{
            this.x = newX;
        }
    }

    // sets the y position.
    public void setY( double newY ){
        if(newY < 0){
            this.y = 0;
        }else{
            this.y = newY;
        }
    }

    // returns a String containing the x and y positions, e.g. "(3.024, 4.245)".
    public String toString() {
        String result = "";
        result = "(" + this.x + ", " + this.y + ")";
        return result;
    }

    // does nothing, for now.
    public void updateState( Landscape scape ) {
    }

    // does nothing, for now.
    public void draw(Graphics g){
    }

    public static void main(String[] args){ // testing fields, constructors, methods
        Agent test = new Agent(10, 10);
        System.out.println("The X value is " + test.getX());
        System.out.println("The Y value is " + test.getY());

        test.setX(20);
        test.setY(25);
        System.out.println("The X value is " + test.getX());
        System.out.println("The Y value is " + test.getY());
        System.out.println(test.toString());
    }
}
