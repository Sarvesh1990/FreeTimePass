package intervals.meeting.conflicts;

/*
Given a list of intervals with start time and end time of meetings, find if there are any conflicts.
Can be done by sorting the intervals list by starttime. And then check if any of the start time is smaller than end time of previous element
O(nlogn)  because of sorting.

Can be done in O(max_element + n) if max_element is small.
1. Find the overall maximum element. Let it be max_ele
2. Initialize an array of size max_ele with 0.
3. For every interval [start, end], increment the value at index start, i.e. arr[start]++ and decrement the value at index (end + 1), i.e. arr[end + 1]- -.
4. Compute the prefix sum of this array (arr[]).
5. Every index, i of this prefix sum array will tell how many times i has occurred in all the intervals taken together. If this value is greater than 1, then it occurs in 2 or more intervals.
6. So, simply initialize the result variable as false and while traversing the prefix sum array, change the result variable to true whenever the value at that index is greater than 1.
 */
public class IntervalsMeetingConflicts {
}
