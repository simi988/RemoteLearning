package w8p2.main;

import w8p2.file.Card;
import w8p2.file.DeckOfCards;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Card>cards=new ArrayList<>();
        DeckOfCards deckOfCards = new DeckOfCards(cards);
        deckOfCards.initialize();
        deckOfCards.shuffleList();


    }
}
