package w11p3.file;

import java.util.ArrayList;
import java.util.List;

public class ThreadRelayRace {
    public List<ThreadRelayRaceTeam> createTeams(ThreadRaceContext threadRaceContext){
        List<ThreadRelayRaceTeam> list=new ArrayList<>();

        for(Integer i=0;i<10;i++) {
            ThreadRelayRaceTeam teams = new ThreadRelayRaceTeam(i,threadRaceContext,i.toString());
            List<ThreadRaceCompetitor> competitors = teams.createTeam(threadRaceContext);
            list.add(teams);
   }

   return list;
    }
    public void startRace(ThreadRaceContext threadRaceContext){

        List<ThreadRelayRaceTeam> teams = createTeams(threadRaceContext);
        run(teams);
    }
    public void run(List<ThreadRelayRaceTeam> teams) {
        for (ThreadRelayRaceTeam team:teams ) {
            team.start();
        }

    }
}