package w6p2.file;

@Logged
public class ObjectOne implements ObjectInterface {
    @Override
    public void printMessage(String message) {
        System.out.println(message + " object1");
    }

    @Override
    public int returnSum(int a, int b) {
        System.out.println(a + " " + b + " object1");
        return a + b;
    }
}