package w5p4.file;

import java.util.Scanner;

public class StringTokenizer {
    public void read() {
        String word = "ay";
        System.out.print("Enter a string : ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        char ch1 = inputString.charAt(0);
        String ch2 = inputString.substring(1);
        String message = ch2 + ch1 + word;
        System.out.println(message);
    }
}
