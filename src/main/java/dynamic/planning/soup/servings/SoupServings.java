package dynamic.planning.soup.servings;

public class SoupServings {
    public static void main(String[] args) {
        SoupServings ss = new SoupServings();
        System.out.println(ss.soupServings(100));
    }
    public double soupServings(int N) {
        int n = (int) Math.ceil(N/25.0);
        double[][] prob = new double[n + 1][n + 1];
        prob[0][0] = 0.5;
        for(int i = 1; i <= n; i++) {
            prob[i][0] = 0;
            prob[0][i] = 1;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i - 100/25 > 0) {
                    prob[i][j] += prob[i - 100/25][j]*0.25;
                } else {
                    prob[i][j] += 0.25 * prob[0][j];
                }

                if(i - 75/25 > 0) {
                    if(j - 25/25 > 0) {
                        prob[i][j] += prob[i - 75/25][j - 25/25]*0.25;
                    } else {
                        prob[i][j] += prob[i - 75/25][0]*0.25;
                    }
                } else {
                    if(j - 25/25 > 0) {
                        prob[i][j] += prob[0][j - 25/25]*0.25;
                    } else {
                        prob[i][j] += prob[0][0]*0.25;
                    }
                }

                if(i - 50/25 > 0) {
                    if(j - 50/25 > 0) {
                        prob[i][j] += prob[i - 50/25][j - 50/25]*0.25;
                    } else {
                        prob[i][j] += prob[i - 50/25][0]*0.25;
                    }
                } else {
                    if(j - 50/25 > 0) {
                        prob[i][j] += prob[0][j - 50/25]*0.25;
                    } else {
                        prob[i][j] += prob[0][0]*0.25;
                    }
                }

                if(i - 25/25 > 0) {
                    if(j - 75/25 > 0) {
                        prob[i][j] += prob[i - 25/25][j - 75/25]*0.25;
                    } else {
                        prob[i][j] += prob[i - 25/25][0]*0.25;
                    }
                } else {
                    if(j - 75/25 > 0) {
                        prob[i][j] += prob[0][j - 75/25]*0.25;
                    } else {
                        prob[i][j] += prob[0][0]*0.25;
                    }
                }
            }
        }
        return prob[n][n];
    }
}
