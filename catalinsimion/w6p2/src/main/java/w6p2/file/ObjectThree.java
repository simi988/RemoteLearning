package w6p2.file;

public class ObjectThree implements ObjectInterface {
    @Logged
    @Override
    public void printMessage(String message) {
        System.out.println(message + " object3");
    }
}