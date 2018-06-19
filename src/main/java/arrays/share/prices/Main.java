package arrays.share.prices;

/**
 * Created by apple on 20/02/17.
 */
public class Main {
    public static void main(String[] args) {
        int[] stockPrices = {100, 180, 260, 310, 40, 535, 695, 120, 30, 10, 40, 20, 10, 15};
        int currentMinimum = 0;
        int maxDifference = 0;

        for(int i = 1; i < stockPrices.length; i++) {
            if(stockPrices[i] < stockPrices[i - 1]) {
                if(maxDifference > 0) {
                    System.out.println(currentMinimum + ", " + String.valueOf(i - 1));
                }
                currentMinimum = i;
                maxDifference = 0;
            } else {
                if(stockPrices[i] - stockPrices[currentMinimum] > maxDifference) {
                    maxDifference = stockPrices[i] - stockPrices[currentMinimum];
                }
                if(i == stockPrices.length - 1) {
                    System.out.println(currentMinimum + " " + i);
                }
            }
        }
    }
}
