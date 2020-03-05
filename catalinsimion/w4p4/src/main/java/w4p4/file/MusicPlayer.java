package w4p4.file;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
	List<Song>songList=new ArrayList<>();
	List<Playlist>playlists=new ArrayList<>();
	public MusicPlayer(String OS) {

	}

	public void playListPlay() {
		for (Playlist playlist : playlists) {
			System.out.println(playlist);
		}
	}
	public void playSongList(){
		for (Song song : songList) {
			System.out.println(song);
		}
	}


	

}
