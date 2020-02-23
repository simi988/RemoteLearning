package w4p4.file;

public class Band {

	public void member() {
		System.out.println("they are members of the band and their role ");
		LeadGuitarist leadGuitarist = new LeadGuitarist("Mike");
		BassGuitarist bassGuitarist = new BassGuitarist("Harvey");
		RhythmGuitarist rhythmGuitarist = new RhythmGuitarist("Louis");
		Drummer drummer = new Drummer("Cameron");

	}

}
