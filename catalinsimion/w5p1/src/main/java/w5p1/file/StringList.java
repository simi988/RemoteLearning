package w5p1.file;


import java.util.ArrayList;

public class StringList implements List<String> {
    private ArrayList<Integer> list;

    public StringList() {
        list = new ArrayList<>();
    }

    @Override
    public void add(String element) throws CustomException {
        if (element == null) {
            throw new CustomException("Null");
        }
        try {
            Integer number = Integer.parseInt(element);
            list.add(number);
        } catch (NumberFormatException err) {
            throw new CustomException("Invalid number.");
        }
    }

    @Override
    public String get(int positon) throws CustomException {
        Integer number;
        try {
            number = list.get(positon);
        } catch (IndexOutOfBoundsException err) {
            throw new CustomException("Index out of bounds.");
        }
        return number.toString();
    }

    @Override
    public boolean contains(String element) throws CustomException {
        int number;
        if (element == null) {
            throw new CustomException("Null");
        }
        try {
            number = Integer.parseInt(element);

        } catch (NumberFormatException err) {
            throw new CustomException("Invalid number.");
        }
        return list.contains(number);
    }

    @Override
    public boolean containsAll(List<String> foreignList) throws CustomException {
        for (int i = 0; i < foreignList.size(); i++) {
            boolean b = contains(foreignList.get(i));
            if (!b) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return list.size();
    }
}
