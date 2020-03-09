package w4p4.file;

public class Band {
    Playlist playlist = new Playlist();

    LeadGuitarist leadGuitarist;
    BassGuitarist bassGuitarist;
    RhythmGuitarist rhythmGuitarist;
    Drummer drummer;

    public void member() {
        System.out.println("they are members of the band and their role ");
        leadGuitarist = new LeadGuitarist("Mike");
        bassGuitarist = new BassGuitarist("Harvey");
        rhythmGuitarist = new RhythmGuitarist("Louis");
        drummer = new Drummer("Cameron");
    }
}
