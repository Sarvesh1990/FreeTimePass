package string.zigzag.to.normal.string;

/**
 * Created by apple on 07/06/18.
 */

//Start printing each character one by one. Keep direction and write in array

class Main {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] sortedString = new StringBuilder[numRows];

        for(int j = 0; j < numRows; j++) {
            sortedString[j] = new StringBuilder();
        }

        int i = 0;
        int direction = 1; //Means down

        for(int j = 0; j < s.length(); j++) {
            sortedString[i].append(s.charAt(j));
            if(direction == 1) {
                if(i == numRows - 1) {
                    direction = 0;
                    i--;
                } else {
                    i++;
                }
            } else {
                if(i == 0) {
                    i++;
                    direction = 1;
                } else {
                    i--;
                }
            }
        }

        StringBuilder finalStr = new StringBuilder();

        for(int j = 0; j < numRows; j++) {
            finalStr.append(sortedString[j]);
        }

        return finalStr.toString();
    }
}