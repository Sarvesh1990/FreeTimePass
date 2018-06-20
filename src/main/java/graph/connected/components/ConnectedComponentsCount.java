package graph.connected.components;

/**
 * Created by sarvesh on 19/4/17.
 */

/*
Run DFS from every vertex if not visited.
 */

public class ConnectedComponentsCount {
    public static void main(String[] args) {
        int count = 5;
        int[][] edges = new int[count][count];
        edges[0][1] = 1;
        edges[1][2] = 1;
        edges[3][4] = 1;

        System.out.println(countComponents(count, edges));
    }

    private static Integer countComponents(int count, int[][] edges) {
        boolean[] visited = new boolean[count];
        int compCount = 0;
        for(int i = 0; i < count; i++) {
            if(!visited[i]) {
                compCount++;
                visited[i] = true;
                dfs(edges, visited, i, count);
            }
        }
        return compCount;
    }

    private static void dfs(int[][] edges, boolean[] visited, int i, int count) {
        for(int j = 0; j < count; j++) {
            if(edges[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(edges, visited, j, count);
            }
        }
    }
}
