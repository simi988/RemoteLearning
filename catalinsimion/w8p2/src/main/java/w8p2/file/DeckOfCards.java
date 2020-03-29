package w8p2.file;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {


    private List<Card> deckOfCards;
    private final int maxCards = 14;

    public DeckOfCards(List<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    private List<Card> addCards(int number, Suite suite) {
        List<Card> deckOfCards = new ArrayList<>();

        for (int i = 2; i <= number; i++) {

            deckOfCards.add(new Card(i, suite));
        }
        return deckOfCards;
    }

    public void initialize() {
        deckOfCards.addAll(addCards(maxCards, Suite.DIAMONDS));
        deckOfCards.addAll( addCards(maxCards, Suite.BLACKHEART));
        deckOfCards.addAll(addCards(maxCards, Suite.CLUBS));
        deckOfCards .addAll(addCards(maxCards, Suite.REDHEART));

    }

    public void shuffleList() {
        Collections.shuffle(deckOfCards);
    }

    public List<Card> getDeckOfCards() {
        return deckOfCards;
    }

}
