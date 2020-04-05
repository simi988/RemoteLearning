package w6p3.main;

import w6p3.file.Factory;
import w6p3.file.ObjectType;

public class Main {
    public static void main(String[] args){

        System.out.println(Factory.createObject(ObjectType.LOADED).getName());
        System.out.println(Factory.createObject(ObjectType.SUBCLASS).getName());

    }
}
