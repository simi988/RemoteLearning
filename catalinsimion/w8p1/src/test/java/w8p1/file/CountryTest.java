package w8p1.file;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;


public class CountryTest {
    List<Country> countryArrayList;
    Country countryOne;
    Country countryTwo;
    Country countryThree;
    Country countryFour;

    @Before
    public void setUp() {
        countryArrayList = new ArrayList<>();
        countryOne =new Country("Romania", "Bucharest");
        countryTwo =(new Country("Uk", "London"));
        countryThree =(new Country("Italy", "Rome"));
        countryFour =(new Country("France", "Paris"));
        countryArrayList.add(countryOne);
        countryArrayList.add(countryTwo);
        countryArrayList.add(countryThree);
        countryArrayList.add(countryFour);

    }

    @Test
    public void testNameCountry() {

        List<Country> countrySorted = new ArrayList<>(countryArrayList);
        countrySorted.sort(Country::compareTo);
        assertThat(countrySorted, contains(countryFour, countryThree, countryOne, countryTwo));

    }

    @Test
    public void testCapitalCountry() {
        ComparableCapital sortByCapital = new ComparableCapital();
        List<Country> countrySorted = new ArrayList<>(countryArrayList);
        countrySorted.sort(sortByCapital);
        assertThat(countrySorted, contains(countryOne, countryTwo, countryFour, countryThree));
    }

    @Test
    public void testBinarySearch() {
        ComparableCapital sortByCapital = new ComparableCapital();
        List<Country> countrySorted = new ArrayList<>(countryArrayList);
        BinarySearch binarySearch = new BinarySearch();
        countrySorted.sort(sortByCapital);
        assertThat(binarySearch.binarySearchCapital(countrySorted, "Paris"), countrySorted.contains(countryFour));
    }
}
