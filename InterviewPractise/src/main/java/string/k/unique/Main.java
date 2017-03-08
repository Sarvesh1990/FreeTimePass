package string.k.unique;

/**
 * Created by apple on 27/02/17.
 */
public class Main {
    public static void main(String[] args) {
        findKUnique("aababbcbcccccddddc", 2);
    }

    private static void findKUnique (String str, int k) {
        if(k == 0) {
            return;
        }
        int maxStartIndex = 0;
        int maxEndIndex = 0;
        int maxCount = 0;
        int currCount = 0;
        int currStartIndex = 0;
        int[] arrayChar = new int[26];
        int currUniqueChar = 0;

        for(int i = 0; i < str.length(); i++) {
            if(arrayChar[str.charAt(i) - 'a'] > 0) {
                if(currUniqueChar < k) {
                    currCount++;
                    maxCount++;
                    maxEndIndex = i;
                    arrayChar[str.charAt(i) - 'a']++;
                } else {
                    currCount++;
                    arrayChar[str.charAt(i) - 'a']++;
                    if(currCount > maxCount) {
                        maxCount = currCount;
                        maxStartIndex = currStartIndex;
                        maxEndIndex = i;
                    }
                }
            } else {
                if(currUniqueChar < k) {
                    currUniqueChar++;
                    currCount++;
                    maxCount++;
                    maxEndIndex = i;
                    arrayChar[str.charAt(i) - 'a']++;
                } else {
                    currCount++;
                    arrayChar[str.charAt(i) - 'a']++;
                    Character charToBeRemoved = str.charAt(currStartIndex);
                    for(int j = currStartIndex; j < i; j++) {
                        currCount--;
                        currStartIndex++;
                        arrayChar[str.charAt(j) - 'a']--;
                        if(arrayChar[charToBeRemoved - 'a'] == 0) {
                            break;
                        }
                    }
                    if(currCount > maxCount) {
                        maxCount = currCount;
                        maxStartIndex = currStartIndex;
                        maxEndIndex = i;
                    }
                }
            }
        }
        System.out.println(maxCount);
    }
}
