import org.junit.Test;
import w9p2.file.SortManager;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SortTest {
    @Test
    public void sortStringTest() {
        String[] arrayOfStrings = {"A", "C", "B", "D"};
        String[] expectedOrder = {"A", "B", "C", "D"};
        SortManager<String> stringSortManager = new SortManager<>();
        stringSortManager.bubbleSort(arrayOfStrings);
        assertEquals(4, arrayOfStrings.length);
        assertArrayEquals(expectedOrder, arrayOfStrings);
    }

    @Test
    public void sortIntegerTest() {
        Integer[] arrayOfIntegers = {1, 6, 3, 8, 2, 9, 7, 4, 5};
        Integer[] expectedOrder = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        SortManager<Integer> integerSortManager = new SortManager<>();
        integerSortManager.bubbleSort(arrayOfIntegers);
        assertEquals(9, arrayOfIntegers.length);
        assertArrayEquals(expectedOrder, arrayOfIntegers);
    }
//
//    @Test
//    public void wrongTypeTest() {
//        String[] arrayOfStrings = {"A", "C", "B"};
//        SortManager<Integer> integerSortManager = new SortManager<>();
//        integerSortManager.bubbleSort(arrayOfStrings);
//    }
}
