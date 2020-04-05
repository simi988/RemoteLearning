package w8p2.file;

import java.util.ArrayList;
import java.util.List;

public class DeckOfCards {


    private List<Card> deckOfCards;
    private final int MAX_NUMBER_OF_CARDS_PER_SUITE = 14;

    public DeckOfCards(List<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    private List<Card> addCards( Suite suite) {
        List<Card> deckOfCards = new ArrayList<>();

        for (int i = 2; i <=  MAX_NUMBER_OF_CARDS_PER_SUITE; i++) {

            deckOfCards.add(new Card(i, suite));
        }
        return deckOfCards;
    }

    public void initialize() {
        deckOfCards.addAll(addCards( Suite.DIAMONDS));
        deckOfCards.addAll( addCards( Suite.BLACKHEART));
        deckOfCards.addAll(addCards( Suite.CLUBS));
        deckOfCards .addAll(addCards( Suite.REDHEART));

    }

    public void shuffleList() {
        List<Card> shuffledDeck = new ArrayList<>();

        while (deckOfCards.size() > 0) {
        int index = (int) (Math.random() * deckOfCards.size());
        shuffledDeck.add(deckOfCards.remove(index));
    }
    }

    public List<Card> getDeckOfCards() {
        return deckOfCards;
    }

}
