package w11p3.file;

import java.util.ArrayList;
import java.util.List;

public class ThreadRaceContext {
    List<ThreadRaceCompetitor> threadRaceCompetitors=new ArrayList<>();
    public void keepScore(ThreadRaceCompetitor competitor){
        threadRaceCompetitors.add(competitor);
    }
    public void showScoreBord(){
        while(threadRaceCompetitors.size()<10) {

        }
            for (ThreadRaceCompetitor competitor : threadRaceCompetitors) {
                System.out.println(competitor.getId());
            }

    }
}
