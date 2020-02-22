package w2p2.main;

import w2p2.file.Tank;

public class Main {
    public static void main(String[] args) {
        Tank tank = new Tank();

        tank.finalize();


        for (int i = 0; i < 15; i++) {
            tank.push(3);
        }
        for (int i = 0; i < 15; i++) {
            tank.pop();

        }

        System.gc();
    }
}
