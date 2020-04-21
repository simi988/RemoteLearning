package w9p1.file;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyArrayCollection<T> implements MyCollection<T> {
    List<T>list = new ArrayList<>();

    @Override
    public boolean containsAll(Collection<T> c) {
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<T> c) {
        return list.addAll(c);
    }
}
