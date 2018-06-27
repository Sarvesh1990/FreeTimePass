package graph.find.cycle.union.find;

import graph.adjacency.Graph;

/**
 * Created by sarvesh on 12/3/17.
 */

/*
For every edge, check if ultimate parent of both vertex of edge is same.
If yes, return true; Else -> Set parent of of one vertex to parent of other vertex.
Choose a convention for parent setting to->from
 */
public class CheckIfGraphHasCycle {
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addVertex(0, 1);
        graph.addVertex(1, 2);
        graph.addVertex(0, 3);

        System.out.println(findIfCycle(graph, 4));
    }

    private static boolean findIfCycle(Graph graph, int vertices) {
        int[] parent = new int[vertices];

        for(int i = 0; i < vertices; i++) {
            parent[i] = -1;
        }

        for(int i = 0; i < graph.graph.length; i++) {
            for(int j = 0; j < graph.graph[i].size(); j++)
            if(checkIfCycle(i, graph.graph[i].get(j), parent)) {
                return true;
            } else {
                union(i, graph.graph[i].get(j), parent);
            }
        }
        return false;
    }

    private static void union(int from, int to, int[] parent) {
        int parentFrom = findUltimateParent(from, parent);
        int parentTo = findUltimateParent(to, parent);
        parent[parentFrom] = parentTo;
    }

    private static boolean checkIfCycle(int from, int to, int[] parent) {
        int parentFrom = findUltimateParent(from, parent);
        int parentTo = findUltimateParent(to, parent);

        return parentFrom == parentTo;
    }

    private static int findUltimateParent(int vertex, int[] parent) {
        while(parent[vertex] != -1) {
            vertex = parent[vertex];
        }
        return vertex;
    }


}
