package w6p3.main;

import w6p3.file.Factory;
import w6p3.file.MyClass;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Factory factory = new Factory();
        MyClass myClassObject = factory.getMyClassObject();
        System.out.println("Loded class: " + myClassObject.getName());
        Class classDinamic = factory.getClassDinamic();
        System.out.println("Reloded class: " + classDinamic.getName());

        Object newInstance = classDinamic.getDeclaredConstructor().newInstance();
        myClassObject = (MyClass) newInstance;
    }
}
