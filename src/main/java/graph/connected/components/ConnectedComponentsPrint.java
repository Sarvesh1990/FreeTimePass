package graph.connected.components;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by apple on 01/03/17.
 */
public class ConnectedComponentsPrint {
    public static void main(String[] args) {
        String str = "acxrabdz";
        int numVertices = str.length();

        int[][] graph = new int[numVertices][numVertices];
        for(int i = 0; i < numVertices; i++) {
            for(int j = 0; j < numVertices; j++) {
                graph[i][j] = 0;
            }
        }

        graph[0][2] = 1;
        graph[5][7] = 1;
        graph[7][5] = 1;
        graph[2][7] = 1;
        graph[2][0] = 1;
        graph[7][2] = 1;
        graph[1][6] = 1;
        graph[6][1] = 1;

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        ArrayList<LinkedList<Integer>> connectedList = new ArrayList<LinkedList<Integer>>();
        for(int i = 0; i < numVertices; i++) {
            if(!visited[i]) {
                connectedList.add(new LinkedList<Integer>());
                dfs(graph, visited, i, numVertices, connectedList.get(connectedList.size() - 1));
            }
        }

        for(int i = 0; i < connectedList.size(); i++) {
            String connectedComps = "";
            for(int j = 0; j < connectedList.get(i).size(); j++) {
                connectedComps = connectedComps + " " + str.charAt(connectedList.get(i).get(j));
            }
            System.out.println(connectedComps);
        }
    }

    public static void dfs(int[][] graph, boolean[] dfsVisited, int startNode, int numVertices, LinkedList<Integer> connectedList) {
        dfsVisited[startNode] = true;
        connectedList.add(startNode);
        int i = startNode;
        for(int j = 0; j < numVertices; j++) {
            if (!(graph[i][j] == 0) && !dfsVisited[j]) {
                dfs(graph, dfsVisited, j, numVertices, connectedList);
            }
        }
    }
}
