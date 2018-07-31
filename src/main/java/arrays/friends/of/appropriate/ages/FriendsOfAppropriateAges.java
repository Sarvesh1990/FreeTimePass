package arrays.friends.of.appropriate.ages;

import java.util.Arrays;


//Handle 6,6 case
public class FriendsOfAppropriateAges {
    public static void main(String[] args) {
        FriendsOfAppropriateAges ff = new FriendsOfAppropriateAges();
        System.out.println(ff.numFriendRequests(new Integer[] {73,106,39,6,26,15,30,100,71,35,46,112,6,60,110}));
    }

    public int numFriendRequests(Integer[] ages) {
        Arrays.sort(ages);
        System.out.println(Arrays.asList(ages));
        int result = 0;

        for(int i = ages.length - 1; i >= 1 ; i--) {
            int index = findIndex(ages[i]/2 + 7, ages);
            System.out.println(i + " " + index + " " + (i - index - 1));
            result += (index == -1) ? i : (i - index > 0) ? (i - index - 1) : 0;
        }

        int repeatCount = 0;

        for(int i = 1; i < ages.length; i++) {
            if(ages[i] == ages[i - 1]) {
                repeatCount++;
            } else {
                if(repeatCount > 0) {
                    result += (repeatCount *  (repeatCount + 1))/2;
                }
                repeatCount = 0;
            }
        }
        if(repeatCount > 0) {
            System.out.println(repeatCount);
            result += (repeatCount *  (repeatCount + 1))/2;
        }

        return result;
    }

    public int findIndex(int age, Integer[] ages) {
        return findIndexHelper(age, ages, 0, ages.length - 1);
    }

    public int findIndexHelper(int age, Integer[] ages, int low, int high) {
        if(high < low) {
            return -1;
        }

        int mid = low + (high - low)/2;

        if(ages[mid] == age) {
            if(mid < ages.length - 2) {
                if(ages[mid + 1] == age) {
                    return findIndexHelper(age, ages, mid + 1, high);
                } else {
                    return mid;
                }
            } else {
                return mid;
            }
        } else if (ages[mid] < age) {
            if(mid < ages.length - 2) {
                if(ages[mid + 1] <= age) {
                    return findIndexHelper(age, ages, mid + 1, high);
                } else {
                    return mid;
                }
            } else {
                return mid;
            }
        } else {
            return findIndexHelper(age, ages, low, mid - 1);
        }

    }
}
