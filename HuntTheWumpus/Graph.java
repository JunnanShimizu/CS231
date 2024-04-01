/*
Junnan Shimizu
12/10/21
CS231 Data Structures and Algorithms
 */

import java.util.*;

public class Graph {
    private ArrayList<Vertex> vertices;

    public Graph(){
        vertices = new ArrayList<>();
    }

    public ArrayList<Vertex> getVertices(){
        return vertices;
    }

    //returns the number of vertices in the graph.
    public int vertexCount(){
        return vertices.size();
    }

    //return true if the query Vertex is in the graph's vertex list.
    public boolean inGraph(Vertex query){
        if(vertices.contains(query)){
            return true;
        }else{
            return false;
        }
    }

    //adds v1 and v2 to the graph (if necessary) and adds an edge connecting v1 to v2, creating a uni-directional link.
    public void addUniEdge(Vertex v1, Vertex v2){
        if(!vertices.contains(v1)){
            vertices.add(v1);
        }
        if(!vertices.contains(v2)){
            vertices.add(v2);
        }
        v1.connect(v2);
    }

    //adds v1 and v2 to the graph (if necessary), adds an edge connecting v1 to v2,
    //and adds a second edge connecting v2 to v1, creating a bi-directional link.
    public void addBiEdge(Vertex v1, Vertex v2){
        if(!vertices.contains(v1)){
            vertices.add(v1);
        }
        if(!vertices.contains(v2)){
            vertices.add(v2);
        }

        v1.connect(v2);
        v2.connect(v1);
    }

    //implements a single-source shortest-path algorithm for the Graph, Dijkstra's algorithm.

    /*
    Given: a graph G and starting vertex v0 in G

  Initialize all vertices in G to be unmarked, have a large cost, and a null parent
  (A large cost can be 1e+7)

  Create a priority queue, pq, to hold objects of type Vertex

  Set the cost of v0 to 0 and add it to pq

  while q is not empty:

    remove v from pq where v is the vertex with lowest cost
    if v is already marked as visited, continue

    mark v as visited

    for each vertex w that neighbors v:
      compute the distance between v and w
      if w is not marked and v.cost + distance < w.cost:
        w.cost = v.cost + distance
        make v the parent of w
        add w to pq

Output: the cost of each vertex v in G is the shortest distance from v0 to v.
Each vertex also specifies its parent on the shortest path back to v0 from v.
     */
    public void shortestPath(Vertex v0){
        PriorityQueue<Vertex> pq = new PriorityQueue<>();

        for(int i = 0; i < vertexCount(); i++){
            vertices.get(i).setCost(Integer.MAX_VALUE);
            vertices.get(i).setVisited(false);
            vertices.get(i).setParent(null);
        }

        v0.setCost(0);
        pq.add(v0);

        while(!pq.isEmpty()){
            Vertex current = pq.poll();

            if(current.getVisited()){
                continue;
            }else{
                current.setVisited(true);
            }

            for(Vertex v : current.getNeighbors()){
                double distance = v.distance(current);
                if(!(v.getVisited()) && (distance + current.getCost()) < v.getCost()){
                    v.setCost(distance + current.getCost());
                    v.setParent(current);
                    pq.add(v);
                }
            }
        }
    }
}
