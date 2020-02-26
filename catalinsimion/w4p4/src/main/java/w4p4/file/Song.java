package w4p4.file;

public class Song {
    Band band = new Band();
    String title;
    String author;

    Song(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void play() {
        System.out.println("band title " + author);
        System.out.println("play song " + title);
        band.member();

    }

}
