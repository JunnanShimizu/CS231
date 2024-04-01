/**
 * File: SocialAgent.java
 * Author: Junnan Shimizu
 * Date: 10/23/2021
 */

import java.awt.*;
import java.util.ArrayList;

public class Landscape {
    private int width;
    private int height;
    private LinkedList<Agent> agents;

    // a constructor that sets the width and height fields, and initializes the agent list.
    public Landscape(int w, int h) {
        this.width = w;
        this.height = h;
        this.agents = new LinkedList<Agent>();
    }

    // returns the height.
    public int getHeight() {
        return height;
    }

    // returns the width.
    public int getWidth() {
        return width;
    }

    // inserts an agent at the beginning of its list of agents.
    public void addAgent( Agent a ) {
        agents.addFirst(a);
    }

    /*
     returns a String representing the Landscape.
     It can be as simple as indicating the number of Agents on the Landscape.
     */
    public String toString(){
        String result = "";
        result = "Number of Agents: " + agents.size();
        return result;
    }

    // returns a list of the Agents within radius distance of the location x0, y0.
    public ArrayList<Agent> getNeighbors(double x0, double y0, double radius) {
        ArrayList<Agent> neighbors = new ArrayList<Agent>();
        for(Agent current : agents.toArrayList()){
            if(current.getX() > x0 - radius && current.getX() < x0 + radius &&
                    current.getY() > y0 - radius && current.getY() < y0 + radius &&
                    x0 != current.getX() && y0 != current.getY()){
                neighbors.add(current);
            }
        }
        return neighbors;
    }

    // Calls the draw method of all the agents on the Landscape.
    public void draw(Graphics g) {
        for(Agent current : agents.toArrayList()){
            current.draw(g);
        }
    }

    public void updateAgents(){
        ArrayList<Agent> temp = this.agents.toShuffledList();
        for(Agent current : temp){
            current.updateState(this);
        }
    }

    public static void main(String[] args){ //testing fields, constructors, methods
        Landscape test = new Landscape(100, 100);
        Agent agent1 = new Agent(15, 15);
        Agent agent2 = new Agent(9, 9);
        Agent agent3 = new Agent(8, 8);
        System.out.println("The Width is: " + test.getWidth());
        System.out.println("The Height is: " + test.getHeight());
        test.addAgent(agent1);
        test.addAgent(agent2);
        test.addAgent(agent3);

        for(Agent current : test.getNeighbors(7, 7, 5)){
            System.out.println(current.toString());
        }
    }
}
