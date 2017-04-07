package graph.mst.prim;

import graph.mst.Edge;
import graph.mst.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 13/03/17.
 */
public class Actual {
    public static void main(String[] args) {
        Graph graph = new Graph(4, 5);
        graph.insertEdge(0, 1, 10);
        graph.insertEdge(0, 2, 3);
        graph.insertEdge(0, 3, 2);
        graph.insertEdge(1, 3, 6);
        graph.insertEdge(2, 3, 4);

        findPrimMST(graph);
    }

    private static void findPrimMST(Graph graph) {
        int[] verticesWeight = new int[graph.vertices];
        boolean[] mst = new boolean[graph.vertices];
        int[] parent = new int[graph.vertices];

        for(int i = 0; i < verticesWeight.length; i++) {
            verticesWeight[i] = Integer.MAX_VALUE;
            mst[i] = false;
            parent[i] = -1;
        }

        verticesWeight[0] = 0;
        int i = 0;

        while (i < graph.vertices) {
            int minVertex = findMinMst(mst, verticesWeight);
            mst[minVertex] = true;
            updateVertices(minVertex, graph, mst, parent, verticesWeight);
            i++;
        }

        for (int j = 1; j < graph.vertices; j++) {
            System.out.println(parent[j] + "->" + j + " : " + verticesWeight[j]);
        }
    }

    private static int findMinMst(boolean[] mst, int[] verticesWeight) {
        int minWeight = Integer.MAX_VALUE;
        Integer minVertex = null;
        for(int i = 0; i < mst.length; i++) {
            if(mst[i] == false && verticesWeight[i] < minWeight) {
                minVertex = i;
                minWeight = verticesWeight[i];
            }
        }
        return minVertex;
    }

    private static void updateVertices(int currentVertex, Graph graph, boolean[] mst, int[] parent, int[] verticesWeight) {
        for(int i = 0; i < graph.edgesList.size(); i++) {
            Edge edge = graph.edgesList.get(i);
            if(edge.src == currentVertex || edge.dest == currentVertex) {
                if(edge.src == currentVertex) {
                    if(mst[edge.dest] == false && verticesWeight[edge.dest] > edge.weight) {
                        verticesWeight[edge.dest] = edge.weight;
                        parent[edge.dest] = currentVertex;
                    }
                } else {
                    if(mst[edge.src] == false && verticesWeight[edge.src] > edge.weight) {
                        verticesWeight[edge.src] = edge.weight;
                        parent[edge.src] = currentVertex;
                    }
                }
            }
        }
    }
}
