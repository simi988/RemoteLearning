import org.junit.Test;
import w9p3.file.PriorityQueue;


import static org.junit.Assert.assertEquals;

public class PriorityQueueTest {
    @Test
    public void addTest() throws Exception {
        PriorityQueue<Integer> integerPriorityQueue=new PriorityQueue<>();
        integerPriorityQueue.insert(4);
        assertEquals(1,integerPriorityQueue.size());
    }
    @Test
    public void removeTest() throws Exception {
        PriorityQueue<Integer> integerPriorityQueue=new PriorityQueue<>();
       integerPriorityQueue.insert(5);
        integerPriorityQueue.remove();
        assertEquals(0,integerPriorityQueue.size());
    }
    @Test
    public void clearTest() throws Exception {
        PriorityQueue<Integer> integerPriorityQueue=new PriorityQueue<>();
        integerPriorityQueue.insert(7);
       integerPriorityQueue.insert(9);
        integerPriorityQueue.clear();
        assertEquals(0,integerPriorityQueue.size());
    }
    @Test
    public void headTest() throws Exception {
        PriorityQueue<Integer> integerPriorityQueue=new PriorityQueue<>();
        Integer integerOne=(5);
        Integer integerTwo=(3);
        integerPriorityQueue.insert(integerOne);
        integerPriorityQueue.insert(integerTwo);
        assertEquals(integerOne,integerPriorityQueue.head());
    }

}
