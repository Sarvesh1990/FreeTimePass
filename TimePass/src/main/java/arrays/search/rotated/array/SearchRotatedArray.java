package arrays.search.rotated.array;

/**
 * Created by apple on 06/03/17.
 */

/*
Boundary condition, low > high. Find mid. Check if left side sorted or right side. If left sorted and number between start and mid search
in left, otherwise right. If right sorted and number between mid and end, search in right otherwise left.
 */
public class SearchRotatedArray {
    public static void main(String[] args) {
        int[] array = {5, 6, 7, 1, 3, 4, 5};
        System.out.println(searchHelper(array, 5, 0, array.length - 1));
    }

    private static int searchHelper(int[] nums, int target, int start, int end) {
        if(start > end) {
            return -1;
        }

        int mid = start + (end - start)/2;

        if(nums[mid] == target) {
            return mid;
        }

        if(nums[start] <= nums[mid]) {
            if(target >= nums[start] && target <= nums[mid]) {
                return searchHelper(nums, target, start, mid - 1);
            } else {
                return searchHelper(nums, target, mid + 1, end);
            }
        } else {
            if(target >= nums[mid] && target <= nums[end]) {
                return searchHelper(nums, target, mid + 1, end);
            } else {
                return searchHelper(nums, target, start, mid - 1);
            }
        }
    }
}
