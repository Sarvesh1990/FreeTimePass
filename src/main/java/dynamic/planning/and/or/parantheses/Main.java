package dynamic.planning.and.or.parantheses;

/**
 * Created by apple on 18/04/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(findCount(new boolean[] {true, true, false, true}, new String[] {"or", "and", "xor"}));
    }

    private static int findCount(boolean[] values, String[] operator) {
        if(values.length == 0) {
            return 0;
        }
        int[][] dp = new int[values.length][2];
        for(int i = values.length - 1; i >= 0; i--) {
            if(i == values.length - 1) {
                if(values[i]) {
                    dp[i][1] = 1;
                } else  {
                    dp[i][0] = 1;
                }
            } else if (i == values.length - 2) {
                boolean value = values[i];
                if(value) {
                    if(operator[i].equals("and")) {
                        dp[i][0] = dp[i + 1][0];
                        dp[i][1] = dp[i + 1][1];
                        value = values[i + 1] ? true : false;
                    } else if (operator[i].equals("or")) {
                        dp[i][1] = dp[i + 1][1] + dp[i + 1][0];
                        value = true;
                    } else {
                        dp[i][0] = dp[i + 1][1];
                        dp[i][1] = dp[i + 1][0];
                        value = values[i + 1] ? false : true;
                    }
                } else {
                    if(operator[i].equals("and")) {
                        dp[i][0] = dp[i + 1][1] + dp[i + 1][0];
                        value = false;
                    } else if (operator[i].equals("or")) {
                        dp[i][0] = dp[i + 1][0];
                        dp[i][1] = dp[i + 1][1];
                        value = values[i + 1] ? true : false;
                    } else {
                        dp[i][0] = dp[i + 1][0];
                        dp[i][1] = dp[i + 1][1];
                        value = values[i + 1] ? true : false;
                    }
                }
                if(value) {
                    dp[i][1] = dp[i][1] + 1;
                } else {
                    dp[i][0] = dp[i][0] + 1;
                }
            } else {
                boolean value = values[i];
                if(value) {
                    if(operator[i].equals("and")) {
                        dp[i][0] = dp[i + 1][0];
                        dp[i][1] = dp[i + 1][1];
                        value = values[i + 1] ? true : false;
                    } else if (operator[i].equals("or")) {
                        dp[i][1] = dp[i + 1][1] + dp[i + 1][0];
                        value = true;
                    } else {
                        dp[i][0] = dp[i + 1][1];
                        dp[i][1] = dp[i + 1][0];
                        value = values[i + 1] ? false : true;
                    }
                } else {
                    if(operator[i].equals("and")) {
                        dp[i][0] = dp[i + 1][1] + dp[i + 1][0];
                        value = false;
                    } else if (operator[i].equals("or")) {
                        dp[i][0] = dp[i + 1][0];
                        dp[i][1] = dp[i + 1][1];
                        value = values[i + 1] ? true : false;
                    } else {
                        dp[i][0] = dp[i + 1][0];
                        dp[i][1] = dp[i + 1][1];
                        value = values[i + 1] ? true : false;
                    }
                }
                if(value) {
                    if(operator[i + 1].equals("and")) {
                        dp[i][0] = dp[i][0] + dp[i + 2][0];
                        dp[i][1] = dp[i][1] + dp[i + 2][1];
                    } else if (operator[i + 1].equals("or")) {
                        dp[i][1] = dp[i][1] + dp[i + 2][1] + dp[i + 2][0];
                    } else {
                        dp[i][0] = dp[i][0] + dp[i + 2][1];
                        dp[i][1] = dp[i][1] + dp[i + 2][0];
                    }
                } else {
                    if(operator[i + 1].equals("and")) {
                        dp[i][0] = dp[i][0] + dp[i + 2][1] + dp[i + 2][0];
                    } else if (operator[i + 1].equals("or")) {
                        dp[i][0] = dp[i][0] + dp[i + 2][0];
                        dp[i][1] = dp[i][1] + dp[i + 2][1];
                    } else {
                        dp[i][1] = dp[i][1] + dp[i + 2][1];
                        dp[i][0] = dp[i][0] + dp[i + 2][0];
                    }
                }
            }
        }
        return dp[0][1];
    }
}
