package dynamic.planning.gold.mine;

import java.util.*;

/**
 * Created by apple on 13/03/17.
 */
public class Main {
    public static void main(String[] args) {
        int n = 4;
        int m = 4;

        int[][] goldMine = {{10, 33, 13, 15}, {22, 21, 04, 1}, {5, 0, 2, 3}, {0, 6, 14, 2}};

        System.out.println(getMaxGold(goldMine, n, m));
    }

    private static int getMaxGold(int[][] goldMine, int n, int m) {
        int[][] maxGold = new int[n][m];
        for(int i = m - 1; i >= 0; i--) {
            for(int j = 0; j < n; j++) {
                if(i == m - 1) {
                    maxGold[j][i] = goldMine[j][i];
                } else {
                    if(j == 0) {
                        maxGold[j][i] = Math.max(maxGold[j][i + 1], maxGold[j+1][i+1]) + goldMine[j][i];
                    } else if (j == n - 1) {
                        maxGold[j][i] = Math.max(maxGold[j][i+1], maxGold[j-1][i+1]) + goldMine[j][i];
                    } else {
                        maxGold[j][i] = Math.max(Math.max(maxGold[j][i+1], maxGold[j+1][i+1]), maxGold[j-1][i+1]) + goldMine[j][i];
                    }
                }
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            if(maxGold[i][0] > max) {
                max = maxGold[i][0];
            }
        }
        return max;

    }
}
