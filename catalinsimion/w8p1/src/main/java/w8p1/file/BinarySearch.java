package w8p1.file;

import java.util.List;

public class BinarySearch {
    private String countrySearch;

    public String binarySearchCapital(List<Country> countryArrayList, String capitalSearch) {
        for (int i = 0; i < countryArrayList.size(); i++) {
            if (countryArrayList.get(i).getCapital() == capitalSearch) {
                return countrySearch = countryArrayList.get(i).getName();
            }
        }
        return countrySearch;
    }
}