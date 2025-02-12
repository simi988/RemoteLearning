package w8p1.file;

import java.util.Comparator;

public class ComparableCapital implements Comparator<Country> {
    public int compare(Country countryOne, Country countryTwo)
    {
        return countryOne.getCapital().compareTo(countryTwo.getCapital());
    }
}

