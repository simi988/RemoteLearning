package w4p4.file;

import java.util.ArrayList;
import java.util.List;

public class Band {
List<Song>songs=new ArrayList<>();
	public void member() {
		System.out.println("they are members of the band and their role ");
		LeadGuitarist leadGuitarist = new LeadGuitarist("Mike");
		BassGuitarist bassGuitarist = new BassGuitarist("Harvey");
		RhythmGuitarist rhythmGuitarist = new RhythmGuitarist("Louis");
		Drummer drummer = new Drummer("Cameron");

	}

}
