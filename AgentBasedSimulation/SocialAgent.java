/**
 * File: SocialAgent.java
 * Author: Junnan Shimizu
 * Date: 10/23/2021
 */

import java.awt.*;

public class SocialAgent extends Agent {
    protected boolean moved;
    protected int radius;

    public SocialAgent(double x0, double y0, int radius) {
        super(x0, y0);
        this.radius = radius;
    }

    // sets the cell's radius of sensitivity to the value of radius.
    public void setRadius(int radius){
        this.radius = radius;
    }

    // returns the cell's radius of sensitivity.
    public int getRadius() {
        return this.radius;
    }

    /*
    draws a circle of radius 5 (i.e. it fits in a 10x10 box) at the Agent's location.
    Pick two colors for the agent, a darker and a lighter version of the same hue (e.g. dark blue and light blue).
    If the agent moved during the last updateState, it should be drawn with the lighter color, otherwise the darker color.
     */
    public void draw(Graphics g) {
        g.drawOval((int)this.x, (int)this.y, 10, 10);
        if(moved){
            g.setColor(Color.lightGray);
        }else{
            g.setColor(Color.darkGray);
        }
        g.fillOval((int)this.x, (int)this.y, 10, 10);
    }

    public void updateState(Landscape scape){
        this.moved = false;

        if(scape.getNeighbors(this.getX(), this.getY(), this.getRadius()).size() > 3){
            if(Math.random() * 100 == 1){
                if(Math.random() < .5){
                    this.setX(this.getX() + Math.random() * 10);
                }else{
                    this.setX(this.getX() - Math.random() * 10);
                }
                if(Math.random() < .5){
                    this.setY(this.getY() + Math.random() * 10);
                }else{
                    this.setY(this.getY() - Math.random() * 10);
                }
                this.moved = true;
            }
        }else{
            if(Math.random() < .5){
                this.setX(this.getX() + Math.random() * 10);
            }else{
                this.setX(this.getX() - Math.random() * 10);
            }
            if(Math.random() < .5){
                this.setY(this.getY() + Math.random() * 10);
            }else{
                this.setY(this.getY() - Math.random() * 10);
            }
            this.moved = true;
        }
    }

    public static void main(String[] args){ //testing fields, constructors, methods
//        SocialAgent test = new SocialAgent(10, 10, 5);
//        System.out.println("The radius is: " + test.getRadius());
//        test.setRadius(7);
//        System.out.println("The radius is now: " + test.getRadius());

        Landscape field = new Landscape(100, 100);
        SocialAgent agent1 = new SocialAgent(5, 5, 10);
        SocialAgent agent2 = new SocialAgent(10, 10, 10);
        SocialAgent agent3 = new SocialAgent(15, 15, 10);
        SocialAgent agent4 = new SocialAgent(20, 20, 10);

        field.addAgent(agent1);
        field.addAgent(agent2);
        field.addAgent(agent3);
        field.addAgent(agent4);

        agent1.updateState(field);
        System.out.println("Number of neighbors: " + field.getNeighbors(agent1.getX(), agent1.getY(), 10).size());
        agent1.setX(5);
        agent1.setY(5);
        agent1.updateState(field);
        System.out.println("Number of neighbors: " + field.getNeighbors(agent1.getX(), agent1.getY(), 15).size());
        agent1.setX(5);
        agent1.setY(5);
        agent1.updateState(field);
        System.out.println("Number of neighbors: " + field.getNeighbors(agent1.getX(), agent1.getY(), 25).size());
    }
}
