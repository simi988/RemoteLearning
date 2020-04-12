package w9p1.file;

import java.util.Collection;

public interface MyCollection<T> {
    boolean containsAll(Collection<T> c);
    boolean addAll(Collection<T> c);
}
