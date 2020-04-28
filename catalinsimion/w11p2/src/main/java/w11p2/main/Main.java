package w11p2.main;

import w11p2.file.ThreadRace;
import w11p2.file.ThreadRaceContext;

public class Main {

    public static void main(String[] args) {

        ThreadRace threadRace = new ThreadRace();
        ThreadRaceContext threadRaceContext = new ThreadRaceContext();
        threadRace.startRace(threadRaceContext);
        threadRaceContext.showScoreBord();

    }
}
