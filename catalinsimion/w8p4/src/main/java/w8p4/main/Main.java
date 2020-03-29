package w8p4.main;


import w8p3.file.Train;
import w8p4.file.TrainStation;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        TrainStation trainStation = new TrainStation();
        trainStation.initialize();
        Train train = new Train(123, "R", 5);
        List<Integer> dayList = Arrays.asList(1, 2, 3);
        trainStation.addTrain(train, dayList);
        System.out.println(trainStation.getHoldsTrain().size());
        long start = System.currentTimeMillis();
        trainStation.getHoldsTrain().get(train);
        long finish = System.currentTimeMillis();
        System.out.println("time elapsed: " + (finish - start));
    }
}
