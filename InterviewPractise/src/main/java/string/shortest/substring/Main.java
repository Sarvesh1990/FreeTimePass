package string.shortest.substring;

import static java.lang.Math.min;
import static sun.swing.MenuItemLayoutHelper.max;

/**
 * Created by apple on 25/02/17.
 */
public class Main {
    public static void main(String[] args) {
        shortestSubstring("abccac", "abc");
    }

    private static void shortestSubstring(String first, String second) {
        if(second.length() == 0) {
            System.out.println("");
            return;
        }

        StringBuilder shortestSubStr = new StringBuilder("");
        StringBuilder modifiedSecondStr = new StringBuilder(second);

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < first.length(); i++) {
            int index = modifiedSecondStr.indexOf(String.valueOf(first.charAt(i)));
            if(index >= 0) {
                shortestSubStr.append(first.charAt(i));
                modifiedSecondStr.deleteCharAt(index);

            } else {
                if(shortestSubStr.length() != 0) {
                    if(shortestSubStr.charAt(0) != first.charAt(i)) {
                        shortestSubStr.append(first.charAt(i));
                    } else {
                        shortestSubStr.deleteCharAt(0);
                        for(int j = 1; j < i; j++ ) {
                            if(second.indexOf(shortestSubStr.charAt(j)) < 0) {
                                shortestSubStr.deleteCharAt(j);
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(shortestSubStr.toString());

    }
}
