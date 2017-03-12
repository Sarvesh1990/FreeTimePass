package string.substring;

/**
 * Created by apple on 25/02/17.
 */
public class Main {
    public static String minWindow(String s, String t) { // s is the string and t is alphabet
        int[] map = new int[256];
        int begin=0,end=0; // for substring window
        int head = begin; // for getting the output substring

        for(int i=0;i<t.length();i++) { // fill the map with freq of chars in t
            map[t.charAt(i)]++;
        }

        int count = t.length(); // size of t as we have to have this count check
        int min=Integer.MAX_VALUE;

        while(end<s.length()) {
            // System.out.println(s.charAt(end) + "\t" + map[s.charAt(end)]);
            // System.out.println("Step 1\t"+count+"\t"+begin+"\t"+end+"\t"+head+"\t"+min);
            if(map[s.charAt(end++)] > 0) { // if it is present in map decrease count
                count--;
            }
            // System.out.println("Step 2\t"+count+"\t"+begin+"\t"+end+"\t"+head+"\t"+min);
            while(count==0) { // t is found in s
                if(end-begin<min) { // update min and head
                    min = end-begin;
                    head = begin;
                }
                if(map[s.charAt(begin++)]++==0) { // shrink the window
                    count++;
                }
            }
            // System.out.println("Step 3\t"+count+"\t"+begin+"\t"+end+"\t"+head+"\t"+min);
        }

        return min==Integer.MAX_VALUE ? "" : s.substring(head,head+min);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("aabbccba", "abc"));
    }
}