/**
 * File: SocialAgent.java
 * Author: Junnan Shimizu
 * Date: 10/23/2021
 */

import java.awt.*;

public class CatSocialAgent extends SocialAgent {
    protected int category;

    // calls the parent constructor and set the category.
    public CatSocialAgent(double x0, double y0, int cat, int radius) {
        super(x0, y0, radius);
        this.category = cat;
    }

    // returns the category value.
    public int getCategory() {
        return this.category;
    }

    // returns a single character string indicating the category.
    public String toString() {
        return "" + this.category;
    }

    /*
    draws a circle of radius 5 (i.e. it fits in a 10x10 box) at the Agent's location.
    Different categories should have different colors,
    and each category will need a darker color (didn't move) and a lighter color (moved).
     */
    public void draw(Graphics g) {
        g.drawOval((int) this.x, (int) this.y, 10, 10);
        if (this.getCategory() == 0) {
            if (moved) {
                g.setColor(Color.darkGray);

            } else {
                g.setColor(Color.lightGray);
            }
        } else {
            if (moved) {
                g.setColor(Color.BLUE);

            } else {
                Color lightBlue = new Color(51, 153, 255);
                g.setColor(lightBlue);
            }
        }
        g.fillOval((int) this.x, (int) this.y, 10, 10);

    }

    /*
    implements the following rule:
    If there are >= 2 other agents with radius R and more of them are the same category
         with a 1% chance
             move randomly within the range [-10, 10] in x and y.
    else
        move randomly within the range [-10, 10] in x and y.
     */
    public void updateState(Landscape scape) {
        moved = false;
        int same = 0;
        System.out.println("reset");
        for (Agent current : scape.getNeighbors(this.getX(), this.getY(), this.getRadius())) {
//            System.out.println(((CatSocialAgent)(current)).getCategory());
            if (((CatSocialAgent)(current)).getCategory() == this.getCategory()) {
                same++;
//                System.out.println(same);
            }
        }
        System.out.println(same);

        if ((scape.getNeighbors(this.getX(), this.getY(), this.getRadius()).size() >= 2) &&
                (same < (scape.getNeighbors(this.getX(), this.getY(), this.getRadius()).size() - same))) {
//            System.out.println("hello");
            if (Math.random() * 100 == 1) {
                if (Math.random() < .5) {
                    this.setX(this.getX() + Math.random() * 10);
                } else {
                    this.setX(this.getX() - Math.random() * 10);
                }
                if (Math.random() < .5) {
                    this.setY(this.getY() + Math.random() * 10);
                } else {
                    this.setY(this.getY() - Math.random() * 10);
                }
                this.moved = true;
            }
        } else {
//                System.out.println("Test");
                if (Math.random() < .5) {
                    this.setX(this.getX() + Math.random() * 10);
                } else {
                    this.setX(this.getX() - Math.random() * 10);
                }
                if (Math.random() < .5) {
                    this.setY(this.getY() + Math.random() * 10);
                } else {
                    this.setY(this.getY() - Math.random() * 10);
                }
                this.moved = true;
        }
    }
}
