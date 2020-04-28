package w12p1.main;

import w12p1.file.MyFile;

import java.io.IOException;

public class Main {
    private static final String FILEPATH = "myFile.txt";

    public static void main(String[] args) throws IOException {

        MyFile myFile = new MyFile();

        myFile.writeToFile(FILEPATH, "1", 4);
        myFile.writeToFile(FILEPATH, "2", 3);
        myFile.writeToFile(FILEPATH, "3", 2);
        myFile.writeToFile(FILEPATH, "4", 1);
        myFile.readFromFile(FILEPATH, 3, 3);
        myFile.readFromFile(FILEPATH, 4, 3);
    }
}
