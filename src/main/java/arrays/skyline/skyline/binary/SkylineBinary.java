package arrays.skyline.skyline.binary;

import javax.sound.sampled.Line;
import java.util.*;

public class SkylineBinary {
    public static void main(String[] args) {
        SkylineBinary sb = new SkylineBinary();

        List<int[]> list = sb.getSkyline(new int[][] {{1,5, 11}, {2,7, 6}, {3, 9, 13}, {12,16,7}, {14,25, 3},
        {19,22, 18}, {23,29, 13}, {24,28,4}});

        for(int[] integer : list) {
            System.out.println(integer[0] + " " + integer[1]);
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        if(buildings == null) {
            return null;
        }

        if(buildings.length == 0) {
            return new LinkedList<int[]>();
        }

        LinkedList<int[]> mergedList = new LinkedList<>();
        mergedList.add(new int[] {buildings[0][0], buildings[0][1], buildings[0][2]});

        for(int i = 1; i < buildings.length; i++) {
            merge(mergedList, buildings[i]);
        }


        return mergeList(mergedList);
    }

    public List<int[]> mergeList(List<int[]> unMergedList) {
        List<int[]> mergedList = new LinkedList<>();

        int current = unMergedList.get(0)[0];
        int currentValue = 0;

        for(int i = 0; i < unMergedList.size(); i++) {
            if(unMergedList.get(i)[0] != current) {
                mergedList.add(new int[] {current, 0});
                mergedList.add(new int[] {unMergedList.get(i)[0], unMergedList.get(i)[2]});
                current = unMergedList.get(i)[1];
                currentValue = unMergedList.get(i)[2];
            } else {
                if(unMergedList.get(i)[2] == currentValue) {
                    current = unMergedList.get(i)[1];
                } else {
                    mergedList.add(new int[] {unMergedList.get(i)[0], unMergedList.get(i)[2]});
                    current = unMergedList.get(i)[1];
                    currentValue = unMergedList.get(i)[2];
                }
            }
        }
        mergedList.add(new int[] {current, 0});
        return mergedList;
    }

    public void merge(List<int[]> mergedList, int[] newBuilding) {
        int smallerListIndex = findSmallerList(mergedList, newBuilding);
        if(smallerListIndex == -1) {
            mergedList.add(newBuilding);
        } else {
            int[] smallerList = mergedList.get(smallerListIndex);

            boolean flag = false;
            for(int i = smallerListIndex; i < mergedList.size(); i++) {
                int[] list = mergedList.get(i);
                if(list[0] > newBuilding[0]) {
                    if(list[2] < newBuilding[2]) {
                        if(list[1] < newBuilding[1]) {
                            list[0] = newBuilding[0];
                            list[2] = newBuilding[2];
                            newBuilding[0] = list[2];
                        } else if (list[1] > newBuilding[1]){
                            list[0] = newBuilding[1];
                            mergedList.add(i, newBuilding);
                            i++;
                            flag = true;
                            break;
                        } else {
                            list[0] = newBuilding[0];
                            list[2] = newBuilding[2];
                            flag = true;
                            break;
                        }
                    } else if (list[2] > newBuilding[2]){
                        if(list[1] < newBuilding[1]) {
                            mergedList.add(i, new int[]{newBuilding[0], list[0], newBuilding[2]});
                            newBuilding[0] = list[2];
                            i++;
                        } else {
                            mergedList.add(i, new int[]{newBuilding[0], list[0], newBuilding[2]});
                            i++;
                            flag = true;
                            break;
                        }
                    } else {
                        if(list[1] < newBuilding[1]) {
                            list[0] = newBuilding[0];
                            newBuilding[0] = list[2];
                            i++;
                        } else {
                            list[0] = newBuilding[0];
                            flag = true;
                            break;
                        }
                    }
                } else if(list[0] < newBuilding[0]){
                    if(list[2] < newBuilding[2]) {
                        if(list[1] < newBuilding[1]) {
                            mergedList.add(i, new int[] {list[0], newBuilding[0], list[2]});
                            list[0] = newBuilding[0];
                            list[2] = newBuilding[2];
                            newBuilding[0] = list[1];
                            i++;
                        } else if (list[1] > newBuilding[1]){
                            mergedList.add(i, new int[] {list[0], newBuilding[0], list[2]});
                            mergedList.add(i + 1, newBuilding);
                            list[0] = newBuilding[1];
                            flag = true;
                            break;
                        } else {
                            mergedList.add(i, new int[] {list[0], newBuilding[0], list[2]});
                            list[0] = newBuilding[0];
                            list[2] = newBuilding[2];
                            flag = true;
                            break;
                        }
                    } else {
                        if(list[1] < newBuilding[1]) {
                            newBuilding[0] = list[1];
                        } else {
                            flag = true;
                            break;
                        }
                    }
                } else {
                    if(list[2] < newBuilding[2]) {
                        if(list[1] < newBuilding[1]) {
                            list[2] = newBuilding[2];
                            newBuilding[0] = list[1];
                        } else if (list[1] > newBuilding[1]){
                            mergedList.add(i, new int[] {list[0], newBuilding[1], newBuilding[2]});
                            list[0] = newBuilding[1];
                            flag = true;
                            break;
                        } else {
                            list[2] = newBuilding[2];
                            flag = true;
                            break;
                        }
                    } else {
                        if(list[1] < newBuilding[1]) {
                            newBuilding[0] = list[1];
                        } else {
                            flag = true;
                            break;
                        }
                    }
                }
            }
            if(!flag) {
                System.out.println("Building " + newBuilding[0] + " " + newBuilding[1] + " " + newBuilding[2]);
                mergedList.add(newBuilding);
            }

            for(int[] integer : mergedList) {
                System.out.println("Merged " + integer[0] + " " + integer[1] + " " + integer[2]);
            }
        }
    }

    public int findSmallerList(List<int[]> mergedList, int[] newBuilding) {
        for(int i = 0; i < mergedList.size(); i++) {
            if(mergedList.get(i)[1] > newBuilding[0]) {
                return i;
            }
        }
        return -1;
    }

}
