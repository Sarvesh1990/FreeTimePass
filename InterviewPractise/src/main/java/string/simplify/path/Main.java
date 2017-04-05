package string.simplify.path;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sarvesh on 5/4/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/abc/../../c"));
    }

    public static String simplifyPath(String path) {
        String[] pathArray = path.split("/");
        Stack stack = new Stack();
        for(int i = 0; i < pathArray.length; i++) {
            if(pathArray[i].equals(".") || pathArray[i].equals("")) {
            } else if(pathArray[i].equals("..")) {
                if (stack.isEmpty()) {
                } else {
                    stack.pop();
                }
            } else {
                stack.push(pathArray[i]);
            }
        }
        StringBuilder result = new StringBuilder("");
        if(stack.isEmpty()) {
            return "/";
        }
        List<String> list = new ArrayList<String>(stack);
        for(int i = 0; i < list.size(); i++) {
            result = result.append("/").append(list.get(i));
        }
        return result.toString();
    }
}
