package arrays.next.permutation.number;

import java.util.Arrays;

/*
Traverse from end. Check if current number is greater than previous. If not - i--. Otherwise sort number from current number till end.
Then start traversing from current number towards right. As soon as you find a number bigger than previous number swap
 */

public class NextPermutationNumber {

    public static void main(String[] args) {
        nextPermutation(new int[] {1, 3, 2});
    }

    public static void nextPermutation(int[] nums) {
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

        for(i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }

    }
}
