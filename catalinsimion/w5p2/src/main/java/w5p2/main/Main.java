package w5p2.main;

import w5p2.file.Read;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.print("Enter a string : ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        Read read=new Read();
        read.titlelize(inputString);
    }
}
