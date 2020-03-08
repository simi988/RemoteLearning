import w6p3.file.MyClassLoader;

public class ClassLoaderTest extends MyClassLoader {

    public static void main(String[] args) {

        MyClassLoader MyClassLoader = new MyClassLoader();
        MyClassLoader.invokeClassMethod("com.jcg.MyClass");

    }

}