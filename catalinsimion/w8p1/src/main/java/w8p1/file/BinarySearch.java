package w8p1.file;

import java.util.Collections;
import java.util.List;

public class BinarySearch {
    SortByCapital sortByCapital = new SortByCapital();

    public String binarySearchCapital(List<Country> countryArrayList, String capitalSearch) {

        Collections.binarySearch(countryArrayList, new Country(null, capitalSearch), sortByCapital);

        return capitalSearch;
    }
}