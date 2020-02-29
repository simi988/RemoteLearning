package w5p1.file;

public interface List<T> {

    void add(T element) throws CustomException;

    T get(int positon) throws CustomException;

    boolean contains(T element) throws CustomException;

    boolean containsAll(List<T> foreignList) throws CustomException;

    int size();
}
