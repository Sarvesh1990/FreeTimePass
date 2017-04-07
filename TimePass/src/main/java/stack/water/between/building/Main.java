package stack.water.between.building;

import static java.lang.StrictMath.min;

/**
 * Created by apple on 27/02/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(findWaterBetweenBuilding(new int[] {2, 0, 2}));
    }

    private static Integer findWaterBetweenBuilding(int[] buildingHeightArray) {
        int[] maxWaterOnLeft = new int[buildingHeightArray.length];
        int[] maxWaterOnRight = new int[buildingHeightArray.length];

        for(int i = maxWaterOnRight.length - 1; i >=0; i--) {
            if(i == maxWaterOnRight.length - 1) {
                maxWaterOnRight[i] = 0;
            } else {
                if(maxWaterOnRight[i+1] >= buildingHeightArray[i+1]) {
                    maxWaterOnRight[i] = maxWaterOnRight[i+1];
                } else {
                    maxWaterOnRight[i] = buildingHeightArray[i + 1];
                }
            }
        }

        for(int i = 0; i < maxWaterOnLeft.length; i++) {
            if(i == 0) {
                maxWaterOnLeft[i] = 0;
            } else {
                if(maxWaterOnLeft[i-1] >= buildingHeightArray[i-1]) {
                    maxWaterOnLeft[i] = maxWaterOnLeft[i-1];
                } else {
                    maxWaterOnLeft[i] = buildingHeightArray[i - 1];
                }
            }
        }

        int waterAmount = 0;

        for(int i = 0; i < buildingHeightArray.length; i++) {
            int storedWater = min(maxWaterOnLeft[i], maxWaterOnRight[i]) - buildingHeightArray[i];
            if(storedWater > 0) {
                waterAmount = waterAmount + storedWater;
            }
        }

        return waterAmount;

    }


}
