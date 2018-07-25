package linkedlist.palindrome.recursion;

import java.util.LinkedList;
import java.util.List;

public class CheckIfLinkedListPalindromeByRecursion {
    private int leftIndex = 0;

    public static void main(String[] args) {
        CheckIfLinkedListPalindromeByRecursion cc = new CheckIfLinkedListPalindromeByRecursion();
        System.out.println(cc.ifPalindrome(new LinkedList<Integer>() {
            {
                add(1);
                add(2);
                add(1);
                add(1);


            }
        }));
    }

    private boolean ifPalindrome(List<Integer> list) {
        if(list == null || list.size() == 0) {
            return false;
        }

        return ifPalindromeHelper(list, 0);
    }

    private boolean ifPalindromeHelper(List<Integer> list, int rightIndex) {
        if(rightIndex < list.size() - 1) {
            boolean ifPalin = ifPalindromeHelper(list, rightIndex + 1);
            if(!ifPalin) {
                return false;
            }
        }

        if(list.get(leftIndex) == list.get(rightIndex)) {
            leftIndex++;
            return true;
        } else {
            return false;
        }
    }
}
