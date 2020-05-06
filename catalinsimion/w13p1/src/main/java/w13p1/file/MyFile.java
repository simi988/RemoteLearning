package w13p1.file;

import java.io.File;
import java.io.FileFilter;

public class MyFile {
    public void readLambda(File dir) {
        File[] subDir = dir.listFiles(file -> file.isDirectory());
        System.out.println();
        System.out.println("-----Lambda-----");
        for (File file : subDir) {
            System.out.println(file.getName());
        }
    }

    public void readAnonymous(File dir) {
        File[] subDir = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File dir) {
                return dir.isDirectory();
            }
        });
        System.out.println();
        System.out.println("-----Anonymous-----");
        for (File file : subDir) {
            System.out.println(file.getName());
        }
    }
}