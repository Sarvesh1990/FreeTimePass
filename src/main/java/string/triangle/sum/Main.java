package string.triangle.sum;

/**
 * Created by apple on 26/03/17.
 */
public class Main {
    public static void main(String[] args) {
        String str = "5#9#6#4#6#8#0#7#15#5";

        System.out.println(findMaxSum(str));
    }

    private static Integer findMaxSum(String str) {
        String[] strList = str.split("#");
        if(strList.length == 0) {
            return -1;
        }

        int i = 0;
        int sum = 0;
        int count = 1;

        while(i < strList.length) {
            int max = findMax(strList, i, count);
            if(max == -1) {
                return -1;
            }

            sum = sum + max;
            i = i + count;
            count++;
        }

        return sum;
    }

    private static int findMax(String[] strList, int start, int count) {
        if(start + count > strList.length) {
            return -1;
        }

        int max = -1;
        for(int i = start; i < start + count; i++) {
            String str = strList[i];
            if(str.length() == 0) {
                return -1;
            }

            for(int j = 0; j < str.length(); j++) {
                if((int) str.charAt(j) < 48 || (int) str.charAt(j) > 57) {
                    return -1;
                }
            }
            if(Integer.parseInt(str) > max) {
                max = Integer.parseInt(str);
            }
        }

        return max;

    }
}
