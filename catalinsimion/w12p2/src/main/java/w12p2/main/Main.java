package w12p2.main;

import w12p2.file.MyFile;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MyFile myFile = new MyFile();
        myFile.readFile();
        myFile.compressFile();
    }
}
