package string.non.pair;

/**
 * Created by apple on 26/02/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(findNonRepeatingCharacter("aabbcdd"));
    }

    public static Character findNonRepeatingCharacter(String str) {
        return findNonRepeatingCharacterHelper(str, 0, str.length() - 1);
    }

    public static Character findNonRepeatingCharacterHelper(String str, int start, int end) {
        if(end < 0 || start > end) {
            if(end < 0) {
                return str.charAt(start);
            } else {
                return str.charAt(end);
            }
        }

        if(start == end) {
            return str.charAt(start);
        }

        int mid = start + (end - start)/2;
        if(str.charAt(mid - 1) == str.charAt(mid) || str.charAt(mid + 1) == str.charAt(mid)) {
            //Do something
            if(str.length() / 2 % 2 == 0) {
                if (str.charAt(mid - 1) == str.charAt(mid)) {
                    return findNonRepeatingCharacterHelper(str, start, mid - 2);
                } else {
                    return findNonRepeatingCharacterHelper(str, mid + 2, end);
                }
            } else {
                if (str.charAt(mid + 1) == str.charAt(mid)) {
                    return findNonRepeatingCharacterHelper(str, start, mid - 1);
                } else {
                    return findNonRepeatingCharacterHelper(str, mid + 1, end);
                }
            }
        } else {
            return str.charAt(mid);
        }
    }

}
