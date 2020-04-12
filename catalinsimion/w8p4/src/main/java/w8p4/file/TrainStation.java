package w8p4.file;

import w8p3.file.Train;

import java.util.*;

public class TrainStation {
    private static final int NUMBER_MAX_OF_WAGONS = 20;
    private static final int NUMBER_MAX_OF_DAYS = 30;
    private static final int NUMBER_DAYS_OF_YEARS = 365;
    private static final int NUMBER_OF_TRAINS_GENERATED=10000;

    private HashMap<Train, List<Integer>> holdsTrain;

    public TrainStation() {
        holdsTrain = new HashMap<>();
    }

    public void initialize() {
        Random rand = new Random();
        String[] arr = {"IR", "R"};
        for (int i = 0; i < NUMBER_OF_TRAINS_GENERATED; i++) {
            String typeTrain = arr[rand.nextInt(arr.length)];
            int numberOfWagons = rand.nextInt(NUMBER_MAX_OF_WAGONS);
            List<Integer> dayList = getRunningDays(rand.nextInt(NUMBER_MAX_OF_DAYS));
            Train train = new Train(i, typeTrain, numberOfWagons);
            holdsTrain.put(train, dayList);
        }
    }

    private List<Integer> getRunningDays(int numberOfDays) {
        Random rand = new Random(1);
        List<Integer> dayList = new ArrayList<>();
        for (int i = 0; i < numberOfDays; i++) {
            int day = rand.nextInt(NUMBER_DAYS_OF_YEARS);
            if (!dayList.contains(day)) {
                dayList.add(day);
            }
        }
        return dayList;
    }

    public HashMap<Train, List<Integer>> getHoldsTrain() {
        return holdsTrain;
    }

    public void addTrain(Train train, List<Integer> dayList) {
        holdsTrain.put(train, dayList);
    }
}
