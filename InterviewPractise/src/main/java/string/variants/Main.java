package string.variants;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by apple on 25/02/17.
 */
public class Main {
    public static void main(String[] args) {
        printAllVariants(new int[] {1, 2, 3, 4});
    }

    private static void printAllVariants(int[] ints) {
        List<ArrayList<ArrayList<Integer>>> integerList = new ArrayList<>();

        integerList.add(new ArrayList<ArrayList<Integer>>(){
            {
                add(new ArrayList<Integer>(){
                    {
                        add(ints[0]);
                    }
                });
            }});

        for(int i = 1; i < ints.length; i++) {
            ArrayList<ArrayList<Integer>> variantList = new ArrayList<>();
            ArrayList<ArrayList<Integer>> previousLists = integerList.get(i - 1);
            for(int j = 0; j < previousLists.size(); j++) {
                ArrayList<Integer> previousList = new ArrayList<>(previousLists.get(j));
                previousList.add(ints[i]);
                variantList.add(previousList);

                previousList = new ArrayList<>(previousLists.get(j));
                if(previousList.get(previousList.size() - 1) < 10) {
                    int temp = previousList.get(previousList.size() - 1);
                    previousList.remove(previousList.size() - 1);
                    int number = temp * 10 + ints[i];
                    if(number <= 26) {
                        previousList.add(temp * 10 + ints[i]);
                        variantList.add(previousList);
                    }
                }
            }
            integerList.add(variantList);
        }

        System.out.println(integerList.get(integerList.size() - 1));
    }


}
