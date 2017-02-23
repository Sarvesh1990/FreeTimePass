package dynamic.planning.longest.common.subsequence;

import static java.lang.StrictMath.max;

/**
 * Created by apple on 22/02/17.
 */
public class Main {
    public static void main(String[] args) {
        String firstStr = "AGGTABCA";
        String secondStr= "GTXXAYBA";

        int[][] subsequenceArrays = new int[firstStr.length() + 1][secondStr.length() + 1];

        for (int i = 0; i < firstStr.length(); i++) {
            subsequenceArrays[i][0] = 0;
        }
        for (int j = 0; j < secondStr.length(); j++) {
            subsequenceArrays[0][j] = 0;
        }

        char[] finalStr = new char[max(firstStr.length(), secondStr.length())];

        for(int i = 1; i <= firstStr.length(); i++) {
            for(int j = 1; j <= secondStr.length(); j++) {
                if(firstStr.charAt(i - 1) == secondStr.charAt(j - 1)) {
                    subsequenceArrays[i][j] = subsequenceArrays[i - 1][j - 1] + 1;
                    System.out.println(firstStr.charAt(i - 1) + " " + secondStr.charAt(j - 1) + " " + i + " " + j) ;
                } else {
                    subsequenceArrays[i][j] = max(subsequenceArrays[i][j-1], subsequenceArrays[i-1][j]);
                }
            }
        }
        System.out.println(subsequenceArrays[4][2]);
        System.out.println(subsequenceArrays[firstStr.length()][secondStr.length()]);
    }
}
