package w12p2.file;

import java.io.*;
import java.util.zip.GZIPOutputStream;

public class MyFile {
    static final String OUTPUT_FILE = "file.gz";
    File INPUT_FILE = new File(MyFile.class.getClassLoader().getResource("file.txt").getFile());

    public void readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            System.out.println(everything);
        } finally {
            br.close();
        }
    }

    public void compressFile() {
        {
            byte[] buffer = new byte[1024];
            try {
                GZIPOutputStream os =
                        new GZIPOutputStream(new FileOutputStream(OUTPUT_FILE));

                FileInputStream in =
                        new FileInputStream(INPUT_FILE);

                int totalSize;
                while ((totalSize = in.read(buffer)) > 0) {
                    os.write(buffer, 0, totalSize);
                }

                in.close();
                os.finish();
                os.close();

                System.out.println("File Successfully compressed");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}


