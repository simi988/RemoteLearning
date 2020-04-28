package w11p3.file;

import java.util.concurrent.CountDownLatch;

public class ThreadRaceCompetitor extends Thread {
    private ThreadRaceContext threadRaceContext;
    private CountDownLatch latch;

    private final int id;

    public ThreadRaceCompetitor(int id, ThreadRaceContext threadRaceContext, CountDownLatch latch) {
        this.id = id;
        this.threadRaceContext = threadRaceContext;
        this.latch = latch;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void run() {
        latch.countDown();
        try {
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        threadRaceContext.keepScoreCompetitor(this);
    }
}
