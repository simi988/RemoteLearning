package w13p2.main;

import w13p2.file.MyStreams;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> firstStream = Stream.of("Ion", "Gicu", "Dorel");
        Stream<String> secondStream = Stream.of("Vasile", "Grivei");
        MyStreams.zip(firstStream, secondStream).forEach(System.out::println);
    }
}
