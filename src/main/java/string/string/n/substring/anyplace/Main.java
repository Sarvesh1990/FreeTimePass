package string.string.n.substring.anyplace;

/**
 * Created by apple on 15/03/17.
 */
public class Main {
    public static void main(String[] args) {
        String mainStr = "abac";
        String subStr= "ab";
        System.out.println(checkIfStringFormed(mainStr, subStr));
    }

    private static boolean checkIfStringFormed(String mainStr, String subStr) {
        if(mainStr.length() % subStr.length() != 0 ) {
            return false;
        }

        for(int i = 0; i < mainStr.length(); i++) {
            if(mainStr.charAt(i) != subStr.charAt(i % subStr.length())) {
                int j;
                for(j = i; j < i + subStr.length(); j++) {
                    if(mainStr.charAt(j) != subStr.charAt(j - i)) {
                        return false;
                    }
                }
                i = j - 1;
            }
        }
        return true;
    }
}
