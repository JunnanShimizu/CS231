/*
Junnan Shimizu
12/10/21
CS231 Data Structures and Algorithms
 */

import java.util.ArrayList;

//tests graph with 10 vertices
public class MyGraphTester {
    public static void main(String[] args){
        Vertex v00 = new Vertex(0, 0, false);
        Vertex v10 = new Vertex(1, 0, false);
        Vertex v02 = new Vertex(0, 2, false);
        Vertex v35 = new Vertex(3, 5, false);
        Vertex v24 = new Vertex(2, 4, false);
        Vertex v53 = new Vertex(5, 3, false);
        Vertex v69 = new Vertex(6, 9, false);
        Vertex v40 = new Vertex(4, 0, false);
        Vertex v87 = new Vertex(8, 7, false);
        Vertex v90 = new Vertex(9, 0, false);

        Graph graph = new Graph();

        graph.addBiEdge(v00, v24);
        graph.addBiEdge(v24, v02);
        graph.addBiEdge(v24, v35);
        graph.addBiEdge(v40, v53);
        graph.addBiEdge(v02, v10);
        graph.addBiEdge(v10, v53);
        graph.addBiEdge(v10, v40);
        graph.addBiEdge(v35, v69);
        graph.addBiEdge(v35, v87);
        graph.addBiEdge(v53, v87);
        graph.addBiEdge(v87, v90);
        graph.addBiEdge(v69, v90);

        // print out before shortestPath
        ArrayList<Vertex> set = graph.getVertices();

        System.out.println("Before shortestPath");
        for( Vertex v: set ) {
            System.out.println( v );
        }

        // run shortest path from node (0, 0)
        graph.shortestPath( v00 );


        // print out after shortest path
        System.out.println("\nAfter shortestPath");
        for( Vertex v: set ) {
            System.out.println( v );
        }
    }
}
