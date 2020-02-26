package w5p3.file;

import java.util.ArrayList;
import java.util.List;

public class History {
    public static final int generate = 20;
    RandomNumber randomNumber = new RandomNumber();
    List<String> historyList = new ArrayList<>();

    public void historic() {
        for (int i = 0; i < generate; i++) {
            historyList.add((randomNumber.sentence()));
        }
    }

    @Override
    public String toString() {
        return "historyList=" + historyList;

    }
}
