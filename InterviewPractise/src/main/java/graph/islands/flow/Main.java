package graph.islands.flow;

/**
 * Created by apple on 28/02/17.
 */
public class Main {
    public static void main(String[] args) {
        int m = 4;
        int n = 4;
        int[][] islandHeight = new int[m][n];

        islandHeight[0][0] = 2;
        islandHeight[0][1] = 5;
        islandHeight[0][2] = 7;
        islandHeight[0][3] = 3;
        islandHeight[1][0] = 5;
        islandHeight[1][1] = 4;
        islandHeight[1][2] = 3;
        islandHeight[1][3] = 1;
        islandHeight[2][0] = 1;
        islandHeight[2][1] = 5;
        islandHeight[2][2] = 2;
        islandHeight[2][3] = 5;
        islandHeight[3][0] = 4;
        islandHeight[3][1] = 6;
        islandHeight[3][2] = 3;
        islandHeight[3][3] = 2;

        int[][] pacific = new int[m][n];
        int[][] atlantic = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                pacific[i][j] = -1;
                atlantic[i][j] = -1;
            }
        }

        for(int j = 0; j < n; j++) {
            pacific[0][j] = 1;
            atlantic[m - 1][j] = 1;
        }

        for(int i = 0; i < m; i++) {
            pacific[i][m - 1] = 1;
            atlantic[i][0] = 1;
        }


        for(int j = 0; j < n; j++) {
            findPacific(islandHeight, pacific, 0, j, m, n);
        }

        for(int i = 0; i < m; i++) {
            findPacific(islandHeight, pacific, i, m - 1, m, n);
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.println(pacific[i][j] + " " + i + " " + j);
            }
        }
    }

    private static void findPacific(int[][] islandHeight, int[][] pacific, int i, int j, int m, int n) {
        pacific[i][j] = 1;
        if(i - 1 > 0) {
            if(pacific[i - 1][j] == -1 && islandHeight[i - 1][j] > islandHeight[i][j]) {
                findPacific(islandHeight, pacific, i - 1, j, m, n);
            }
        }
        if(i + 1 < m) {
            if(pacific[i + 1][j] == -1 && islandHeight[i + 1][j] > islandHeight[i][j]) {
                findPacific(islandHeight, pacific, i + 1, j, m, n);
            }
        }
        if(j - 1 > 0) {
            if(pacific[i][j - 1] == -1 && islandHeight[i][j - 1] > islandHeight[i][j]) {
                findPacific(islandHeight, pacific, i, j - 1, m, n);
            }
        }
        if(j + 1 < n) {
            if(pacific[i][j + 1] == -1 && islandHeight[i][j + 1] > islandHeight[i][j]) {
                findPacific(islandHeight, pacific, i, j + 1, m, n);
            }
        }
    }
}
