package w12p1.file;

import java.io.IOException;
import java.io.RandomAccessFile;

public class MyFile {

    public static int readFromFile(String filePath, int position, int size)
            throws IOException {
        RandomAccessFile file = new RandomAccessFile(filePath, "r");
        file.seek(position);
        byte[] bytes = new byte[size];
        int read = file.read(bytes);
        file.close();
        System.out.println(read);
        return read;
    }

    public static void writeToFile(String filePath, String data, int position)
            throws IOException {
        RandomAccessFile file = new RandomAccessFile(filePath, "rw");
        file.seek(position);
        file.write(data.getBytes());
        file.close();
    }
}



