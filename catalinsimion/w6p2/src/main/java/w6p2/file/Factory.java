package w6p2.file;

import java.lang.reflect.Proxy;

public class Factory {

    public static ObjectInterface getObjectOne() {
        ObjectOne objectOne = new ObjectOne();
        return (ObjectInterface) Proxy.newProxyInstance(ObjectInterface.class.getClassLoader(), new Class[]{ObjectInterface.class},
                new AnnotationProcessor(objectOne));
    }

    public static ObjectInterface getObjectTwo() {
        ObjectTwo objectTwo = new ObjectTwo();
        return (ObjectInterface) Proxy.newProxyInstance(ObjectTwo.class.getClassLoader(), new Class[]{ObjectInterface.class},
                new AnnotationProcessor(objectTwo));
    }

    public static ObjectInterface getObjectThree() {
        ObjectThree objectThree = new ObjectThree();
        return (ObjectInterface) Proxy.newProxyInstance(ObjectThree.class.getClassLoader(), new Class[]{ObjectInterface.class},
                new AnnotationProcessor(objectThree));
    }
}