package w11p2.file;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ThreadRace {

    private static final int NUMBER_OF_COMPETITORS = 10;
    private CountDownLatch latch = new CountDownLatch(NUMBER_OF_COMPETITORS);

    public void startRace(ThreadRaceContext threadRaceContext) {
        List<ThreadRaceCompetitor> competitors = createCompetitors(threadRaceContext);
        run(competitors);
    }

    public void run(List<ThreadRaceCompetitor> competitors) {
        for (ThreadRaceCompetitor competitor : competitors) {
            competitor.start();
        }
        try {
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<ThreadRaceCompetitor> createCompetitors(ThreadRaceContext threadRaceContext) {
        List<ThreadRaceCompetitor> list = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_COMPETITORS; i++) {
            ThreadRaceCompetitor competitor = new ThreadRaceCompetitor(i, threadRaceContext, latch);
            list.add(competitor);
        }
        return list;
    }
}