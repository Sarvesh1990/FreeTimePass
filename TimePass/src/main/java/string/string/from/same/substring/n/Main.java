package string.string.from.same.substring.n;

/**
 * Created by sarvesh on 14/3/17.
 */
public class Main {
    public static void main(String[] args) {
        String str = "aab";
        System.out.println(checkIfStringFormedFromSameSubstring(str));
    }

    private static boolean checkIfStringFormedFromSameSubstring(String str) {
        int currentSubStrLength = 1;
        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == str.charAt(0)) {
                int j = i + 1;
                while(j <= str.length()) {
                    if(j == str.length()) {
                        if((j % currentSubStrLength) == 0) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        if(str.charAt(j) == str.charAt(j % currentSubStrLength)) {
                            j++;
                        } else {
                            i = j - 1;
                            currentSubStrLength = j;
                            break;
                        }
                    }

                }
            } else {
                currentSubStrLength = i + 1;
            }
        }
        return false;
    }
}
