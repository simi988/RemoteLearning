package w12p3.file;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Latin {
    private static final Charset utf8charset = Charset.forName("UTF-8");
    private static final Charset latin1charset = Charset.forName("ISO-8859-1");

    public void writeLatin(File file) throws IOException {
        byte[] outputData = new byte[0];
        if (!file.exists()) {
            System.out.println("File does not exist");
            System.exit(0);
        } else {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                try {
                    String line = scanner.nextLine();
                    ByteBuffer inputBuffer = ByteBuffer.wrap(line.getBytes(utf8charset));
                    CharBuffer data = utf8charset.decode(inputBuffer);
                    ByteBuffer outputBuffer = latin1charset.encode(data);
                    outputData = outputBuffer.array();
                    System.out.println(new String(outputData, latin1charset));
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }
        }
    }

    public void writeUtf(File file) throws IOException {
        byte[] outputData = new byte[0];
        if (!file.exists()) {
            System.out.println("File does not exist");
            System.exit(0);
        } else {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                try {
                    String line = scanner.nextLine();
                    ByteBuffer inputBuffer = ByteBuffer.wrap(line.getBytes(latin1charset));
                    CharBuffer data = latin1charset.decode(inputBuffer);
                    ByteBuffer outputBuffer = utf8charset.encode(data);
                    outputData = outputBuffer.array();
                    System.out.println(new String(outputData, utf8charset));
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }
        }
    }
}

