package w8p1.file;

import java.util.Collections;
import java.util.List;

public class BinarySearch {
    ComparableCapital sortByCapital = new ComparableCapital();

    public String binarySearchCapital(List<Country> countryArrayList, String capitalSearch) {

        Collections.binarySearch(countryArrayList, new Country("", capitalSearch), sortByCapital);

        return capitalSearch;
    }
}