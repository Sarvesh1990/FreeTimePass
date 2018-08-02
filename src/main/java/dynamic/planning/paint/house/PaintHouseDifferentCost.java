package dynamic.planning.paint.house;

public class PaintHouseDifferentCost {
    public static void main(String[] args) {
        int[][] house = new int[2][3];
        house[0][0] = 1;
        house[0][1] = 5;
        house[0][2] = 3;
        house[1][0] = 2;
        house[1][1] = 5;
        house[1][2] = 4;

        PaintHouseDifferentCost pc = new PaintHouseDifferentCost();

        System.out.println(pc.minCostII(house));
    }


    public int minCostII(int[][] costs) {
        if(costs.length == 0) {
            return 0;
        }

        Integer[] minIndex = findMinIndex(costs[0]);

        for(int i = 1; i < costs.length; i++) {
            for(int j = 0; j < costs[i].length; j++) {
                if(j != minIndex[0]) {
                    costs[i][j] += costs[i - 1][minIndex[0]];
                } else {
                    costs[i][j] += costs[i - 1][minIndex[1]];
                }
            }
            minIndex = findMinIndex(costs[i]);
        }

        return costs[costs.length - 1][minIndex[0]];
    }

    public Integer[] findMinIndex(int[] costs) {
        if(costs.length < 2) {
            return new Integer[]{0, 0};
        }

        int min1 = 0;
        int min2 = -1;

        for(int i = 0; i < costs.length; i++) {
            if(costs[i] < costs[min1]) {
                min1 = i;
            }
        }

        for(int i = 0; i < costs.length; i++) {
            if(i != min1) {
                if(min2 != -1 && costs[i] < costs[min2]) {
                    min2 = i;
                } else {
                    if(min2 == -1) {
                        min2 = i;
                    }
                }
            }
        }

        return new Integer[] {min1, min2};
    }
}
