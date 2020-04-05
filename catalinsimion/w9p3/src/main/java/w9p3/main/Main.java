package w9p3.main;


import w9p3.file.PriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static class IntegerComparator implements Comparator<Integer> {
        public int compare(Integer i1, Integer i2)
        {
            return i1.compareTo(i2);
        }
    }
    public static void main(String[] args) throws Exception {
        PriorityQueue<Integer> priorityQueueOne = new PriorityQueue<Integer>(5);
        priorityQueueOne.insert(5);
        priorityQueueOne.insert(4);
        priorityQueueOne.insert(7);
        priorityQueueOne.insert(2);
        System.out.println(priorityQueueOne.remove());
        System.out.println(priorityQueueOne.head());
        System.out.println();
        PriorityQueue<Integer> priorityQueueTwo = new PriorityQueue<Integer>(5);
        priorityQueueTwo.setComparator(new IntegerComparator());
        priorityQueueTwo.insert(5);
        priorityQueueTwo.insert(4);
        priorityQueueTwo.insert(7);
        priorityQueueTwo.insert(2);
        System.out.println(priorityQueueTwo.remove());
        System.out.println(priorityQueueTwo.head());

        List<Integer> list= Arrays.asList(5,6,3,4,8);
        List<Integer> sortedList = priorityQueueTwo.sort(list);

        System.out.println(sortedList);
        

    }
}
