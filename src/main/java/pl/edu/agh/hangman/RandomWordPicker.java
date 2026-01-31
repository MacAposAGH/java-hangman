package pl.edu.agh.hangman;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class RandomWordPicker {
    private static final Random RANDOM = new Random();

    public static String chooseRandomWord(List<String> words) {
        return words.get(RANDOM.nextInt(words.size()));
    }

    public static String chooseRandomWord(List<String> words, Predicate<String> filter) {
        return words.stream()
                .filter(filter)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono słowa"));
    }
}
