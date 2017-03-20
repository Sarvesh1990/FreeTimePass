package dynamic.planning.coin.change;

/**
 * Created by apple on 19/03/17.
 */
public class DP {
    public static void main(String[] args) {
        int[] coins = new int[] {2, 5, 3, 6};
        int n = 10;

        System.out.println(totalCombination(coins, n));
    }

    private static Integer totalCombination(int[] coins, int n) {
        int[][] totalComb = new int[n + 1][coins.length + 1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= coins.length; j++) {
                if(i == 0 )  {
                    totalComb[i][j] = 1;
                } else if (j == 0 && i != 0) {
                    totalComb[i][j] = 0;
                } else {
                    if(coins[j - 1] <= i) {
                        totalComb[i][j] = totalComb[i][j] +  totalComb[i - coins[j - 1]][j];
                    }
                    totalComb[i][j] = totalComb[i][j] + (totalComb[i][j - 1] > 0 ? totalComb[i][j - 1] : 0);

                }
            }
        }
        return  totalComb[n][coins.length];
    }
}
