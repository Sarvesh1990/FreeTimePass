package dynamic.planning.ballon.product;

import java.util.ArrayList;

/**
 * Created by sarvesh on 30/3/17.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(5);
        list.add(6);
        list.add(9);
        list.add(3);
        list.add(0);
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(7);
        System.out.println(maxCoins(list));
    }

    public static int maxCoins(ArrayList<Integer> list) {
        int sum = 0;
        while(!list.isEmpty()) {
            if(list.size() == 2 || list.size() == 1) {
                if(list.size() == 1) {
                    sum = sum + list.get(0);
                    list.remove(0);
                } else {
                    sum = sum + list.get(0) + list.get(0) * list.get(1);
                    list.remove(0);
                    list.remove(1);
                }
            }
            
        }
    }
}
