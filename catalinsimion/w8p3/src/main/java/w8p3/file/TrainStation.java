package w8p3.file;

import java.util.HashSet;
import java.util.Set;

public class TrainStation {


    Set<Train> trainSet;

    public TrainStation() {
        trainSet = new HashSet<>();
    }

    public void addTrain(Train train) {

        trainSet.add(train);

    }

    public Set<Train> getTrainSet() {
        return trainSet;
    }
}
