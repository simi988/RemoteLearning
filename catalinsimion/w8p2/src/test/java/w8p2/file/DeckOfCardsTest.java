package w8p2.file;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class DeckOfCardsTest {

    @Test
    public void testShuffled() {
        List<Card> deckOfCards = new ArrayList<>();
        DeckOfCards deck=new DeckOfCards(new ArrayList<>(deckOfCards));
        deck.initialize();
        Random random=new Random(1);
        deck.shuffleList(random);
        assertEquals(52,deck.getDeckOfCards().size());
    }
}
