package w9p3.file;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PriorityQueue<E extends Comparable<E>> implements Comparable<E> {

    private Comparator<E> comparator;
    private List<E> list = new ArrayList<>();
    private int maxSize;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public PriorityQueue() {
        maxSize = 10001;
    }

    public int getMaxSize() {
        return maxSize;
    }
    public void setComparator(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public void insert(E e) throws Exception {
        if (e == null) {
            throw new Exception("Element is null");
        }
        if (comparator == null) {
            comparator = new GenericComparator<E>();
        }
        if (size() < maxSize) {
            addElementAndSortList(e);
        } else {
            throw new Exception("Overflow");
        }
    }

    private void addElementAndSortList(E e) {
        list.add(e);
        if (size() > 1) {
            int position = size() - 1;
            E penultimateObject = list.get(position - 1);
            while (comparator.compare(e, penultimateObject) > 0 && position > 0) {
                list.set(position, penultimateObject);
                position = position - 1;
                list.set(position, e);
                if (position > 0) {
                    penultimateObject = list.get(position - 1);
                }
            }
        }
    }

    public E remove() {
        E head = head();
        list.remove(head());
        return head;
    }

    public void clear() {
        list.clear();
    }

    public E head() {
        return (E) list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public List<E> sort(List<E> list) throws Exception {
        List<E> sortedList = new ArrayList<>();
        PriorityQueue<E> priorityQueue = new PriorityQueue<>(list.size());
        if (comparator != null) {
            priorityQueue.setComparator(comparator);
        }
        for (int i = 0; i < list.size(); i++) {
            priorityQueue.insert(list.get(i));
        }
        while (priorityQueue.size() > 0) {
            sortedList.add(priorityQueue.remove());
        }
        return sortedList;
    }

    public int compareTo(PriorityQueue<E> priorityQueue) {
        if (priorityQueue == null) {
            return -1;
        } else if (this.size() != priorityQueue.size()) {
            return -1;
        }
        return compareTo(priorityQueue.head());
    }

    @Override
    public int compareTo(E o) {
        return this.head().compareTo(o);
    }


    private static class GenericComparator<E extends Comparable<E>> implements Comparator<E> {
        @Override
        public int compare(E t1, E t2) {
            return t1.compareTo(t2);
        }
    }
}
