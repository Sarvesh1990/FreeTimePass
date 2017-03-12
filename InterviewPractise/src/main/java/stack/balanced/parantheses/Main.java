package stack.balanced.parantheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by sarvesh on 11/3/17.
 */
public class Main {
    public static void main(String[] args) {
        String paran = "}";
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
