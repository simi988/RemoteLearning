package w4p3.file;

import java.util.List;

public class Playlist {
    public List<Song> song;

    Playlist(List<Song> song) {
        this.song = song;
    }

    public List<Song> getTotalSong() {

        return song;
    }
}
