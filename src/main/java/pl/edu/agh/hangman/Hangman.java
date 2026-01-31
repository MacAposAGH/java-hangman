package pl.edu.agh.hangman;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Hangman {

    public static final String[] HANGMANPICS = new String[]{
            "  +---+\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " /    |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "      |\n" +
                    "========"
    };

    public static void main(String[] args) throws FileNotFoundException {
        HangmanUI hangmanUI = new HangmanUI();

        FileReader fileReader = new FileReader();
        ArrayList<String> strings = fileReader.scanFile();
        String randomWord = RandomWordPicker.chooseRandomWord(strings).toLowerCase();

        int counter = HANGMANPICS.length;
        int i = 0;
        int j = 0;

        Scanner scanner = new Scanner(System.in);
        List<Character> list = toList(randomWord);
        char[] chars = new char[randomWord.length()];
        Arrays.fill(chars, '_');

        while (true) {
            System.out.println(chars);
            char c = scanner.next().charAt(0);

            int indexOf = list.indexOf(c);
            if(indexOf >= 0 ){
                list.set(indexOf, '_');
                chars[indexOf] = c;
                i++;
            } else {
                System.out.println(HANGMANPICS[j]);
                counter--;
                j++;
            }

            if(i==list.size()){
                System.out.println("Wygrałeś :)");
                break;
            }

            if (counter == 0) {
                System.out.println("Przegrałeś :(");
                break;
            }
        }

        System.out.println(randomWord);

    }

    public static List<Character> toList(String word) {
        ArrayList<Character> strings = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            strings.add(word.charAt(i));
        }
        return strings;
    }

}
