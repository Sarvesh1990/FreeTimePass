package graph.mst;

import java.util.ArrayList;

/**
 * Created by apple on 13/03/17.
 */
public class Graph {
    public int edges;
    public int vertices;
    public ArrayList<Edge> edgesList;

    public Graph(int vertices, int edges) {
        this.edges = edges;
        this.vertices = vertices;
        edgesList = new ArrayList<>();
    }

    public void insertEdge(int src, int dest, int weight) {
        if(edgesList.size() < edges) {
            edgesList.add(new Edge(src, dest, weight));
        } else {
            System.out.println("Edge list is not empty");
        }
    }
}
