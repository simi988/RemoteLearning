package w11p3.main;

import w11p3.file.ThreadRaceContext;
import w11p3.file.ThreadRelayRace;

public class Main {
    public static void main(String[] args){
        ThreadRelayRace threadRealyRace=new ThreadRelayRace();
        ThreadRaceContext threadRaceContext=new ThreadRaceContext();
        threadRealyRace.startRace(threadRaceContext);
        threadRaceContext.showScoreBord();


    }
}
