package graph.matrix;

import java.util.LinkedList;

/**
 * Created by apple on 27/02/17.
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
//        graph[0][5] = 1;
        graph[1][5] = 1;
        graph[2][3] = 1;
        graph[3][4] = 1;
        graph[3][5] = 1;
        graph[4][0] = 1;
        graph[2][1] = 1;
//        graph[5][4] = 1;

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        boolean[] recStack = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            recStack[i] = false;
        }


        dfs(graph, visited, 2, numVertices);
//        System.out.println(dfsLoop(graph, visited, 2, numVertices, recStack));
    }

    public static void dfs(int[][] graph, boolean[] dfsVisited, int startNode, int numVertices) {
        dfsVisited[startNode] = true;
        System.out.println(startNode);
        int i = startNode;
        for(int j = 0; j < numVertices; j++) {
            if (!(graph[i][j] == 0) && !dfsVisited[j]) {
                dfs(graph, dfsVisited, j, numVertices   );
            }
        }
    }

    public static void bfs(int[][] graph, boolean[] bfsVisited, int startNode, int numVertices) {
        LinkedList<Integer> bfsQueue = new LinkedList<>();
        bfsVisited[startNode] = true;
        bfsQueue.add(startNode);

        while(!bfsQueue.isEmpty()) {
            int number = bfsQueue.removeFirst();
            System.out.println(number);
            for(int j = 0; j < numVertices; j++) {
                if (!(graph[number][j] == 0) && !bfsVisited[j]) {
                    bfsVisited[j] = true;
                    bfsQueue.add(j);
                }
            }
        }
    }

    public static boolean dfsLoop(int[][] graph, boolean[] dfsVisited, int startNode, int numVertices, boolean[] recStack) {
        dfsVisited[startNode] = true;
        recStack[startNode] = true;
        System.out.println(startNode);

        int i = startNode;
        for(int j = 0; j < numVertices; j++) {
            if ((graph[i][j] != 0) && !dfsVisited[j] && dfsLoop(graph, dfsVisited, j, numVertices, recStack)) {
                return true;
            } else if (recStack[j] && graph[i][j] != 0) {
                return true;
            }
        }
        recStack[startNode] = false;
        return false;
    }
}
