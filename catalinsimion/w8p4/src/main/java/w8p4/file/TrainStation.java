package w8p4.file;

import w8p3.file.Train;

import java.util.*;

public class TrainStation {



    private   HashMap<Train, List<Integer>> holdsTrain;
  public TrainStation(){
       holdsTrain=new HashMap<>();
   }

   public void initialize() {
       Random rand = new Random();
       String[] arr = {"IR", "R"};
        for (int i = 0; i < 10000; i++) {

            String typeTrain =arr[ rand.nextInt(arr.length)];
            int numberOfWagons = rand.nextInt(20);
            List<Integer> dayList = getRunningDays(rand.nextInt(30));
            Train train = new Train(i, typeTrain, numberOfWagons);
            holdsTrain.put(train, dayList);
        }
    }

    private List<Integer> getRunningDays(int numberOfDays) {
        Random rand = new Random(1);
        List<Integer> dayList = new ArrayList<>();
        for (int i = 0; i <numberOfDays ; i++) {
            int day = rand.nextInt(365);
            dayList.add(day);

        }
        return dayList;
    }

    public HashMap<Train, List<Integer>> getHoldsTrain() {
        return holdsTrain;
    }

    public void addTrain(Train train, List<Integer> dayList) {
      holdsTrain.put(train,dayList);
    }
}
