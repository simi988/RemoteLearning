package w5p3.file;

import java.util.ArrayList;
import java.util.List;

public class History {
    public static final int GENERATE_MAX_NUMBER = 20;
    RandomNumber randomNumber = new RandomNumber();
    List<String> historyList = new ArrayList<>();

    public void historic() {
        for (int i = 0; i < GENERATE_MAX_NUMBER; i++) {
            historyList.add((randomNumber.sentence()));
        }
    }


    public void story() {
        System.out.println("______historyList______");
        for (String story : historyList) {
            System.out.println(story);
        }


    }
}
