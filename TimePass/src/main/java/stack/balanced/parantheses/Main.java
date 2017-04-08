package stack.balanced.parantheses;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by sarvesh on 11/3/17.
 */
public class Main {
    public static void main(String[] args) {
        String paran = "}";
        int[] array = new int[] {283, 325, 301, 311, 314, 67, 273, 278, 253, 17, 91, 10, 15, 297, 158, 277, 282, 200, 76, 161, 157, 257, 285, 23, 211,
        56, 341, 121, 1, 139, 173, 75, 78, 125, 98, 206, 252, 43, 236, 218, 133, 49, 494, 79, 238, 215, 38, 209, 57, 71, 146, 208, 33, 377, 13, 90, 44, 380,
        128, 334, 88, 28, 102, 398, 50, 127, 20, 286, 69, 235, 117, 269, 68, 221, 274, 85, 210, 234, 25, 261, 26, 265, 477, 80, 404, 410, 168, 461, 275};
        Arrays.sort(array);
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(checkIfValidParanthesis(paran));
    }

    private static boolean checkIfValidParanthesis(String paran) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('}', '{');
        brackets.put(')', '(');
        brackets.put(']', '[');

        Stack<Character> bracketStack = new Stack();

        for(int i = 0; i < paran.length(); i++) {
            if(brackets.containsKey(paran.charAt(i))) {
                if(bracketStack.isEmpty()) {
                    return false;
                } else {
                    if(!brackets.get(paran.charAt(i)).equals(bracketStack.peek())) {
                        return false;
                    } else {
                        bracketStack.pop();
                    }
                }
            } else {
                bracketStack.push(paran.charAt(i));
            }
        }

        if(bracketStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
