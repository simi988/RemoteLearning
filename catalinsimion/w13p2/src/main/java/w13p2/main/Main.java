package w13p2.main;

import w13p2.file.MyStreams;

import java.util.Arrays;
import java.util.List;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {



        Stream<String> firstStream = Stream.of("Ion","Gicu","Dorel");
        Stream<String> secondStream = Stream.of("Laba","Grivei");
        MyStreams.zip(firstStream, secondStream).forEach(System.out::println);
    }
}
