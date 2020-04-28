package w12p3.main;

import w12p3.file.Latin;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File fileLatin = new File(Main.class.getClassLoader().getResource("file.txt").getFile());
        File fileUtf = new File(Main.class.getClassLoader().getResource("utfFile.txt").getFile());
        Latin latin = new Latin();
        latin.writeLatin(fileLatin);
        System.out.println();
        latin.writeUtf(fileUtf);
    }
}
