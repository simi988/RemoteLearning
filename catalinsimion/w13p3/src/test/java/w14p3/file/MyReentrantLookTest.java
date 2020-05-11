package w14p3.file;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLookTest {
    @Test
public void withLookTest(){
        MyReentrantLock myLock = new MyReentrantLock();
        ReentrantLock lock = new ReentrantLock();
        myLock.withLock(lock,()->{
            System.out.println("My first lock");
        });
    }
}
