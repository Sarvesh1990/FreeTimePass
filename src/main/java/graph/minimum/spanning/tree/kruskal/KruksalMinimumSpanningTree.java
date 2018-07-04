package graph.minimum.spanning.tree.kruskal;

import graph.minimum.spanning.tree.Edge;
import graph.minimum.spanning.tree.Graph;

import java.util.Collections;

/**
 * Created by apple on 13/03/17.
 */

/*
1. Sort all the edges in non-decreasing order of their weight.
2. Pick the smallest edge. Check if it forms a cycle with the spanning tree formed so far. If cycle is not formed, include this edge.
Else, discard it.
Use Union Find to find cycle
3. Repeat step#2 until there are (V-1) edges in the spanning tree.

*/

public class KruksalMinimumSpanningTree {
    public static void main(String[] args) {
        Graph graph = new Graph(4, 5);
        graph.insertEdge(0, 1, 10);
        graph.insertEdge(0, 2, 3);
        graph.insertEdge(0, 3, 2);
        graph.insertEdge(1, 3, 15);
        graph.insertEdge(2, 3, 4);

        findMST(graph);
    }

    private static void findMST(Graph graph) {
        Collections.sort(graph.edgesList);

        int[] parent = new int[graph.vertices];
        for(int i = 0; i < graph.vertices; i++) {
            parent[i] = -1;
        }

        int count = 0;
        for(int i = 0; i < graph.edges; i++) {
            if(!isCycle(graph.edgesList.get(i), parent)) {
                System.out.println(graph.edgesList.get(i).src + "->" + graph.edgesList.get(i).dest);
                count++;
            }
            if(count == graph.vertices - 1) {
                break;
            }
        }
    }

    private static boolean isCycle(Edge edge, int[] parent) {
        int parentFrom = find(edge.src, parent);
        int parentTo = find(edge.dest, parent);

        if(parentFrom == parentTo) {
            return true;
        }

        union(edge.src, edge.dest, parent);
        return false;
    }

    private static void union(int src, int dest, int[] parent) {
        int parentFrom = find(src, parent);
        int parentTo = find(dest, parent);

        parent[parentFrom] = parentTo;

    }

    private static int find(int index, int[] parent) {
        while(parent[index] != -1) {
            index = parent[index];
        }
        return index;
    }


}
