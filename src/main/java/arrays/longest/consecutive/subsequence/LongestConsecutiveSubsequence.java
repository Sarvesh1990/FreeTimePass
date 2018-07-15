package arrays.longest.consecutive.subsequence;

import java.util.HashMap;
import java.util.Map;

/*
1) Create an empty hash.
2) Insert all array elements to hash.
3) Do following for every element arr[i]
....a) Check if this element is the starting point of a
       subsequence.  To check this, we simply look for
       arr[i] - 1 in hash, if not found, then this is
       the first element a subsequence.

       If this element is a first element, then count
       number of elements in the consecutive starting
       with this element.

       If count is more than current res, then update
       res.
 */
public class LongestConsecutiveSubsequence {
}
