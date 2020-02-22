package w4p3.file;

import java.util.List;

public class CdPlayer {
    List<Playlist> playlist;
    List <Band> bandList;
   public CdPlayer(List<Playlist> playlist, List <Band> bandList) {
       this.playlist = playlist;
       this.bandList = bandList;
   }
}
