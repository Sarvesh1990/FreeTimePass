package graph.two.groups;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sarvesh on 17/3/17.
 */
public class Main {
    public static void main(String[] args) {
        int numVertices = 4;
        int[][] graph = new int[numVertices][numVertices];
        for(int i = 0; i < numVertices; i++) {
            for(int j = 0; j < numVertices; j++) {
                graph[i][j] = 0;
            }
        }
        graph[0][1] = 1;
        graph[1][2] = 1;
        graph[1][3] = 1;
        graph[0][3] = 1;

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }


        printTwoGroups(graph, visited, 0, numVertices);
    }

    public static void printTwoGroups(int[][] graph, boolean[] bfsVisited, int startNode, int numVertices) {
        LinkedList<Integer> bfsQueue = new LinkedList<>();
        bfsVisited[startNode] = true;
        bfsQueue.add(startNode);

        int[] group = new int[numVertices];

        for(int i = 0; i < numVertices; i++) {
            group[i] = 0;
        }

        boolean notBiPartite = false;

        while(!bfsQueue.isEmpty() && !notBiPartite) {
            int number = bfsQueue.removeFirst();
            for(int j = 0; j < numVertices; j++) {
                if (!(graph[number][j] == 0) && !bfsVisited[j]) {
                    if(group[number]  == 0) {
                        group[number] = 1;
                        group[j] = 2;
                    } else {
                        group[j] = group[number] == 1 ? 2 : 1;
                    }
                    bfsVisited[j] = true;
                    bfsQueue.add(j);
                } else if(!(graph[number][j] == 0)) {
                    if(group[j] == group[number]) {
                        notBiPartite = true;
                        break;
                    }
                }
            }
        }

        if(notBiPartite) {
            System.out.println("Not a bipartite graph");
        } else {
            String group1 = "";
            String group2 = "";
            for(int i = 0; i < numVertices; i++) {
                if(group[i] == 1) {
                    group1 = group1 + i;
                } else {
                    group2 = group2 + i;
                }
            }
            System.out.println(group1);
            System.out.println(group2);
        }
    }
}
