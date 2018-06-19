package arrays.two.stocks;

/**
 * Created by apple on 20/03/17.
 */

/*
Find max profit earned by buying and selling two stocks.
First calculate maxProfit earned if we sell the stock on or before that day. Build MaxProfitArray. For that keep count of currentMin and check
diff with currentI. If less than maxProfit -> MakemaxProfit. Fill array.
Now start from end and get how much profit can be earned if we sell stock from end. Add profit till that point and calculate maxProfit total.
 */
public class MaxProfitSellTwoStocks {
    public static void main(String[] args) {
        int[] stockPrices = new int[] {12, 14, 17, 10, 14, 13, 12, 15};
        System.out.println(maximumStockPrices(stockPrices));
    }

    private static Integer maximumStockPrices(int[] stockPrices) {
        int[] maxProfit = new int[stockPrices.length];
        //Create max Profit array. At ith position you will get max profit of buy sell till ith

        int minimum = Integer.MAX_VALUE;
        int maxProfitTillNow = 0;

        for(int i = 0; i < stockPrices.length; i++) {
            if(maxProfitTillNow < stockPrices[i] - minimum) {
                maxProfitTillNow = stockPrices[i] - minimum;
            }
            maxProfit[i] = maxProfitTillNow;

            if(stockPrices[i] < minimum) {
                minimum = stockPrices[i];
            }
        }

        int maximum = 0;
        int maxProfitOverall = 0;
        int currentProfit = 0;

        for(int i = stockPrices.length - 1; i >=0; i--) {
            if(currentProfit < maximum - stockPrices[i]) {
                currentProfit = maximum - stockPrices[i];
            }

            if(maximum < stockPrices[i]) {
                maximum = stockPrices[i];
            }


            int maxProfitNow = 0;
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
