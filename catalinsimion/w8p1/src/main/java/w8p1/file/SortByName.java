package w8p1.file;

import java.util.Comparator;

public class SortByName implements Comparator<Country> {

    public int compare(Country countryOne, Country countryTwo) {
        return countryOne.getName().compareTo(countryTwo.getName());
    }


}