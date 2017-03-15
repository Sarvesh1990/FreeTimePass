package stack.infix.to.postfix;

import java.util.*;

/**
 * Created by sarvesh on 14/3/17.
 */
public class MAin {
    public static void main(String[] args) {
        String str = "a+b+c*d-e^g*f";
        Map<Character, ArrayList<Character>> precedenceMap = new HashMap<>();
        precedenceMap = buildPrecedenceMap();

        System.out.println(infixToPostfix(str, precedenceMap));
    }

    private static Map<Character,ArrayList<Character>> buildPrecedenceMap() {
        Map<Character, ArrayList<Character>> precedenceMap = new HashMap<>();
        precedenceMap.put('+', new ArrayList<Character>(){
            {
                add('*');
                add('/');
                add('^');
            }
        });
        precedenceMap.put('-', new ArrayList<Character>(){
            {
                add('*');
                add('/');
                add('^');
            }
        });
        precedenceMap.put('*', new ArrayList<Character>(){
            {
                add('^');
            }
        });
        precedenceMap.put('/', new ArrayList<Character>(){
            {
                add('^');
            }
        });
        precedenceMap.put('^', new ArrayList<Character>());

        return precedenceMap;
    };

    private static String infixToPostfix(String str, Map<Character,ArrayList<Character>> precedenceMap) {
        Stack<Character> operandStack = new Stack<Character>();
        String postFixStr = "";

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                operandStack.push(str.charAt(i));
            } else if (str.charAt(i) == ')') {
                while(operandStack.peek() != '(') {
                    postFixStr = postFixStr + operandStack.pop();
                }
                operandStack.pop();
            } else if(str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/' || str.charAt(i) == '^') {
                if(operandStack.isEmpty()) {
                    operandStack.push(str.charAt(i));
                } else {
                    Character lastChar = operandStack.peek();
                    if (lastChar.equals('(') || precedenceMap.get(lastChar).contains(str.charAt(i))) {
                        operandStack.push(str.charAt(i));
                    } else {
                        while (!operandStack.isEmpty()) {
                            if(operandStack.peek() == '(') {
                                break;
                            }
                            if(!precedenceMap.get(str.charAt(i)).contains(operandStack.peek())) {
                                break;
                            }
                            postFixStr = postFixStr + operandStack.pop();
                        }
                        operandStack.push(str.charAt(i));
                    }
                }
            } else {
                postFixStr = postFixStr + str.charAt(i);
            }
        }

        while(!operandStack.isEmpty()) {
            postFixStr = postFixStr + operandStack.pop();
        }

        return postFixStr;

    }


}
