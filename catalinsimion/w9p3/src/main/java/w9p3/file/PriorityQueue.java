package w9p3.file;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PriorityQueue<E> implements Comparable<E> {


    private Comparator<E> comparator;
    private List<E> list = new ArrayList<>();
    private int maxSize;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public PriorityQueue() {
        maxSize = 10001;
    }

    public void setComparator(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public void insert(E e) throws Exception {
        if (size() < maxSize) {
            list.add(e);
            if (comparator != null && size() > 1) {
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
        } else {
            throw new Exception("Overflow");
        }
    }

    public E remove() {
        E head = head();
        list.remove(head());
        return head;
    }

    public void clear() {
        list.removeAll(list);
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

    public boolean compareTo(PriorityQueue<E> priorityQueue) {
        if (priorityQueue == null) {
            return true;
        } else if (this.size() == priorityQueue.size()) {
            return this.head() == priorityQueue.head();
        }
        return false;
    }

    @Override
    public int compareTo(E o) {
        return 0;
    }
}
