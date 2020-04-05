package w9p1.file;

import java.util.List;

public interface MyCollection<T> {
    public boolean containsAll(List<T> c);

    public boolean addAll(List<T> c);

}
