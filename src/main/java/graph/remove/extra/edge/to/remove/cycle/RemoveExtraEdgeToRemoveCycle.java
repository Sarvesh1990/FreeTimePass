package graph.remove.extra.edge.to.remove.cycle;

import graph.adjacency.Graph;

import java.util.*;

/*
Given a graph which has one extra edge making it cyclic, find that extra edge which when removed makes the graph non-cyclic.
Classic example of union find.
Since we can remove any edge of cycle to make it non-cyclic, remove last edge from array.
Start by picking each edge one by one. As soon as the cyclic formed return the edge. Cycle is formed when ultimate parent of both to and from of edge is same.
Keep updating ultimate parent if cycle is not formed
 */

public class RemoveExtraEdgeToRemoveCycle {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{30,44},{34,47},{22,32},{35,44},{26,36},{2,15},{38,41},{28,35},{24,37},{14,49},{44,45},{11,50},
                {20,39},{7,39},{19,22},{3,17},{15,25},{1,39},{26,40},{5,14},{6,23},{5,6},{31,48},{13,22},{41,44},{10,19},{12,41},
                {1,12},{3,14},{40,50},{19,37},{16,26},{7,25},{22,33},{21,27},{9,50},{24,42},{43,46},{21,47},{29,40},{31,34},{9,31},
                {14,31},{5,48},{3,18},{4,19},{8,17},{38,46},{35,37},{17,43}};

//        int[][] edges = new int[][]{{1, 2}, {1, 3}, {2, 3}};
        RemoveExtraEdgeToRemoveCycle re = new RemoveExtraEdgeToRemoveCycle();

        int[] redundantEdge = re.findRedundantConnection(edges);
        System.out.println(redundantEdge[0] + " " + redundantEdge[1]);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }

        for(int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];

            if(findUltimateParent(from, parent) == findUltimateParent(to, parent)) {
                return new int[] {from, to};
            } else {
                union(from, to, parent);
            }
        }
        return new int[2];

    }

    private static void union(int from, int to, int[] parent) {
        int parentFrom = findUltimateParent(from, parent);
        int parentTo = findUltimateParent(to, parent);
        parent[parentFrom] = parentTo;
    }

    private static int findUltimateParent(int vertex, int[] parent) {
        while(parent[vertex] != -1) {
            vertex = parent[vertex];
        }
        return vertex;
    }
}
