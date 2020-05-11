package w13p1.file;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class MyFile {
    public List<String> readLambda(File dir) {
        File[] subDir = dir.listFiles(file -> file.isDirectory());
        System.out.println();
        List<String> myList=new ArrayList<>();
        for (File file : subDir) {
            System.out.println(file.getName());
            myList.add(file.getName());

        }
        return myList;
    }

    public List<String> readAnonymous(File dir) {
        File[] subDir = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File dir) {
                return dir.isDirectory();
            }
        });
        System.out.println();
        List<String> myList=new ArrayList<>();
        for (File file : subDir) {
            System.out.println(file.getName());
            myList.add(file.getName());

        }
        return myList;
    }
}