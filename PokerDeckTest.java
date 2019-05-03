import java.util.*; 
import static org.junit.Assert.*;
import org.junit.After; 
import org.junit.Before;
import org.junit.Test;
public class PokerDeckTest{
    public PokerDeckTest(){
    }
    @Test public void testdeckCreation(){
        PokerDeck test = new PokerDeck();
        assert(test.deck.get(0).name == "Ace");
    }
    @Test public void testDeckShuffle(){
        PokerDeck testDeck = new PokerDeck();
        ArrayList<Card> checkDeck = testDeck.deck;
        testDeck.shuffle();
        assert(!testDeck.equals(checkDeck));
    }
    @Test public void testDeckDraw(){
        PokerDeck testDeck = new PokerDeck();
        Card testCard = testDeck.draw();
        
        assert(testCard.name == "Ace" && testCard.suit == Card.Suit.Heart);
    }
    @Test public void testDeckSpecificDraw(){
        PokerDeck testDeck = new PokerDeck();
        Card testCard = testDeck.drawTester(14);
        
        assert(testCard.name == "Two" && testCard.suit == Card.Suit.Diamond);
    }
}
