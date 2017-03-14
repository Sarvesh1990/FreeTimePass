package stack.infix.to.postfix;

import java.util.Stack;

/**
 * Created by sarvesh on 14/3/17.
 */
public class MAin {
    public static void main(String[] args) {
        String str = "3+4+5*6*7-3";
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
