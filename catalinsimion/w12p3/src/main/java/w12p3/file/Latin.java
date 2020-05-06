package w12p3.file;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Latin {
    public void write(File file, Charset input, Charset output) throws IOException {
        byte[] outputData;
        if (!file.exists()) {
            System.out.println("File does not exist");
            System.exit(0);
        } else {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                try {
                    String line = scanner.nextLine();
                    ByteBuffer inputBuffer = ByteBuffer.wrap(line.getBytes(input));
                    CharBuffer data = input.decode(inputBuffer);
                    ByteBuffer outputBuffer = output.encode(data);
                    outputData = outputBuffer.array();
                    System.out.println(new String(outputData, output));
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }
        }
    }
}

