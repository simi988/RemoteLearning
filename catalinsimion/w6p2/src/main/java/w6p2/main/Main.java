package w6p2.main;

import w6p2.file.Factory;
import w6p2.file.ObjectInterface;
import w6p2.file.ObjectType;

public class Main {



        public static void main(String[] args){
            ObjectInterface obj1 = Factory.getObject(ObjectType.OBJECT_ONE);
            ObjectInterface obj2 = Factory.getObject(ObjectType.OBJECT_TWO);
            ObjectInterface obj3 = Factory.getObject(ObjectType.OBJECT_THREE);

            obj1.printMessage("Message1");
            obj1.returnSum(1,3);
            obj2.printMessage("Message2");
            obj2.returnSum(1,3);
            obj3.printMessage("Message3");
            obj3.returnSum(1,3);
        }

}
