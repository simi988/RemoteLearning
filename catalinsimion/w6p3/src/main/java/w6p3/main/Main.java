package w6p3.main;

import w6p3.file.Factory;

public class Main {
    public static void main(String[] args){

        System.out.println(Factory.createObject(Factory.ObjectType.LOADED).getName());
        System.out.println(Factory.createObject(Factory.ObjectType.SUBCLASS).getName());

    }
}
