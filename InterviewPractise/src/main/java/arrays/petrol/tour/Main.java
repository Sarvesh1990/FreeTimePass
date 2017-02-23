package arrays.petrol.tour;

import java.util.ArrayList;

/**
 * Created by apple on 20/02/17.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<int[]> petrolPumps = new ArrayList<>();
        petrolPumps.add(new int[]{6, 6});
        petrolPumps.add(new int[]{6, 6});
        petrolPumps.add(new int[]{2, 3});
        petrolPumps.add(new int[]{0, 5});

        int[] difference = new int[petrolPumps.size()];
        for (int i = 0; i < petrolPumps.size(); i++) {
            difference[i] = petrolPumps.get(i)[0] - petrolPumps.get(i)[1];
        }

        int currentSum = 0;
        int i = 0;

        while(i < difference.length){
            for(int j = i; j < difference.length + i; j++) {
                if(j == i + difference.length - 1) {
                    System.out.println("Circle can be completed : " + i);
                    i = difference.length;
                    break;
                }
                int temp = j;
                if(j > difference.length - 1) {
                     temp = j - difference.length;
                }
                currentSum = currentSum + difference[temp];
                if (currentSum < 0) {
                    i = temp + 1;
                    currentSum = 0;
                    break;
                }
            }
         }
    }
}

