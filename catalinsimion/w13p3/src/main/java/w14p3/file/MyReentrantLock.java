package w14p3.file;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLock {
    public static void main(String[] args) {
        ReentrantLock myLock = new ReentrantLock();
        withLock(myLock, () -> {
            System.out.println("My first lock");
        });
    }

    public static void withLock(Lock myLock, Runnable action) {
        myLock.lock();
        try {
            action.run();
        } finally {
            myLock.unlock();
        }
    }
}
