package w11p3.file;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ThreadRelayRaceTeam extends Thread {
    private CountDownLatch latchTeam;
    private List<ThreadRaceCompetitor> competitors;
    private ThreadRaceContext threadRaceContext;
    private String teamName;
    private CountDownLatch latchCompetitor;

    public ThreadRelayRaceTeam(List<ThreadRaceCompetitor> competitors, ThreadRaceContext threadRaceContext, String teamName,
                               CountDownLatch latchCompetitor, CountDownLatch latchTeam) {
        this.competitors = competitors;
        this.threadRaceContext = threadRaceContext;
        this.teamName = teamName;
        this.latchCompetitor = latchCompetitor;
        this.latchTeam = latchTeam;

    }

    @Override
    public void run() {

        for (ThreadRaceCompetitor competitor : competitors) {
            competitor.start();
        }
        try {
            latchCompetitor.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        latchTeam.countDown();
        threadRaceContext.keepScoreTeam(this);
    }
}
