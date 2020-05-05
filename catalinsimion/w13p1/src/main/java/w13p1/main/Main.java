package w13p1.main;

import w13p1.file.MyFile;

import java.io.File;

public class Main {
    public static void main(String[] args) {
            MyFile myFile= new MyFile();
            File file = new File("catalinsimion/w13p1/src/main/resources/");
            myFile.readAnonymous(file);
            myFile.readLambda(file);
        }
    }

