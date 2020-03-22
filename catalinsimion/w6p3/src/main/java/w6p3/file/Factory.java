package w6p3.file;

public class Factory {

    public static MyClass createObject(ObjectType objectType) {
        switch (objectType) {
            case LOADED:
                return new MyClass();
            case RELOADED:
                return (MyClass) createObject("MyClass");
            case SUBCLASS:
                return (MyClass) createObject("MySubClass");
        }
        throw new IllegalArgumentException("Unknon object type");
    }

    public static Object createObject(String className) {
        ClassLoader parentClassLoader = MyClassLoader.class.getClassLoader();
        MyClassLoader myClassLoader = new MyClassLoader(parentClassLoader);

        try {
            Class objectClass = myClassLoader.loadClassFromFile(className);
            Object obj = objectClass.newInstance();

            return obj;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return myClassLoader;
    }

    public enum ObjectType {
        LOADED, RELOADED, SUBCLASS
    }
}
