package stack.infix.to.postfix;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by sarvesh on 14/3/17.
 */
public class MAin {
    public static void main(String[] args) {
        String str = "a+b*(c*d-e)*(f+g*h)-i";
        Map<Character, String> map = new HashMap<>();
        int count = 1;

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                String subStr = "";
                i++;
                while(str.charAt(i) != ')') {
                    subStr = subStr + str.charAt(i);
                    i++;
                }
            }
        }
        System.out.println(infixToPostfix(str));
    }

    private static String infixToPostfix(String str) {
        Stack<Character> postFixStack = new Stack();
        Stack tempStack = new Stack();

        postFixStack.push(str.charAt(0));

        int i = 2;
        Character currentLowest = null;

        while(i < str.length()) {
            postFixStack.push(str.charAt(i));
            postFixStack.push(str.charAt(i - 1));
            if(currentLowest == null) {
                currentLowest = str.charAt(i - 1);
            } else {
                if((currentLowest == '+' || currentLowest == '-') && (str.charAt(i - 1) == '*'  || str.charAt(i - 1) == '/')) {
                    Character element = postFixStack.pop();
                    Character number = postFixStack.pop();
                    Character currentLowestChar = postFixStack.pop();

                    postFixStack.push(number);
                    postFixStack.push(element);
                    postFixStack.push(currentLowestChar);
                }
            }
            currentLowest = postFixStack.peek();
            i = i + 2;
        }
        return postFixStack.toString();
    }
}
