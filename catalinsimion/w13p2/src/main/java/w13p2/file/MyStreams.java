package w13p2.file;

import java.util.Iterator;
import java.util.stream.Stream;

public class MyStreams {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> secondIterator = second.iterator();
        Stream.Builder<T> streamBuilder = Stream.builder();
        first.forEach((element) ->{
            if(secondIterator.hasNext()){
                streamBuilder.accept(element);
                streamBuilder.accept(secondIterator.next());
            } else {
                first.close();
            }
        });
        return streamBuilder.build();
    }


}
