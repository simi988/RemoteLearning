package w11p2.file;

import java.util.ArrayList;
import java.util.List;

public class ThreadRaceContext {
    List<ThreadRaceCompetitor> threadRaceCompetitors = new ArrayList<>();

    public synchronized void keepScore(ThreadRaceCompetitor competitor) {
        threadRaceCompetitors.add(competitor);
    }

    public synchronized void showScoreBord() {

        for (ThreadRaceCompetitor competitor : threadRaceCompetitors) {
            System.out.println(competitor.getId());
        }

    }
}
