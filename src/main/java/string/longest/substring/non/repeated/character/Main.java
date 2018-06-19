package string.longest.substring.non.repeated.character;

import java.io.*;
import java.util.*;
// Given a string, find the longest continuos substring with no repeated characters.
// try these 
//Input "abc" Output "abc"
//Input "abcda" Output "abcd" (OR "bcda")
//Input "king of chinaloyd" Output “f chinaloyd"
//Input aabbc Output ab (OR bc)
//Input abaaabc Output abc
//Input "abcdae" Output "bcdae"



public  class Main {
    public static void main(String[] args) {
        Main Main=   new Main();
        String[] input= new String[]{"amamamac" ,"abcda",
                "king of chinaloyd","aabbc","abaaabc","abcdae"};

        for(String s : input){
            String output = Main.longestSubstring(s);
            System.out.println(String.format("%s| %s",s,output));
        }
    }


    private String longestSubstring(String input){
        int startIndex = 0;
        int maxContSubStr = 0;

        int maxContSubStrStartIndex = 0;
        int maxContSubStrEndIndex = 0;

        Map<Character, Integer> visitedCharMap = new HashMap<>();

        for(int i = 0; i < input.length(); i++) {
            if(visitedCharMap.containsKey(input.charAt(i)) && (startIndex <= visitedCharMap.get(input.charAt(i)))) {
                if((i - startIndex) > maxContSubStr) {
                    maxContSubStr = (i - startIndex);
                    maxContSubStrStartIndex = startIndex;
                    maxContSubStrEndIndex = i - 1;
                }

                startIndex = visitedCharMap.get(input.charAt(i)) + 1;
            }
            visitedCharMap.put(input.charAt(i), i);
        }

        if((input.length() - startIndex) > maxContSubStr) {
            maxContSubStrStartIndex = startIndex;
            maxContSubStrEndIndex = input.length() - 1;
        }

        StringBuilder longestContSubStrBuilder = new StringBuilder();

        for(int j = maxContSubStrStartIndex; j <=  maxContSubStrEndIndex; j++) {
            longestContSubStrBuilder.append(input.charAt(j));
        }

        return longestContSubStrBuilder.toString();
    }
}