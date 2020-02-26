package w4p4.file;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
	Playlist playlist = new Playlist();
	List<Playlist>playlists=new ArrayList<>();
	public void playlistPlay() {
		playlists.add(playlist);
		playlist.songPlay();
	}
	public MusicPlayer(String OS) {

	}

	

}
