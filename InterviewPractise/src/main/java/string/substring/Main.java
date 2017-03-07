package string.substring;

/**
 * Created by apple on 25/02/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(findIfSubString("DYK", "ADCPYD"));
    }

    private static boolean findIfSubString(String first, String second) {
        boolean[][] ifSubString = new boolean[first.length() + 1][second.length() + 1];

        for(int i = 1; i <= first.length(); i++) {
            ifSubString[i][0] = false;
        }

        for(int j = 0; j <= second.length(); j++) {
            ifSubString[0][j] = true;
        }

        for(int i = 1; i <= first.length(); i++) {
            for(int j = 1; j <= second.length(); j++) {
                if(first.charAt(i - 1) == second.charAt(j - 1)) {
                    ifSubString[i][j] = ifSubString[i - 1][j - 1];
                } else {
                    ifSubString[i][j] = ifSubString[i][j - 1];
                }

            }
        }

        return ifSubString[first.length()][second.length()];
    }
}
