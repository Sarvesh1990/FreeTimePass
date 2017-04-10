package arrays.k.stocks;

import java.util.Arrays;
import java.util.jar.Pack200;

/**
 * Created by apple on 20/03/17.
 */
public class Main {
    public static void main(String[] args) {
        int[] stockPrices = new int[] {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.print(maxProfit(0, stockPrices));
    }

    public static long maxProfit(int k, int [] stockPrices) {
        if(stockPrices.length > 0) {

            long[] maxProfitArray = new long[stockPrices.length];
            for (int i = 0; i < k; i++) {
                maxProfitArray = getMaxProfit(stockPrices, maxProfitArray);
            }
            return maxProfitArray[stockPrices.length - 1];
        } else {
            return 0;
        }
    }

    public static long[] getMaxProfit(int[] stockPrices, long[] maxProfit) {
        long[] maxProfitTemp = new long[maxProfit.length];
        for(int i = 0; i < stockPrices.length; i++) {
            maxProfitTemp[i] = getMaxProfitTillI(stockPrices, maxProfit, i);
        }
        return maxProfitTemp;
    }

    public static long getMaxProfitTillI(int [] stockPrices, long[] maxProfit, int pos) {
        long maximum = 0;
        long maxProfitOverall = 0;
        long currentProfit = 0;

        for(int i = pos; i >= 0; i--) {
            if(currentProfit < maximum - stockPrices[i]) {
                currentProfit = maximum - stockPrices[i];
            }

            if(maximum < stockPrices[i]) {
                maximum = stockPrices[i];
            }


            long maxProfitNow = 0;
            if(i != 0 && currentProfit > 0) {
                maxProfitNow = currentProfit + maxProfit[i - 1];
            } else if (currentProfit <= 0){
                maxProfitNow = maxProfit[i];
            } else {
                maxProfitNow = currentProfit;
            }

            if(maxProfitOverall < maxProfitNow) {
                maxProfitOverall = maxProfitNow;
            }

        }
        return  maxProfitOverall;
    }


}
