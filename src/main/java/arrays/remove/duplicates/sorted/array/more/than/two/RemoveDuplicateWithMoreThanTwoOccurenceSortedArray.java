package arrays.remove.duplicates.sorted.array.more.than.two;


/*
Traverse array from i = 1 till length. Keep currIndex. Start from 0. Check if array[i] == array[currIndex]. If yes check if duplicateCount
== 2. If yes, just decrease length. If no, consider that element, Swap with currentIndex. currentIndex++. count++.
If array doesn't match do same thing like count. Make count 0. Swap and increase currentIndex.
Swap element at currentIndex + 1
 */
public class RemoveDuplicateWithMoreThanTwoOccurenceSortedArray {
    public static void main(String[] args) {
        RemoveDuplicateWithMoreThanTwoOccurenceSortedArray rr = new RemoveDuplicateWithMoreThanTwoOccurenceSortedArray();

        int length = rr.removeDuplicates(new int[] {0,0,1,1,1,1,2,3,3});
    }

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int currIndex = 0;
        int currCount = 0;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[currIndex]) {
                if(currCount == 0) {
                    currCount++;
                    swap(nums, i, currIndex);
                    currIndex++;
                } else {
                    length--;
                }
            } else {
                currCount = 0;
                swap(nums, i, currIndex);
                currIndex++;
            }
        }

        for(int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }

        return length;
    }

    public void swap(int[] nums, int i, int currIndex) {
        if(currIndex < i - 1) {
            int temp = nums[i];
            nums[i] = nums[currIndex + 1];
            nums[currIndex + 1] = temp;
        }
    }
}

