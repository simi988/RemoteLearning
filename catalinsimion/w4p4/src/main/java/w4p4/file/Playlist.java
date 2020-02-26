package w4p4.file;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
	Song song = new Song("O mie de pahare "," White Mahala ");

	List<Song> songs=new ArrayList<>();

	public void songPlay() {
		songs.add(song);
		song.play();
	}

}
