package w5p4.file;

import java.util.Scanner;

public class StringTokenizer {
    public void printLatinWord() {
        System.out.print("Enter a string : ");
        String encodingWord = "ay";

        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        String[] tokens = inputString.split(" ");
        for (String token : tokens) {
            char firstLetter = token.charAt(0);
            String substring = token.substring(1);
            String message = substring + firstLetter + encodingWord;
            System.out.print(message + " ");
        }

    }
}
