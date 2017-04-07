package string.smart.substring;

/**
 * Created by sarvesh on 11/3/17.
 */
public class Main {
    public static void main(String[] args) {
        String str = "Featuring stylish rooms and moorish";
        smartSubstr(str, 30);
    }

    private static void smartSubstr(String str, int count) {
        int currentIndex = -1;
        for(int i = 0; i <= count; i++) {
            if(i == str.length()) {
                if(str.charAt(i - 1) != ' ') {
                    currentIndex = i - 1;
                }
                break;
            }

            if(str.charAt(i) == ' ') {
                if(i > 0) {
                    if (str.charAt(i - 1) != ' ') {
                        currentIndex = i - 1;
                    }
                }
            }
        }
        if(currentIndex != -1) {
        System.out.println(str.substring(0, currentIndex + 1) + ".");
        } else {
            System.out.println("No smart substring");
        }
    }

}
