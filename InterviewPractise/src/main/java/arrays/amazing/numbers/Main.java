package arrays.amazing.numbers;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 21/02/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(getIndex(new int[] {1, 2, 3, 4, 5, 1, 2, 9, 10, 11, 1, 2, 3, 4, 5, 6}));
    }

    private static int getIndex(int[] array) {
        Map<Integer, Integer> indexCount = new HashMap<>();
        for(int i = 0; i < array.length; i++) {
            if(indexCount.containsKey(i - array[i])) {
                indexCount.put(i - array[i], indexCount.get(i - array[i]) + 1);
            } else {
                indexCount.put(i - array[i], 1);
            }
        }

        int maxAmazing = 0;
        int maxIndex = 0;
        int currentAmazing = 0;

        for(Integer key : indexCount.keySet()) {
            System.out.println(key + " " + indexCount.get(key));
            if(key >= 0) {
                currentAmazing = currentAmazing + 1;
                maxAmazing = maxAmazing + indexCount.get(key);
            }
        }

        System.out.println(maxAmazing);

        if(currentAmazing > maxAmazing) {
            maxAmazing = currentAmazing;
            maxIndex = 0;
        }


        int j = 0;

        for(int i = 1; i < array.length; i++) {
            if(indexCount.containsKey(j)) {
                currentAmazing = currentAmazing - indexCount.get(j);
            }
            j++;

            int next = array.length - 1 - array[i -1];
            if(indexCount.containsKey(next + j)) {
                indexCount.put(next + j, indexCount.get(next + j) + 1);
            } else {
                indexCount.put(next + j, 1);
            }

            for(Integer key : indexCount.keySet()) {
                System.out.println(key + " " + indexCount.get(key));
            }

            if(next >= 0) {
                currentAmazing = currentAmazing + 1;
            }

            if(currentAmazing > maxAmazing) {
                maxAmazing = currentAmazing;
                maxIndex = i;
                System.out.println("Max " + maxAmazing);
            }
        }

        return maxIndex;
    }
}
