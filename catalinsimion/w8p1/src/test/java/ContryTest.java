import org.junit.Before;
        import org.junit.Test;
        import w8p1.file.BinarySearch;
        import w8p1.file.Country;
        import w8p1.file.ComparableCapital;

        import java.util.ArrayList;
        import java.util.List;

        import static org.hamcrest.MatcherAssert.assertThat;
        import static org.hamcrest.Matchers.containsInAnyOrder;


public class ContryTest {
    List<Country> countryArrayList;
    Country contryOne;
    Country contryTwo;
    Country contryThree;
    Country contryFour;

    @Before
    public void setUp() {
        countryArrayList = new ArrayList<>();
        contryOne=new Country("Romania", "Bucharest");
        contryTwo=(new Country("Uk", "London"));
        contryThree=(new Country("Italy", "Rome"));
        contryFour=(new Country("France", "Paris"));
        countryArrayList.add(contryOne);
        countryArrayList.add(contryTwo);
        countryArrayList.add(contryThree);
        countryArrayList.add(contryFour);

    }

    @Test
    public void testNameCountry() {

        List<Country> countrySorted = new ArrayList<>(countryArrayList);
        assertThat(countrySorted, containsInAnyOrder(contryOne,contryTwo,contryThree,contryFour));

    }

    @Test
    public void testCapitalCountry() {
        ComparableCapital sortByCapital = new ComparableCapital();
        List<Country> countrySorted = new ArrayList<>(countryArrayList);
        countrySorted.sort(sortByCapital);
        assertThat(countrySorted, containsInAnyOrder(contryOne,contryTwo,contryThree,contryFour));
    }

    @Test
    public void testBinarySearch() {
        ComparableCapital sortByCapital = new ComparableCapital();
        List<Country> countrySorted = new ArrayList<>(countryArrayList);
        BinarySearch binarySearch = new BinarySearch();
        countrySorted.sort(sortByCapital);
        assertThat(binarySearch.binarySearchCapital(countrySorted, "Paris"), countrySorted.contains(contryFour));
    }
}
