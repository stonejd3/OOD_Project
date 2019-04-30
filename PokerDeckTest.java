import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PokerDeckTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PokerDeckTest
{
    /**
     * Default constructor for test class PokerDeckTest
     */
    public PokerDeckTest()
    {
    }
    
    @Test
    public void testdeckCreation()
    {
        PokerDeck test = new PokerDeck();
        assert(test.deck.get(0).name == "Ace");
    }
    
    @Test
    public void testDeckShuffle()
    {
        PokerDeck testDeck = new PokerDeck();
        ArrayList<Card> checkDeck = testDeck.deck;
        testDeck.shuffle();
        assert(!testDeck.equals(checkDeck));
    }
    
    @Test
    public void testDeckDraw()
    {
        PokerDeck testDeck = new PokerDeck();
        Card testCard = testDeck.draw();
        
        assert(testCard.name == "Ace" && testCard.suit == Card.Suit.Heart);
    }
    
    @Test
    public void testDeckSpecificDraw()
    {
        PokerDeck testDeck = new PokerDeck();
        Card testCard = testDeck.drawTester(14);
        
        assert(testCard.name == "Two" && testCard.suit == Card.Suit.Diamond);
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
