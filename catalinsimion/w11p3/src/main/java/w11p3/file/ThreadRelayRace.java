package w11p3.file;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ThreadRelayRace {

    private static final int NUMBER_OF_TEAMS = 10;
    private static final int NUMBER_OF_COMPETITORS = 4;
    private CountDownLatch latchTeam = new CountDownLatch(NUMBER_OF_TEAMS);
    ThreadRaceContext threadRaceContext = new ThreadRaceContext();

    public void startRace() {
        List<ThreadRelayRaceTeam> teams = createTeam(threadRaceContext);
        run(teams);

    }

    public void run(List<ThreadRelayRaceTeam> teams) {
        for (ThreadRelayRaceTeam team : teams) {
            team.start();
        }
        try {
            latchTeam.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        threadRaceContext.showScoreBord();
    }

    private List<ThreadRelayRaceTeam> createTeam(ThreadRaceContext threadRaceContext) {
        List<ThreadRelayRaceTeam> teamList = new ArrayList<>();
        for (Integer i = 0; i < NUMBER_OF_TEAMS; i++) {
            CountDownLatch latch = new CountDownLatch(NUMBER_OF_COMPETITORS);
            List<ThreadRaceCompetitor> teamsMember = createCompetitors(threadRaceContext, latch);
            ThreadRelayRaceTeam team = new ThreadRelayRaceTeam(teamsMember, threadRaceContext, i.toString(), latch, latchTeam);

            teamList.add(team);
        }
        return teamList;
    }

    private List<ThreadRaceCompetitor> createCompetitors(ThreadRaceContext threadRaceContext, CountDownLatch latch) {
        List<ThreadRaceCompetitor> list = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_COMPETITORS; i++) {
            ThreadRaceCompetitor competitor = new ThreadRaceCompetitor(i, threadRaceContext, latch);
            list.add(competitor);
        }
        return list;
    }
}