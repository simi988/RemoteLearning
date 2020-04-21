package w11p3.file;

import java.util.ArrayList;
import java.util.List;

public class ThreadRelayRaceTeam extends Thread {
    private int id;
    private ThreadRaceContext threadRaceContext;
    private String teamName;

    public ThreadRelayRaceTeam(int id, ThreadRaceContext threadRaceContext,String teamName) {
        this.id=id;
        this.threadRaceContext=threadRaceContext;
        this.teamName=teamName;
    }
    public List<ThreadRaceCompetitor> createTeam(ThreadRaceContext threadRaceContext){
        List<ThreadRaceCompetitor> list=new ArrayList<>();
        for(int i=0;i<4;i++) {
            ThreadRaceCompetitor competitor=new ThreadRaceCompetitor(i,threadRaceContext);
            list.add(competitor);
        }
        return list;
    }
}
