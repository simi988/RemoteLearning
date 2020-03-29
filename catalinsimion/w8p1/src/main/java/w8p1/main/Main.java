package w8p1.main;

import w8p1.file.BinarySearch;
import w8p1.file.Country;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        BinarySearch binarySearch=new BinarySearch();
        List<Country> countryArrayList = new ArrayList<Country>();
        countryArrayList.add(new Country("Romania", "Bucharest"));
        countryArrayList.add(new Country("Uk", "London"));
        countryArrayList.add(new Country("Italy", "Rome"));
        countryArrayList.add(new Country("France", "Paris"));


      Collections.sort(countryArrayList);
        binarySearch.binarySearchCapital(countryArrayList,"Paris");
}


}
