
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DeckFactoryTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DeckFactoryTest
{
    /**
     * Default constructor for test class DeckFactoryTest
     */
    public DeckFactoryTest()
    {
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
    
    @Test
    public void creation()throws InstantiationException,
    IllegalAccessException, ClassNotFoundException{
        DeckFactory df =  DeckFactory.getBuilder();
        Deck testDeck = df.buildDeck();
        Card testCard = testDeck.draw();
        assert(testCard.suit ==  Card.Suit.Heart);
    }
    
    @Test
    public void setClassTest()throws InstantiationException,
    IllegalAccessException, ClassNotFoundException{
        DeckFactory df =  DeckFactory.getBuilder();
        String deckClass = "Spanish";
        df.setClass(deckClass);
        Deck testDeck = df.buildDeck();
        Card testCard = testDeck.draw();
        deckClass = "Poker";
        df.setClass(deckClass);
        testDeck = df.buildDeck();
        Card testCard2 = testDeck.draw();
        assert(testCard.suit == Card.Suit.Cup && testCard2.suit == Card.Suit.Heart);
    }
    
    @Test
    public void traditionalDeckTest()throws InstantiationException,
    IllegalAccessException, ClassNotFoundException{
        DeckFactory df =  DeckFactory.getBuilder();
        String deckClass = "Poker";
        df.setClass(deckClass);
        Deck testDeck = df.buildDeck();
        Card testCard = testDeck.draw();
        assert(testCard.suit ==  Card.Suit.Heart);
    }
    
    @Test
    public void spanishDeckTest()throws InstantiationException,
    IllegalAccessException, ClassNotFoundException{
        DeckFactory df =  DeckFactory.getBuilder();
        String deckClass = "Spanish";
        df.setClass(deckClass);
        Deck testDeck = df.buildDeck();
        Card testCard = testDeck.draw();
        assert(testCard.suit ==  Card.Suit.Cup);
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
