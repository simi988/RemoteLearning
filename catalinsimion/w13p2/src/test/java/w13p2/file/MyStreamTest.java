package w13p2.file;

import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class MyStreamTest {
    @Test
    public void zipTest(){
        Stream<String> firstStream = Stream.of("Ion", "Gicu", "Dorel");
        Stream<String> secondStream = Stream.of("Vasile", "Grivei");
        MyStreams myStreams=new MyStreams();
        Stream<String> zip = myStreams.zip(firstStream, secondStream);
        Stream<String>expectedStream=Stream.of("Ion","Vasile","Gicu","Grivei");
        assertEquals(4,zip.count());


    }
}
