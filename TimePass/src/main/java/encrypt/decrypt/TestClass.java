package encrypt.decrypt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        //Scanner
//        Scanner s = new Scanner(System.in);
//        long numTestCase = s.nextLong();
//
//        for (int i = 0; i < numTestCase; i++) {
//            String str1 = s.next();
//            String str2 = s.next();
//            long index = s.nextLong();
//        }
    System.out.println(findDecodedString("ujldgeanps", "uabmjvhrzp", 4));

}

    private static String findDecodedString(String enc, String dec, long index) {
        int j = 0;
        LinkedList<Integer> permutedList = new LinkedList<>();
        Map<Integer, Character> originalList = new HashMap<>();
        Map<Integer, Character> permutedMap = new HashMap<>();
        Map<Character, Boolean> charMap = new HashMap<>();
        for(int i = 0; i < 26; i++) {
            if((j < enc.length()) && (enc.charAt(j) == (char) 97 + i)) {
                originalList.put(i + 1, dec.charAt(j));
                permutedMap.put(i + 1, (char) ((char) 97 + i));
                j++;
            } else {
                permutedMap.put(i + 1, (char) ((char) 97 + i));
            }
        }

        for(Integer key : originalList.keySet()) {
            permutedMap.remove(originalList.get(key) - 'a' + 1);
        }

        for(Integer key : permutedMap.keySet()) {
            permutedList.add(key);
        }

        LinkedList<Integer> sortedList = findLexicographicPermutation(permutedList, index);

        LinkedList<Character> finalList = new LinkedList<>();
        j = 0;
        for(int i = 0; i < sortedList.size(); i++) {
            if(originalList.containsKey(j + 1)) {
                finalList.add(originalList.get(j + 1));
                i--;
            } else {
                finalList.add((char) ((char) 97 + sortedList.get(i) - 1));
            }
            j++;
        }


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < finalList.size(); i++) {
            sb.append(finalList.get(i));
        }
        return sb.toString();
    }

    private static LinkedList<Integer> findLexicographicPermutation(LinkedList<Integer> number, Long index) {
        if(index > factorial(number.size())) {
            return null;
        }

        int currentFactorial = 1;
        int currentIndex = number.size();

        while (index > currentFactorial) {
            currentFactorial = currentFactorial * (number.size() - currentIndex + 1);
            currentIndex--;
        }

        LinkedList<Integer> permutation = new LinkedList<>();

        for(int i = 0; i < currentIndex; i++) {
            permutation.add(number.get(i));
        }

        if(currentIndex == number.size()) {
            return permutation;
        }

        int tempIndex = currentIndex + 1;
        int tempFactorial = factorial(number.size() - currentIndex - 1);
        Long tempK = index;

        while(tempK > tempFactorial) {
            tempK = tempK - tempFactorial;
            tempIndex++;
        }

        permutation.add(number.get(tempIndex - 1));


        LinkedList<Integer> tempList = new LinkedList<>();

        for(int i = 0; i < number.size() - currentIndex; i++) {
            if(i + currentIndex != tempIndex - 1) {
                tempList.add(number.get(i + currentIndex));
            }
        }

        LinkedList<Integer> newList = findLexicographicPermutation(tempList, tempK);


        for(int i = 0; i < newList.size(); i++) {
            permutation.add(newList.get(i));
        }

        return permutation;
    }

    private static Integer factorial (int number) {
        int i = number;
        int factorial = 1;
        while(i > 1) {
            factorial = factorial * i;
            i--;
        }
        return factorial;
    }

}
