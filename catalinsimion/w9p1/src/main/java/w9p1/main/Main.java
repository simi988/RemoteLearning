package w9p1.main;

import w9p1.file.Animal;
import w9p1.file.AnimalCollection;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Animal("Max", "Husky");
        Animal cat = new Animal("Tom", "Sfinx");
        AnimalCollection animalCollection = new AnimalCollection();
        List<Animal> animalList = new ArrayList<>();
        animalList.add(dog);
        animalList.add(cat);
        animalCollection.addAll(animalList);
        animalCollection.containsAll(animalList);

    }
}
