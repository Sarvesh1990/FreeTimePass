package interview.goldman.hacker;

import java.util.*;

/**
 * Created by apple on 07/06/18.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(get_ranks(new String[]{"caa"})[0]);
    }

    static int[] get_ranks(String[] words) {

        int[] rank = new int[words.length];

        for(int i = 0; i < words.length; i++) {
            rank[i] = findRank(words[i]) - 1;
        }

        return rank;
    }

    static int findRank(String str) {
        int len = str.length();
        int mul = fact(len);
        int rank = 1;
        int countRight;

        for (int i = 0; i < len; ++i)
        {
            mul /= len - i;

            // count number of chars smaller
            // than str[i] from str[i+1] to
            // str[len-1]
            countRight = findSmallerInRight(str, i, len-1);

            rank += countRight * mul ;
        }

        int repeatedCharFact = findRepeatedCharFact(str);
        System.out.println(repeatedCharFact);

        return rank/repeatedCharFact;
    }

    static Integer findRepeatedCharFact(String str) {
        Map<Character, Integer> charCount = new HashMap<>();

        for(int i = 0; i < str.length(); i++) {
            charCount.put(str.charAt(i), charCount.containsKey(str.charAt(i)) ? charCount.get(str.charAt(i)) + 1 : 1);
        }

        int repeatedCharFact = 1;
        for(Character character : charCount.keySet()) {
            if(charCount.get(character) > 1) {
                repeatedCharFact = repeatedCharFact * fact(charCount.get(character));
            }
        }

        return  repeatedCharFact;
    }

    // A utility function to find factorial of n
    static int fact(int n)
    {
        return (n <= 1)? 1 :n * fact(n-1);
    }

    static int findSmallerInRight(String str, int low,
                                  int high) {
        int countRight = 0, i;

        for (i = low + 1; i <= high; ++i)
            if (str.charAt(i) <= str.charAt(low))
                ++countRight;

        return countRight;
    }


    /*public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();

        for(int i = 0; i < numTestCases; i++) {
            int count = scan.nextInt();
            int[] preOrder = new int[count];
            for(int j = 0; j < count; j++) {
                preOrder[j] = scan.nextInt();
            }

            System.out.println(representBST(preOrder));
        }

    }



    static String representBST(int pre[]) {
        int n = pre.length;
        // Create an empty stack
        Stack<Integer> s = new Stack<Integer>();

        // Initialize current root as minimum possible
        // val
        int root = Integer.MIN_VALUE;

        // Traverse given array
        for (int i = 0; i < n; i++) {
            // If we find a node who is on right side
            // and smaller than root, return false
            if (pre[i] < root) {
                return "NO";
            }

            // If pre[i] is in right subtree of stack top,
            // Keep removing items smaller than pre[i]
            // and make the last removed item as new
            // root.
            while (!s.empty() && s.peek() < pre[i]) {
                root = s.peek();
                s.pop();
            }

            // At this point either stack is empty or
            // pre[i] is smaller than root, push pre[i]
            s.push(pre[i]);
        }
        return "YES";
    }*/

}
