package w12p3.main;


import w12p3.file.Latin;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class Main {
    public static final Charset utf8charset = Charset.forName("UTF-8");
    public static final Charset latin1charset = Charset.forName("ISO-8859-1");

    public static void main(String[] args) throws IOException {
        File fileLatin = new File(Main.class.getClassLoader().getResource("file.txt").getFile());
        File fileUtf = new File(Main.class.getClassLoader().getResource("utfFile.txt").getFile());
        Latin latin = new Latin();
        latin.write(fileLatin, latin1charset, utf8charset);
        latin.write(fileUtf, utf8charset, latin1charset);
        System.out.println();

    }
}
