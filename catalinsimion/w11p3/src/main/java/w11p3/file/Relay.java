package w11p3.file;

import java.util.concurrent.Semaphore;

public class Relay {
    private Semaphore mutex = new Semaphore(1);

    public void grabStick() {
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void giveStick() {
        mutex.release();
    }

    public boolean isStickFree() {
        return mutex.availablePermits() > 0;
    }
}
