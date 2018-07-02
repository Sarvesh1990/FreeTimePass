package dynamic.planning.knapsack;

import static java.lang.Math.max;

/**
 * Created by apple on 19/03/17.
 */



public class KnapSack {
    public static void main(String[] args) {
        int n = 3;
        int[] weight = new int[] {10, 20, 30};
        int[] value = new int[] {70, 50, 120};

        System.out.println(knapsack(weight, value, n, 30));
    }

    private static Integer knapsack(int[] weight, int[] value, int n, int w) {
        int[][] knapSack = new int[n + 1][w + 1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= w; j++) {
                if(i == 0 || j == 0) {
                    knapSack[i][j] = 0;
                } else {
                    if(j >= weight[i - 1]) {
                        knapSack[i][j] = max((value[i - 1] + knapSack[i - 1][j - weight[i - 1]]), knapSack[i - 1][j]);
                    } else {
                        knapSack[i][j] = knapSack[i - 1][j];
                    }
                }
            }
        }
        return knapSack[n][w];
    }
}

