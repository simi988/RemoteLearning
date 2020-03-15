package w6p2.file;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AnnotationProcessor implements InvocationHandler {
    private Object object;

    public AnnotationProcessor(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (isAnnotationOnClass() || isAnnotationOnMethod(method)) {
            printObjectInfo(proxy, method.getName(), args.toString());
        }
        return method.invoke(object, args);
    }

    protected boolean isAnnotationOnClass() {
        Class c = object.getClass();
        Annotation[] annotationsOnClass = c.getAnnotations();
        Annotation annotation = c.getAnnotation(Logged.class);
        if (annotation != null) {
            return true;
        }
        return false;
    }

    protected boolean isAnnotationOnMethod(Method method) {


        Annotation annotation = method.getAnnotation(Logged.class);
        if (annotation != null) {
            return true;
        }


        return false;
    }

    protected void printObjectInfo(Object object, String methodName, String parameters) {
        System.out.println("Class: " + object.getClass() + " method name: " + methodName + " parameters: " + parameters);
    }
}