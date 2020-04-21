package w11p3.file;

public class ThreadRaceCompetitor extends Thread  {
private ThreadRaceContext threadRaceContext;
    private final int id;

    public ThreadRaceCompetitor(int id,ThreadRaceContext threadRaceContext) {
        this.id=id;
       this.threadRaceContext=threadRaceContext;
    }

@Override
    public long getId() {
        return id;
    }
    @Override
    public void run(){
        threadRaceContext.keepScore(this);
    }
}
