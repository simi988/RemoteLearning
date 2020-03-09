package w4p4.file;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    List<Song> songs = new ArrayList<>();

    public void songPlay() {
        for (Song song : songs) {
            System.out.println(song);

        }

    }

}
