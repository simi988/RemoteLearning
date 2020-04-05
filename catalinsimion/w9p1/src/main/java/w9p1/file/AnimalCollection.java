package w9p1.file;

import java.util.ArrayList;
import java.util.List;

public class AnimalCollection implements MyCollection<Animal> {
    List<Animal>animalList = new ArrayList<>();
    @Override
    public boolean containsAll(List<Animal> c) {

        return  animalList.containsAll(c);
    }

    @Override
    public boolean addAll(List<Animal> c) {

        return animalList.addAll(c);

    }
}
