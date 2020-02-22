package w3p1.main;

import w3p1.file.English;
import w3p1.file.Person;
import w3p1.file.Romanian;


public class Main {
    public static void main(String[] args) {
        Person person = new Romanian("Popescu ", "Ion", "20.12.2000");

        System.out.println( person.selfDescribe("Ponescu" , "Ion", "20.12.2000"));


        Person person1 = new English("Smith ", "John", "20.02.2000");
        System.out.println(person1.selfDescribe("Smith", "Michel", "20.02.2000"));


        Person person2 = new English("Smith Michel", "12.02.1980");
        System.out.println(person2.selfDescribe("Smith Michel", "12.02.1980"));


        Person person3 = new Romanian("Ionescu Fane", "20.10.2006");
        System.out.println(person3.selfDescribe("Ionescu Fane", "20.10.2006"));

    }
}
