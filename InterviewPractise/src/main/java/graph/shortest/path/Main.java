package graph.shortest.path;

import java.util.LinkedList;

/**
 * Created by sarvesh on 16/3/17.
 */
public class Main {
    public static void main(String[] args) {
        int numVertices = 6;
        int[][] graph = new int[6][6];
        for(int i = 0; i < numVertices; i++) {
            for(int j = 0; j < numVertices; j++) {
                graph[i][j] = 0;
            }
        }
        graph[0][1] = 1;
        graph[0][2] = 1;
        graph[5][2] = 1;
        graph[5][3] = 1;
        graph[3][2] = 1;
        graph[3][5] = 1;
        graph[4][0] = 1;
        graph[2][1] = 1;

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        System.out.println(shortestPath(graph, visited, 0, 2, 6));
    }

    public static Integer shortestPath(int[][] graph, boolean[] bfsVisited, int startNode, int endNode, int numVertices) {
        LinkedList<Integer> bfsQueue = new LinkedList<>();
        int[] distance = new int[numVertices];
        int count = 0;
        boolean found = false;

        bfsVisited[startNode] = true;
        bfsQueue.add(startNode);
        distance[startNode] = count;

        while(!bfsQueue.isEmpty() && !found) {
            int number = bfsQueue.removeFirst();
            for(int j = 0; j < numVertices; j++) {
                if (!(graph[number][j] == 0) && !bfsVisited[j]) {
                    distance[j] = distance[number] + 1;
                    if(j == endNode) {
                        found = true;
                        break;
                    }
                    bfsVisited[j] = true;
                    bfsQueue.add(j);
                }
            }
        }

        if(found) {
            return distance[endNode];
        } else {
            return -1;
        }
    }
}
