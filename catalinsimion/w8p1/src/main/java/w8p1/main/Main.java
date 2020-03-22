package w8p1.main;

import w8p1.file.Country;
import w8p1.file.SortByCapital;
import w8p1.file.SortByName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Country> countryArrayList = new ArrayList<Country>();
        countryArrayList.add(new Country("Romania", "Bucharest"));
        countryArrayList.add(new Country("Uk", "London"));
        countryArrayList.add(new Country("Italy", "Rome"));
        countryArrayList.add(new Country("France", "Paris"));

        System.out.println("Unsorted");
        for (int i=0; i<countryArrayList.size(); i++)
            System.out.println(countryArrayList.get(i).toString());


        Collections.sort(countryArrayList, new SortByName());

        System.out.println("\nSorted by name");
        for (int i=0; i<countryArrayList.size(); i++)
            System.out.println(countryArrayList.get(i).toString());

      Collections.sort(countryArrayList, new SortByCapital());

        System.out.println("\nSorted by Capital");
        for (int i=0; i<countryArrayList.size(); i++)
            System.out.println(countryArrayList.get(i).toString());
}
}
