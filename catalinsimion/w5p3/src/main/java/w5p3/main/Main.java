package w5p3.main;

import w5p3.file.History;


public class Main {
    public static void main(String[] args) {

        History history = new History();

        history.historic();
        System.out.println(history.toString());

    }
}
