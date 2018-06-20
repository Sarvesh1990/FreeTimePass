package graph.minimum.height.vertex;

import java.util.LinkedList;
import java.util.List;

/*
Do BFS from each node and find height
 */

public class MinimumHeightVertex {
    public static void main(String[] args) {
        MinimumHeightVertex minimumHeightVertex = new MinimumHeightVertex();
        int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        System.out.println(minimumHeightVertex.findMinHeightTrees(6, edges));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] height = new int[n];
        for(int i = 0; i < n; i++) {
            height[i] = findHeight(i, edges, n);
        }

        int minHeight = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(height[i] < minHeight) {
                minHeight = height[i];
            }
        }

        List<Integer> minHeightList = new LinkedList<>();
        for(int i = 0; i < n; i++ ) {
            if(height[i] == minHeight){
                minHeightList.add(i);
            }
        }

        return minHeightList;
    }

    public int findHeight(int vertex, int[][] edges, int vertexCount) {
        boolean[] visited = new boolean[vertexCount];
        int[] distance = new int[vertexCount];

        for(int i = 0; i < vertexCount; i++) {
            visited[i] = false;
        }

        LinkedList<Integer> bfsQueue = new LinkedList<>();
        visited[vertex] = true;
        bfsQueue.add(vertex);

        int height = 0;
        int connectedCount = 0;


        while(!bfsQueue.isEmpty())  {
            connectedCount++;
            int number = bfsQueue.removeFirst();
            for(int i = 0; i < vertexCount; i++) {
                for(int j = 0; j < edges.length; j++) {
                    if(((edges[j][0] == number && edges[j][1] == i) || (edges[j][0] == i && edges[j][1] == number)) && !visited[i]) {
                        distance[i] = distance[number] + 1;
                        bfsQueue.add(i);
                        visited[i] = true;

                    }
                }
            }

        }

        System.out.println(vertex + " " + connectedCount);
        for(int i = 0; i < vertexCount; i++) {
            if(distance[i] > height) {
                height = distance[i];
            }
        }

        return connectedCount == vertexCount ? height : Integer.MAX_VALUE;
    }
}
