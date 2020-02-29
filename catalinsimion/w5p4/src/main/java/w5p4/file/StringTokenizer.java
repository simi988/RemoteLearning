package w5p4.file;

import java.util.Scanner;

public class StringTokenizer {
    public void printLatinWord() {
        String word = "ay";
        System.out.print("Enter a string : ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        String[] tokens = inputString.split(" ");
        for (String t : tokens) {
            char ch1 = t.charAt(0);
            String ch2 = t.substring(1);
            String message = ch2 + ch1 + word;
            System.out.print(message + " ");
        }

    }
}
