import org.junit.Test;
import w8p2.file.Card;
import w8p2.file.DeckOfCards;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestCard {

    @Test
    public void testShuffled(){
        List<Card> deckOfCards = new ArrayList<>();

        DeckOfCards deck=new DeckOfCards(new ArrayList<>(deckOfCards));
        deck.initialize();
        deck.shuffleList();
        assertEquals(0,deck.getDeckOfCards().size());
    }
}
