import org.junit.Before;
import org.junit.Test;
import w8p1.file.BinarySearch;
import w8p1.file.Country;
import w8p1.file.SortByCapital;
import w8p1.file.SortByName;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ContryTest {
    List<Country> countryArrayList;

    @Before
    public void setUp() {
        countryArrayList = new ArrayList<>();
        countryArrayList.add(new Country("Romania", "Bucharest"));
        countryArrayList.add(new Country("Uk", "London"));
        countryArrayList.add(new Country("Italy", "Rome"));
        countryArrayList.add(new Country("France", "Paris"));
    }

    @Test
    public void testNameCountry() {
        SortByName sortByName = new SortByName();
        List<Country> countrySorted = new ArrayList<>(countryArrayList);
        countrySorted.sort(sortByName);
        assertEquals(countrySorted.get(0).getName(), "France");
        assertEquals(countrySorted.get(countrySorted.size() - 1).getName(), "Uk");
    }

    @Test
    public void testCapitalCountry() {
        SortByCapital sortByCapital = new SortByCapital();
        List<Country> countrySorted = new ArrayList<>(countryArrayList);
        countrySorted.sort(sortByCapital);
        assertEquals(countrySorted.get(0).getCapital(), "Bucharest");
        assertEquals(countrySorted.get(countrySorted.size() - 1).getCapital(), "Rome");
    }

    @Test
    public void testBinarySearch() {
        List<Country> countrySorted = new ArrayList<>(countryArrayList);
        BinarySearch binarySearch = new BinarySearch();
        binarySearch.binarySearchCapital(countrySorted, "Paris");
        assertEquals(binarySearch.binarySearchCapital(countrySorted, "Paris"), "France");
    }
}
