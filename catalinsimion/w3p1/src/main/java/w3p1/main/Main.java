package w3p1.main;


import w3p1.file.Person;

public class Main {
    public static void main(String[] args){

        Person person= new Person("Popescu Ion") {
            @Override
            String getBirthDate() {
                String birthday = "";
                return birthday;

            }

            @Override
            public void selfDescribe() {

            }
        }

        Person person1=new Person("Ionescu", "Mircea");
        System.out.println(person.toString());
        System.out.println(person1.toString());
    }
}
