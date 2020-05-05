package w12p1.file;

import java.io.IOException;
import java.io.RandomAccessFile;

public class MyFile {

    public static int readFromFile(String filePath, int position)
            throws IOException {
        RandomAccessFile file = new RandomAccessFile(filePath, "r");
        file.seek(position);

        int read = file.readInt();
        file.close();
        System.out.println(read);
        return read;
    }

    public static void writeToFile(String filePath, int data, int position)
            throws IOException {
        RandomAccessFile file = new RandomAccessFile(filePath, "rw");
        file.seek(position);
        file.writeInt(data);
        file.close();
    }
}



