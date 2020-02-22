package w4p3.file;

import java.util.List;

public class Band {
    String name;
    public List<Playlist>playlists;
    public  List<Drummer> drummer;
    public List<Guitarist> guitarists;


    Band(String name,List<Playlist>playlists,List<Drummer> drummer,List<Guitarist> guitarists) {
        this.name=name;
        this.playlists = playlists;
        this.drummer=drummer;
        this.guitarists=guitarists;
    }

    public List<Playlist> getTotalPlaylist() {

        return playlists;
    }

    public List<Drummer> getDrummers() {
        return drummer;
    }
    public List<Guitarist> getGuitarists(){
        return guitarists;
    }
}
