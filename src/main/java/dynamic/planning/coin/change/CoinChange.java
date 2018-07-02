package dynamic.planning.coin.change;

/**
 * Created by apple on 19/03/17.
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = new int[] {1, 2, 3};
        int n = 4;
        System.out.println("123".substring(0));

        System.out.println(combinationSum4(coins, n));
    }

    private static Integer combinationSum4(int[] nums, int target) {
        int[][] totalComb = new int[target + 1][nums.length + 1];
        for(int i = 0; i <= target; i++) {
            for(int j = 0; j <= nums.length; j++) {
                if(i == 0 )  {
                    totalComb[i][j] = 1;
                } else if (j == 0 && i != 0) {
                    totalComb[i][j] = 0;
                } else {
                    if(nums[j - 1] <= i) {
                        totalComb[i][j] = totalComb[i][j] +  totalComb[i - nums[j - 1]][nums.length];
                    }
                    totalComb[i][j] = totalComb[i][j] + (totalComb[i][j - 1] > 0 ? totalComb[i][j - 1] : 0);

                }
            }
        }
        return  totalComb[target][nums.length];
    }
}
