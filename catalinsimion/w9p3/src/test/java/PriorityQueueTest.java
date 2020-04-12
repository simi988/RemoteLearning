import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import w9p3.file.PriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PriorityQueueTest {
    public static class IntegerComparator implements Comparator<Integer> {
        public int compare(Integer i1, Integer i2) {
            return i1.compareTo(i2);
        }
    }


    @Test
    public void insertWithIntegerComparatorTest() throws Exception {
        PriorityQueue<Integer> integerPriorityQueue = createPriorityQueue(new IntegerComparator());
        assertEquals(4, integerPriorityQueue.size());
        assertEquals(Integer.valueOf(9), integerPriorityQueue.head());
    }

    @Test
    public void insertWithoutIntegerComparatorTest() throws Exception {
        PriorityQueue<Integer> integerPriorityQueue = createPriorityQueue(null);
        assertEquals(4, integerPriorityQueue.size());
        assertEquals(Integer.valueOf(9), integerPriorityQueue.head());
    }
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();
    @Test
    public void insertOverflowValue() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("Overflow");
        PriorityQueue<Integer> integerPriorityQueue = createPriorityQueue(new IntegerComparator());
        integerPriorityQueue.insert(6);

    }

    private PriorityQueue<Integer> createPriorityQueue(Comparator comparator) throws Exception {
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>(4);
        integerPriorityQueue.setComparator(comparator);
        integerPriorityQueue.insert(5);
        integerPriorityQueue.insert(4);
        integerPriorityQueue.insert(7);
        integerPriorityQueue.insert(9);
        return integerPriorityQueue;
    }

    @Test
    public void removeTest() throws Exception {
        PriorityQueue<Integer> integerPriorityQueue = createPriorityQueue(null);
        integerPriorityQueue.remove();
        assertEquals(3, integerPriorityQueue.size());
    }

    @Test
    public void clearTest() throws Exception {
        PriorityQueue<Integer> integerPriorityQueue = createPriorityQueue(null);
        integerPriorityQueue.clear();
        assertEquals(0, integerPriorityQueue.size());
    }

    @Test
    public void headTest() throws Exception {
        PriorityQueue<Integer> integerPriorityQueue = createPriorityQueue(new IntegerComparator());
        assertEquals(Integer.valueOf(9), integerPriorityQueue.head());
    }

    @Test
    public void sortTest() throws Exception {
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>();
        List<Integer> list = Arrays.asList(1, 7, 4, 2, 9, 6, 5, 8, 3);
        List<Integer> expectedList = Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1);
        List<Integer> sort = integerPriorityQueue.sort(list);
        assertEquals(9, sort.size());
        assertEquals(expectedList, sort);
    }

    @Test
    public void isEmptyTest() throws Exception {
        PriorityQueue<Integer> integerPriorityQueue = createPriorityQueue(null);
        assertFalse(integerPriorityQueue.isEmpty());
    }

    @Test
    public void maxSizeTest() throws Exception {
        PriorityQueue<Integer> integerPriorityQueue = createPriorityQueue(null);
        assertEquals(4, integerPriorityQueue.getMaxSize());
    }
    @Test
    public void defaultMaxSizeTest() throws Exception {
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>();
        assertEquals(10001, integerPriorityQueue.getMaxSize());
    }
@Test
    public void compareToNullTest(){
        PriorityQueue priorityQueue=new PriorityQueue();
        PriorityQueue priorityQueueTwo = null;
     assertEquals(-1, priorityQueue.compareTo(priorityQueueTwo));

}
    @Test
    public void compareToSizeTest() throws Exception {
        PriorityQueue priorityQueue=createPriorityQueue(null);
        PriorityQueue priorityQueueTwo =createPriorityQueue(null);
        priorityQueue.remove();
        assertEquals(-1, priorityQueue.compareTo(priorityQueueTwo));
    }
    @Test
    public void compareToHeadTest() throws Exception {
        PriorityQueue priorityQueue=createPriorityQueue(null);
        PriorityQueue priorityQueueTwo =createPriorityQueue(null);
        assertEquals(0, priorityQueue.compareTo(priorityQueueTwo));
    }
}
