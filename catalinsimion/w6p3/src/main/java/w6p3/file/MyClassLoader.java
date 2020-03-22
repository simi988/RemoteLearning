package w6p3.file;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    public Class loadClassFromFile(String className) {
        String classPath = className + ".class";
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(classPath);
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        byte[] buffer;
        int nextValue;
        try {
            while ((nextValue = inputStream.read()) != -1) {
                byteStream.write(nextValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = byteStream.toByteArray();
        return defineClass("w6p3.file." + className, buffer, 0, buffer.length);
    }

}