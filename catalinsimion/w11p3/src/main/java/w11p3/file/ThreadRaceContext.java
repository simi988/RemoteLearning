package w11p3.file;

import java.util.ArrayList;
import java.util.List;

public class ThreadRaceContext {
    List<ThreadRaceCompetitor> threadRaceCompetitors = new ArrayList<>();
    List<ThreadRelayRaceTeam> threadRelayRaceTeams = new ArrayList<>();

    public synchronized void keepScoreCompetitor(ThreadRaceCompetitor competitor) {
        threadRaceCompetitors.add(competitor);

    }

    public synchronized void keepScoreTeam(ThreadRelayRaceTeam team) {
        threadRelayRaceTeams.add(team);

    }

    public synchronized void showScoreBord() {
        for (ThreadRelayRaceTeam team : threadRelayRaceTeams) {
            System.out.println(team.getName());
        }

    }
}
