package arrays.next.permutation.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Traverse from end. Check if current number is greater than previous. If not - i--. Otherwise sort number from current number till end.
Then start traversing from current number towards right. As soon as you find a number bigger than previous number swap
 */

public class NextPermutationNumber {

    public static void main(String[] args) {
        int n = 1999999999;
        ArrayList<Integer> list = new ArrayList<>();
        while(n > 0) {
            list.add(0, n % 10);
            n = n / 10;
        }

        Integer[] nums = new Integer[list.size()];
        nums = list.toArray(nums);

        nextPermutation(nums);
    }

    public static void nextPermutation(Integer[] nums) {

        if(nums == null) {
            return;
        }

        int i = nums.length - 1;

        while(i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }

        if(i == 0) {
            Arrays.sort(nums);
        } else {
            Arrays.sort(nums, i, nums.length);

            for(int j = i; j < nums.length; j++) {
                if(nums[j] > nums[i-1]) {
                    int temp = nums[j];
                    nums[j] = nums[i-1];
                    nums[i-1] = temp;
                    break;
                }
            }
        }

        int num = 0;
        for(i = 0; i < nums.length; i++) {
            try {
                num = addAndCheck(num, num * 9 + nums[i]);
            } catch (Exception e) {
                num = -1;
            }
        }

        System.out.println(num);

    }

    public static int addAndCheck(int x, int y)
            throws Exception {
        long s = (long)x + (long)y;
        System.out.println(x + " " + y);
        System.out.println(s);
        if (s < Integer.MIN_VALUE || s > Integer.MAX_VALUE) {
            throw new Exception("Overflow");
        }
        return (int)s;
    }
}
