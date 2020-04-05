package w6p3.file;

public enum ObjectType {
    LOADED("MyClass.class","w6p3.file.MyClass"),
    RELOADED("MyClass.class","w6p3.file.MyClass"),
    SUBCLASS("MySubClass.class","w6p3.file.MySubClass");

    private  String classFileName;



    private  String classPath;

    ObjectType(String classFileName, String classPath) {
        this.classFileName=classFileName;
        this.classPath=classPath;
    }
    public String getClassFileName() {
        return classFileName;
    }

    public String getClassPath() {
        return classPath;
    }
}