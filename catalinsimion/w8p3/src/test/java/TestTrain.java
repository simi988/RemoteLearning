import org.junit.Test;
import w8p3.file.Train;
import w8p3.file.TrainStation;

import static org.junit.Assert.assertEquals;

public class TestTrain {
    @Test
    public void testEquals() {
        TrainStation trainStation=new TrainStation();
        trainStation.addTrain( new Train(123,"IR",5));
        trainStation.addTrain( new Train(124,"IR",5));
        trainStation.addTrain( new Train(123,"R",6));
        trainStation.addTrain( new Train(123,"IR",5));
        assertEquals(3,trainStation.getTrainSet().size());
    }
}
