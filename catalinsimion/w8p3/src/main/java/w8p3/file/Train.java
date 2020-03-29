package w8p3.file;

import java.util.Objects;

public class Train {
    private int numberTrain;
    private String type;
    private int numberOfWagons;

    public Train(int numberTrain, String type, int numberOfWagons){
        this.numberTrain=numberTrain;
        this.type=type;
        this.numberOfWagons=numberOfWagons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return numberTrain == train.numberTrain &&
                numberOfWagons == train.numberOfWagons &&
                Objects.equals(type, train.type);
    }

    @Override
    public int hashCode() {
       // return Objects.hash(numberTrain, type, numberOfWagons);
        int hash = 7;
        hash = 31 * hash +  numberTrain;
        hash = 31 * hash + (type == null ? 0 : type.hashCode());
        hash = 31 * hash +  numberOfWagons ;
        return hash;
    }

    public int getNumberTrain() {
        return numberTrain;
    }

    public String getType() {
        return type;
    }

    public int getNumberOfWagons() {
        return numberOfWagons;
    }


}
