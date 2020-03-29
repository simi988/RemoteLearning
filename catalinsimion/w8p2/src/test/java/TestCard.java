import org.junit.Test;
import w8p2.file.Card;
import w8p2.file.DeckOfCards;
import w8p2.file.Suite;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestCard {



    @Test
    public void testShuffled(){
        List<Card> deckOfCards = new ArrayList<>();
        deckOfCards.add(new Card(5,Suite.CLUBS));
        deckOfCards.add(new Card(4, Suite.REDHEART));
        deckOfCards.add(new Card(3,Suite.DIAMONDS));
        deckOfCards.add(new Card(2,Suite.BLACKHEART));
        DeckOfCards deck=new DeckOfCards(new ArrayList<>(deckOfCards));
        deck.shuffleList();
        assertEquals(4,deck.getDeckOfCards().size());
        assertNotEquals(deckOfCards.get(0),deck.getDeckOfCards().get(0));
        assertNotEquals(deckOfCards.get(3),deck.getDeckOfCards().get(3));

    }
}
