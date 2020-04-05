package w6p3.file;

public class Factory {

    public static MyClass createObject(ObjectType objectType) {
        switch (objectType) {
            case LOADED:
                return new MyClass();
            case RELOADED:
                return (MyClass) createObject(objectType.getClassPath(),ObjectType.RELOADED);
            case SUBCLASS:
                return (MyClass) createObject(objectType.getClassPath(),ObjectType.SUBCLASS);
        }
        throw new IllegalArgumentException("Unknon object type");
    }



    public static Object createObject(String className,ObjectType objectType) {
        ClassLoader parentClassLoader = MyClassLoader.class.getClassLoader();
        MyClassLoader myClassLoader = new MyClassLoader(parentClassLoader,objectType);

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


}
