package w4p4.main;


import w4p4.file.CDPlayer;
import w4p4.file.IPod;


public class Main {
    public static void main(String[] args) {
        System.out.println("Play iPop");
        IPod ipod = new IPod("iOS 7.1.2");
        ipod.playListPlay();
        ipod.playSongList();
        System.out.println();
        System.out.println();
        System.out.println("Play CdPlayer");
        CDPlayer cdplayer = new CDPlayer("Android 8.0");
        cdplayer.playListPlay();
        cdplayer.playSongList();

    }
}
