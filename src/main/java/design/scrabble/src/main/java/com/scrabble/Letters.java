package design.scrabble.src.main.java.com.scrabble;

/**
 * Created by sarvesh on 20/12/17.
 */
public class Letters {
    private char value;
    private int points;

    public Letters(char value) {
        this.value = value;
        this.points = Constants.characterPoints[(int) value - 97];
    }

    public char getValue() {
        return value;
    }

    public int getPoints() {
        return points;
    }
}
