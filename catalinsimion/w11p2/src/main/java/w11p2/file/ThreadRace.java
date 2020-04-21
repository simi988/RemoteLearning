package w11p2.file;

import java.util.ArrayList;
import java.util.List;

public class ThreadRace {
    public List<ThreadRaceCompetitor> createCompetitors(ThreadRaceContext threadRaceContext){
        List<ThreadRaceCompetitor> list=new ArrayList<>();
        for(int i=0;i<10;i++) {
         ThreadRaceCompetitor competitor=new ThreadRaceCompetitor(i,threadRaceContext);
      list.add(competitor);
   }
   return list;
    }
    public void startRace(ThreadRaceContext threadRaceContext){

        List<ThreadRaceCompetitor> competitors = createCompetitors(threadRaceContext);
        run(competitors);
    }
    public void run(List<ThreadRaceCompetitor> competitors) {
        for (ThreadRaceCompetitor competitor:competitors ) {
            competitor.start();
        }

    }
}