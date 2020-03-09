package w6p3.main;

import w6p3.file.MyClass;
import w6p3.file.MyClassLoader;

public class Main {
    public static void main(String[] args) {

        MyClass myClass = new MyClass();
        System.out.println("Loded class: " + myClass.getName());
        MyClassLoader myClassLoader = new MyClassLoader();
        MyClass myClass2 = (MyClass) myClassLoader.invokeClassMethod("w6p3.file.MyClass");
        System.out.println("Reloded class: " + myClass2.getName());
    }
}
