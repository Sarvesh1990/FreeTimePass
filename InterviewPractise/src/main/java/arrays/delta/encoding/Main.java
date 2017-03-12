package arrays.delta.encoding;

/**
 * Created by sarvesh on 11/3/17.
 */
public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {25626, 25757, 24367, 24267, 16, 100, 2, 7277};
        deltaEncoding(array);
    }

    private static void deltaEncoding(int[] array) {
        if(array.length == 0) {
            return;
        }

        System.out.println(array[0]);

        for(int i = 1; i < array.length; i++) {
            int diff = array[i] - array[i - 1];
            if(diff > 127 || diff < -127) {
                System.out.println(-128);
            }
            System.out.println(diff);
        }
    }
}
