package graph.find.cycle.union.find;

import graph.adjacency.Graph;

/**
 * Created by sarvesh on 12/3/17.
 */
public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(3);
        graph.addVertex(0, 1);
        graph.addVertex(1, 2);
        graph.addVertex(2, 1);

        System.out.println(findIfCycle(graph, 3));
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
        parent[parentFrom] = to;
    }

    private static boolean checkIfCycle(int from, int to, int[] parent) {
        int parentFrom = findUltimateParent(from, parent);
        int parentTo = findUltimateParent(to, parent);

        return parentFrom == parentTo && parentFrom != -1;
    }

    private static int findUltimateParent(int vertex, int[] parent) {
        while(parent[vertex] != -1) {
            vertex = parent[vertex];
        }
        return vertex;
    }


}
