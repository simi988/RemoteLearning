package w9p2.main;

import w9p2.file.SortManager;

public class Main {
    public static void main(String[] args) {
        String[] arrayOfStrings = {"A", "C", "B", "D"};
        SortManager<String> stringSortManager = new SortManager<>();
        stringSortManager.bubbleSort(arrayOfStrings);
        Integer[] arrayOfIntegers = {1, 6, 3, 8, 2, 9, 7, 4, 5};
        SortManager<Integer> integerSortManager = new SortManager<>();
        integerSortManager.bubbleSort(arrayOfIntegers);
    }
}
