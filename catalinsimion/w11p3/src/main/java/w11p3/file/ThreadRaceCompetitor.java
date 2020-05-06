package w11p3.file;

import java.util.concurrent.CountDownLatch;

public class ThreadRaceCompetitor extends Thread {
    private ThreadRaceContext threadRaceContext;
    private CountDownLatch latch;
    private Relay relay;
    private final int id;

    public ThreadRaceCompetitor(int id, ThreadRaceContext threadRaceContext, CountDownLatch latch, Relay relay) {
        this.id = id;
        this.threadRaceContext = threadRaceContext;
        this.latch = latch;
        this.relay = relay;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void run() {

        synchronized (relay) {
            if (!relay.isStickFree()) {
                try {
                    relay.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {

                relay.grabStick();
                System.out.println("The competitor " + id + " got the stick!");
                relay.giveStick();

                System.out.println("The competitor " + id + " has passed the stick!");


                relay.notifyAll();
                threadRaceContext.keepScoreCompetitor(this);
                latch.countDown();
            }
        }

    }
}
