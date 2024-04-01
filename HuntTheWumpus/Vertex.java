/*
Junnan Shimizu
12/10/21
CS231 Data Structures and Algorithms
 */

import java.util.ArrayList;
import java.util.Comparator;

public class Vertex implements Comparable<Vertex> {
    private ArrayList<Vertex> neighbors;
    private int x, y;
    private boolean visible;
    private double cost;
    private boolean visited;
    private Vertex parent;

    public Vertex(){
        x = 0;
        y = 0;
        visible = false;
        cost = Integer.MAX_VALUE;
        visited = false;
        parent = null;
        neighbors = new ArrayList<>();
    }

    public Vertex(int x, int y, boolean visited){
        this.x = x;
        this.y = y;
        visible = false;
        cost = Integer.MAX_VALUE;
        this.visited = visited;
        parent = null;
        neighbors = new ArrayList<>();
    }

    //getters and setters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean getVisible(){
        return this.visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double distance) {
        this.cost = distance;
    }

    public boolean getVisited(){
        return this.visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    //returns the Euclidean distance between this vertex and the other vertex based on their x and y positions.
    public double distance( Vertex other ){
        return Math.sqrt(Math.pow(this.getX() - other.getX(), 2) + Math.pow(this.getY() - other.getY(), 2));
    }

    //updates this vertex' adjacency list/map so that it connects with the other Vertex. This is a uni-directional link.
    public void connect(Vertex other){
        if(!(this.neighbors.contains(other))){
            this.neighbors.add(other);
        }
    }

    //returns the Vertex at position (x, y) if the Vertex is in the adjacency list, otherwise null.
    public Vertex getNeighbor(int x, int y){
        for(Vertex v : this.neighbors){
            if(v.getX() == x && v.getY() == y){
                return v;
            }
        }
        return null;
    }

    //returns an ArrayList of type Vertex which contains all of this Vertex' neighbors.
    public ArrayList<Vertex> getNeighbors(){
        return this.neighbors;
    }

    public void setNeighbors(ArrayList<Vertex> neighbors) {
        this.neighbors = neighbors;
    }

    //returns the number of connected vertices.
    public int numNeighbors(){
        return neighbors.size();
    }

    public int compareTo(Vertex other){
        if(this.getCost() - other.getCost() < 0){
            return -1;
        }else if(this.getCost() - other.getCost() > 0){
            return 1;
        }else{
            return 0;
        }
    }

    //returns true if the x and y positions of the two vertices match.
    public static boolean matchPosition( Vertex a, Vertex b ){
        if(a.compareTo(b) == 0){
            return true;
        }else{
            return false;
        }
    }

    //returns a String containing (at least) the number of neighbors, this Vertex' cost, and the marked flag.
    public String toString(){
        return getX() + ",  " + getY() + "\n" + "Number of Neighbors: " + numNeighbors() + "\n" + "Vertex Cost: " + getCost() + "\n" + "Visited?: " + getVisited() + "\n";
    }

    public static void main(String[] args){
        Vertex one = new Vertex(0, 5, false);
        Vertex two = new Vertex(5, 10, false);
        Vertex three = new Vertex(1, 2, false);
        Vertex four = new Vertex(7, 8, false);
        Vertex five = new Vertex(4, 5, false);
        Vertex six = new Vertex(4, 5, false);
        System.out.println(one.distance(two));

        one.connect(two);
        two.connect(three);
        three.connect(four);
        three.connect(five);

//        System.out.println(three.toString());
//        for(Vertex v : three.getNeighbors()){
//            System.out.println(v.toString());
//        }

        System.out.println(three.getNeighbor(7,8).toString());
        System.out.println(matchPosition(five,six));
    }
}
