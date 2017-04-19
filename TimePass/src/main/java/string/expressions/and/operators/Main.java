package string.expressions.and.operators;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by sarvesh on 11/4/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(addOperators("12345", 45));
    }

    public static List<String> addOperators(String num, int target) {
        List<String> finalResponse = new LinkedList<>();
        if(num.length() == 0) {
            return finalResponse;
        }
        Map<String, Integer> response = new HashMap<>();
        for(int i = 0; i < num.length() - 1; i++) {
            Integer number = Integer.parseInt(String.valueOf(num.charAt(i)));
            if(response.isEmpty()) {
                response.put(number.toString(), number);
            } else {
                Map<String, Integer> temp = new HashMap<>(response);
                response = new HashMap<>();
                for (String key : temp.keySet()) {
                    response.put(key + "+" + number.toString(), temp.get(key) + number);
                    response.put(key + "-" + number.toString(), temp.get(key) - number);

                    String operator = null;
                    int j;
                    for(j = key.length() - 2; j >=0; j--) {
                        if(key.charAt(j) == '+' || key.charAt(j) == '-' || key.charAt(j) == '*') {
                            operator = String.valueOf(key.charAt(j));
                            break;
                        }
                    }

                    if(operator != null) {
                        Integer prevNum = Integer.parseInt(key.substring(j+1, key.length()));
                        if (operator.equals("+")) {
                            response.put(key + "*" + number.toString(), (temp.get(key) - prevNum) + (prevNum * number));
                            response.put(key + number.toString(), (temp.get(key) - prevNum + (prevNum * 10 + number)));
                        } else if (operator.equals("-")) {
                            response.put(key + "*" + number.toString(), (temp.get(key) + prevNum) - (prevNum * number));
                            response.put(key + number.toString(), (temp.get(key) + prevNum - (prevNum * 10 + number)));
                        } else {
                            response.put(key + "*" + number.toString(), (temp.get(key) * number));
                            if(prevNum != 0)
                                response.put(key + number.toString(), ((temp.get(key) / prevNum) * (prevNum * 10 + number)));
                        }

                    } else {
                        response.put(key + "*" + number.toString(), (temp.get(key) * number));
                        response.put(key + number.toString(), (temp.get(key)*10 + number));
                    }
                }
            }
            System.out.println(response);
        }

        Integer finalSum = Integer.parseInt(String.valueOf(num.charAt(num.length() - 1)));

        if(response.size() > 0) {
            for (String key : response.keySet()) {
                if (response.get(key) + finalSum == target) {
                    finalResponse.add(key + "+" + finalSum);
                }
                if (response.get(key) - finalSum == target) {
                    finalResponse.add(key + "-" + finalSum);
                }
                if(key.length() > 1) {
                    Integer prevNum = Integer.parseInt(key.substring(key.length() - 1, key.length()));
                    String operator = key.substring(key.length() - 2, key.length() - 1);
                    if (operator.equals("+")) {
                        if(response.get(key) - prevNum + (prevNum * finalSum) == target) {
                            finalResponse.add(key + "*" + finalSum);
                        }
                    } else if (operator.equals("-")) {
                        if(response.get(key) + prevNum - (prevNum * finalSum) == target) {
                            finalResponse.add(key + "*" + finalSum);
                        }
                    } else {
                        if(response.get(key) * finalSum == target) {
                            finalResponse.add(key + "*" + finalSum);
                        }
                    }
                } else {
                    if(response.get(key) * finalSum == target) {
                        finalResponse.add(key + "*" + finalSum);
                    }
                }
            }
        } else {
            if(finalSum == target) {
                finalResponse.add(finalSum.toString());
            }
        }

        return finalResponse;
    }
}
