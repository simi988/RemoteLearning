import org.junit.Test;
import w9p1.file.Animal;
import w9p1.file.AnimalCollection;
import w9p1.file.MyCollection;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CollectionTest {

    @Test
    public void addAllTest() {
        MyCollection<Animal> animalCollection = new AnimalCollection<>();
        List<Animal> animalList = createAnimalList();
        assertTrue(animalCollection.addAll(animalList));
    }

    @Test
    public void containsAllTest() {
        MyCollection<Animal> animalCollection = new AnimalCollection<>();
        List<Animal> animalList = createAnimalList();
        animalCollection.addAll(animalList);
        assertTrue(animalCollection.containsAll(animalList));
    }

    @Test
    public void notContainsAllTest() {
        MyCollection<Animal> animalCollection = new AnimalCollection<>();
        List<Animal> animalList = createAnimalList();
        assertTrue(!animalCollection.containsAll(animalList));
    }

    private List<Animal> createAnimalList() {
        List<Animal> animalList = new ArrayList<>();
        Animal dog = new Animal("Max", "Husky");
        Animal cat = new Animal("Tom", "Sfinx");
        animalList.add(dog);
        animalList.add(cat);
        return animalList;
    }
}

