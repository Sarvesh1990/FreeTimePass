package graph.remove.extra.edge.to.remove.cycle;

import java.util.*;

public class RemoveExtraEdgeToRemoveCycle {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{30,44},{34,47},{22,32},{35,44},{26,36},{2,15},{38,41},{28,35},{24,37},{14,49},{44,45},{11,50},
                {20,39},{7,39},{19,22},{3,17},{15,25},{1,39},{26,40},{5,14},{6,23},{5,6},{31,48},{13,22},{41,44},{10,19},{12,41},
                {1,12},{3,14},{40,50},{19,37},{16,26},{7,25},{22,33},{21,27},{9,50},{24,42},{43,46},{21,47},{29,40},{31,34},{9,31},
                {14,31},{5,48},{3,18},{4,19},{8,17},{38,46},{35,37},{17,43}};
        RemoveExtraEdgeToRemoveCycle re = new RemoveExtraEdgeToRemoveCycle();
        re.findRedundantConnection(edges);
    }

    public int[] findRedundantConnection(int[][] edges) {
        for(int i = edges.length - 1; i >= 0; i--) {
            int tempStart = edges[i][0];
            int tempEnd = edges[i][1];
            edges[i][0] = -1;
            edges[i][1] = -1;

            boolean[] visited = new boolean[edges.length + 1];

            if(!findLoopNode(edges, edges[0][0], visited, -1, 0, edges.length)) {
                System.out.println(tempStart + " " + tempEnd);
                return new int[]{tempStart, tempEnd};
            } else {
                edges[i][0] = tempStart;
                edges[i][1] = tempEnd;
            }
        }
        return new int[2];

    }

    public boolean findLoopNode(int[][] edges, int index, boolean[] visited, int parent, int count, int vertex) {
        System.out.println("Index " + index);
        visited[index] = true;
        count++;
        for(int i = 0; i < edges.length; i++) {
            if(edges[i][0] == index || edges[i][1] == index) {
                int newIndex = edges[i][0] == index ? edges[i][1] : edges[i][0];
                if(!visited[newIndex]) {
                    if(findLoopNode(edges, newIndex, visited, index, count, vertex)) {
                        System.out.println(newIndex + " " + index);
                        return true;
                    }
                } else if (newIndex != parent){
                    System.out.println(newIndex + " " + index);
                    return true;
                }
            }
        }

        if(count == vertex)
            return false;
        else
            return true;
    }
}
