package w9p1.file;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class MyArrayCollectionTest {

    @Test
    public void addAllAnimalTest() {
        MyCollection<Animal> animalCollection = new MyArrayCollection<>();
        List<Animal> animalList = createAnimalList();
        assertTrue(animalCollection.addAll(animalList));

    }
    @Test
    public void addAllIntegerTest () {
        MyCollection<Integer> integerCollection = new MyArrayCollection<>();
        List<Integer>integerList=createIntegerList();
        assertTrue(integerCollection.addAll(integerList));
    }

    @Test
    public void  addAllStringTest() {
        MyCollection<String> stringCollection = new MyArrayCollection<>();
        List<String> stringList=createStringList();
        assertTrue(stringCollection.addAll(stringList));
    }

    @Test
    public void containsAllAnimalTest() {
        MyCollection<Animal> animalCollection = new MyArrayCollection<>();
        List<Animal> animalList = createAnimalList();
        animalCollection.addAll(animalList);
        assertTrue(animalCollection.containsAll(animalList));
    }

    @Test
    public void containsAllIntegerTest() {
        MyCollection<Integer> integerCollection = new MyArrayCollection<>();
        List<Integer>integerList=createIntegerList();
        integerCollection.addAll(integerList);
        assertTrue(integerCollection.containsAll(integerList));
    }

    @Test
    public void containsAllStringTest() {
        MyCollection<String> stringCollection = new MyArrayCollection<>();
        List<String> stringList=createStringList();
        stringCollection.addAll(stringList);
        assertTrue(stringCollection.containsAll(stringList));
    }

    @Test
    public void notContainsAllAnimalTest() {
        MyCollection<Animal> animalCollection = new MyArrayCollection<>();
        List<Animal> animalList = createAnimalList();
        assertTrue(!animalCollection.containsAll(animalList));
    }

    @Test
    public void notContainsAllIntegerTest() {
        MyCollection<Integer> integerCollection = new MyArrayCollection<>();
        List<Integer>integerList=createIntegerList();
        assertTrue(!integerCollection.containsAll(integerList));
    }
    @Test
    public void notContainsAllStringTest() {
        MyCollection<String> stringCollection = new MyArrayCollection<>();
        List<String> stringList=createStringList();
        assertTrue(!stringCollection.containsAll(stringList));
    }

    private List<Animal> createAnimalList() {
        List<Animal> animalList = new ArrayList<>();
        Animal dog = new Animal("Max", "Husky");
        Animal cat = new Animal("Tom", "Sfinx");
        animalList.add(dog);
        animalList.add(cat);
        return animalList;
    }
    private List<Integer> createIntegerList() {
        List<Integer>integerList=new ArrayList<>();
        integerList.add(4);
        integerList.add(2);
        return integerList;
    }

    private List<String> createStringList() {
        List<String>stringList=new ArrayList<>();
        String one="Michel";
        String two="Jon";
        stringList.add(one);
        stringList.add(two);
        return stringList;
    }
}

