package w11p1.main;

import w11p1.file.Client;

public class Main {
    public static void main(String[] args) {

        Thread clientOne = new Thread(new Client("1"));
        Thread clientTwo = new Thread(new Client("2"));
        Thread clientThree = new Thread(new Client("3"));
        Thread clientFour = new Thread(new Client("4"));
        Thread clientFive = new Thread(new Client("5"));
        Thread clientSix = new Thread(new Client("6"));
        Thread clientSeven = new Thread(new Client("7"));
        Thread clientEight = new Thread(new Client("8"));
        Thread clientNine = new Thread(new Client("9"));
        Thread clientTen = new Thread(new Client("10"));
        Thread clientEleven = new Thread(new Client("11"));

        clientOne.start();
        clientTwo.start();
        clientThree.start();
        clientFour.start();
        clientFive.start();
        clientSix.start();
        clientSeven.start();
        clientEight.start();
        clientNine.start();
        clientTen.start();
        clientEleven.start();
    }
}
