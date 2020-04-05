package w6p3.file;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {
  private ObjectType objectType;
    public MyClassLoader(ClassLoader parent, ObjectType objectType) {
        super(parent);
        this.objectType=objectType;
    }

    public Class loadClassFromFile(String className) {
       className=objectType.getClassFileName();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(className);
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
        return defineClass(objectType.getClassPath() , buffer, 0, buffer.length);
    }

}