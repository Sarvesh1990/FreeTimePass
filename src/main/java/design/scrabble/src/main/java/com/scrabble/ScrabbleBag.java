package design.scrabble.src.main.java.com.scrabble;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by sarvesh on 20/12/17.
 */
public class ScrabbleBag {
    private ArrayList<Letters> lettersInBag = new ArrayList<>();

    public ScrabbleBag(int countLetters) {
        init(countLetters);
    }

    private void init(int countLetters) {
        for(int i = 0; i < countLetters; i++) {
            addLettersToBag();
        }
    }

    private void addLettersToBag() {
        int rand = (int)(Math.random() * (26));
        addLettersToBag((char)(97 + rand));
    }

    private void addLettersToBag(char c) {
        lettersInBag.add(new Letters(c));
    }

    public ArrayList<Letters> getLettersFromBag (int count) {
        ArrayList<Letters> letters = new ArrayList<>(count);
        for(int i = 0; i < count; i++) {
            letters.add(lettersInBag.get(0));
            lettersInBag.remove(0);
        }
        return letters;
    }

    public ArrayList<Letters> swapLettersFromBag (ArrayList<Letters> lettersToBeSwapped) {
        ArrayList<Letters> letters = new ArrayList<>(lettersToBeSwapped.size());
        for(int i = 0; i < lettersToBeSwapped.size(); i++) {
            letters.add(lettersInBag.get(0));
            lettersInBag.remove(0);
        }
        for(int i = 0; i < lettersToBeSwapped.size(); i++) {
            lettersInBag.add(lettersToBeSwapped.get(i));
        }
        return letters;
    }

    public boolean isEmpty() {
        return lettersInBag.isEmpty();
    }

    public int getSize() {
        return lettersInBag.size();
    }

}
