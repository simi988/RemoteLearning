package w6p3.file;

public class Factory {
    public MyClass getMyClassObject() {

        return new MyClass();
    }

    public Class getClassDinamic() throws ClassNotFoundException {
        MyClassLoader myClassLoader = new MyClassLoader();
        return myClassLoader.findClass("w6p3.file.MySubClass");

    }
}
