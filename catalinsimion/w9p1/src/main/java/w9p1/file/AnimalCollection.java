package w9p1.file;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AnimalCollection<T> implements MyCollection<T> {
    List<T>animalList = new ArrayList<>();

    @Override
    public boolean containsAll(Collection<T> c) {
        return animalList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<T> c) {
        return animalList.addAll(c);
    }
}
