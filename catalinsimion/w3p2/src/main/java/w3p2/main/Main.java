package w3p2.main;

import w3p2.file.Amphibian;
import w3p2.file.Frog;

public class Main {

    public static void main(String[] args) {
        Frog frog = new Frog();
        frog.makeSound();
        frog.move();
        frog.eat();

        Amphibian amphibian = new Amphibian();
        amphibian.makeSound();
        amphibian.move();
        amphibian.eat();

        amphibian = (Amphibian) frog;
        amphibian.makeSound();
        amphibian.move();
        amphibian.eat();

    }

}
