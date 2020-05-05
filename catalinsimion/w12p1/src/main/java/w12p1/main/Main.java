package w12p1.main;

import w12p1.file.MyFile;

import java.io.IOException;

public class Main {
    private static final String FILEPATH = "myFile.txt";

    public static void main(String[] args) throws IOException {

        MyFile myFile = new MyFile();

        myFile.writeToFile(FILEPATH, 1 ,0);
        myFile.writeToFile(FILEPATH, 2, 4);
        myFile.writeToFile(FILEPATH, 3, 8);
        myFile.writeToFile(FILEPATH, 4, 12);
        myFile.readFromFile(FILEPATH, 8);
        myFile.readFromFile(FILEPATH, 12);
    }
}
