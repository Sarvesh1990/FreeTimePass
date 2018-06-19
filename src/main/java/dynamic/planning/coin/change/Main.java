package dynamic.planning.coin.change;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.Pack200;

/**
 * Created by apple on 22/02/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(printPossibleCombinations(new int[]{2, 4}, 8));
    }

    private static int printPossibleCombinations(int[] coins, int sum) {
        int[][] possibleCombinations = new int[coins.length][sum + 1];
        for(int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= sum; j++) {
                possibleCombinations[i][j] = -1;
            }
        }
        return printPossibleCombinationsHelper(possibleCombinations, coins, coins.length - 1, sum);
    }

    private static int printPossibleCombinationsHelper(int[][] possibleCombinations, int[] coins, int length, int sum) {
        if (length == 0) {
            if (sum >= coins[length]) {
                if (sum == coins[length]) {
                    possibleCombinations[length][sum] = 1;
                } else {
                    if(possibleCombinations[length][sum - coins[length]] >= 0) {
                        possibleCombinations[length][sum] = possibleCombinations[length][sum - coins[length]];
                    } else {
                        possibleCombinations[length][sum - coins[length]] = printPossibleCombinationsHelper(possibleCombinations, coins, length, sum - coins[length]);
                        possibleCombinations[length][sum] = possibleCombinations[length][sum - coins[length]];
                    }
                }
            } else {
                possibleCombinations[length][sum] = 0;
            }
        }  else {
            int sum1 = 0;
            if(sum >= coins[length]) {
                if(sum == coins[length]) {
                    possibleCombinations[length][sum - coins[length]] = 1;
                } else {
                    if (possibleCombinations[length][sum - coins[length]] < 0) {
                        possibleCombinations[length][sum - coins[length]]
                                = printPossibleCombinationsHelper(possibleCombinations, coins, length, sum - coins[length]);
                    }
                }
                sum1 = possibleCombinations[length][sum - coins[length]];
            }

            if(possibleCombinations[length - 1][sum] < 0) {
                possibleCombinations[length - 1][sum]
                        = printPossibleCombinationsHelper(possibleCombinations, coins, length - 1, sum);
            }
            possibleCombinations[length][sum] = sum1 + possibleCombinations[length - 1][sum];
        }
        return possibleCombinations[length][sum];
    }
}