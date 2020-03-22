package w6p2.main;

import w6p2.file.Factory;
import w6p2.file.ObjectInterface;

public class Main {


    public static void main(String[] args) {
        Factory factory = new Factory();
        ObjectInterface objectOne = factory.getObjectOne();

        objectOne.printMessage("class annotation");
        ObjectInterface objectTwo = factory.getObjectTwo();

        objectTwo.printMessage("no annotation");
        ObjectInterface objectThree = factory.getObjectThree();

        objectThree.printMessage("method anotaation");
    }
}