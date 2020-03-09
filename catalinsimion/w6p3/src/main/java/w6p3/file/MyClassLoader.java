package w6p3.file;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class MyClassLoader extends ClassLoader {
    public Object invokeClassMethod(String classBinName) {

        try {
            File file = new File("D:\\IT\\IQRemoteLearning");
            URL url = file.toURI().toURL();
            URL[] urls = new URL[]{url};
            ClassLoader cl = new URLClassLoader(urls);
            Class cls = cl.loadClass(classBinName);
            return cls;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}