package w12p2.file;

import java.io.*;
import java.util.zip.GZIPOutputStream;

public class MyFile {
    static final String OUTPUT_FILE = "file.gz";
    File INPUT_FILE = new File(MyFile.class.getClassLoader().getResource("file.txt").getFile());

    private long compressRatio = 0;

    public MyFile() throws IOException {
    }

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

    public void compressFile() throws IOException {
        {
            GZIPOutputStream os =
                    new GZIPOutputStream(new FileOutputStream(OUTPUT_FILE));

            FileInputStream in =
                    new FileInputStream(INPUT_FILE);
            File out = new File(OUTPUT_FILE);

            byte[] buffer = new byte[1024];
            try {
                int totalSize;
                while ((totalSize = in.read(buffer)) > 0) {
                    os.write(buffer, 0, totalSize);
                }
                System.out.println("File Successfully compressed");
                if (INPUT_FILE.exists() && out.exists()) {
                    compressRatio = (INPUT_FILE.length() / out.length());
                    System.out.println("ratio is " + compressRatio);
                }
                in.close();
                os.finish();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}