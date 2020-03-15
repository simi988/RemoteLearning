package w6p2.main;

import w6p2.file.Factory;
import w6p2.file.ObjectInterface;

public class Main {


    public static void main(String[] args) {
        Factory factory = new Factory();
        ObjectInterface objectOne = factory.getObjectOne();
        objectOne.returnSum(4, 5);
        objectOne.printMessage("class an");
        ObjectInterface objectTwo = factory.getObjectTwo();
        objectTwo.returnSum(6, 7);
        objectTwo.printMessage("no an");
        ObjectInterface objectThree = factory.getObjectThree();
        objectThree.returnSum(8, 9);
        objectThree.printMessage("one met");
    }

}
