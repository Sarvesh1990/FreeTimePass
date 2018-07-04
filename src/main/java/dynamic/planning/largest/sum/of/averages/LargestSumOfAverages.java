package dynamic.planning.largest.sum.of.averages;


/*
 */
public class LargestSumOfAverages {
    public static void main(String[] args) {
        LargestSumOfAverages ls = new LargestSumOfAverages();
        System.out.println(ls.largestSumOfAverages(new int[] {9,1,2,3,9}, 3));
    }

    public double largestSumOfAverages(int[] A, int K) {
        double[][] largestSum = new double[A.length + 1][K + 1];

        for(int i = 1; i <= A.length; i++) {
            largestSum[i][0] = Integer.MIN_VALUE;
        }

        for(int i = 1; i <= K; i++) {
            largestSum[0][i] = Integer.MIN_VALUE;
        }

        largestSum[0][0] = 0;

        for(int i = 1; i <= K; i++) {
            for(int j = A.length; j > 0; j--) {
                double sum = A[j - 1];
                double maxSum = 0;
                for(int m = j; m > 0; m--) {
                    double average = sum / (j - m + 1);
                    if((average + largestSum[m - 1][i - 1]) > maxSum) {
                        largestSum[j][i] = average + largestSum[m - 1][i - 1];
                        maxSum = average + largestSum[m - 1][i - 1];
                    }
                    if(m > 1) {
                        sum = sum + A[m - 2];
                    }
                }
                System.out.println(largestSum[j][i]);
            }
        }

        return largestSum[A.length][K];
    }
}
