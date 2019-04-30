
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HandTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HandTest
{
    /**
     * Default constructor for test class HandTest
     */
    public HandTest()
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
    public void testCreation(){
        Hand testHand = new Hand();
        assert(testHand.hand.size() == 0);
    }
    
    @Test
    public void testAddToHand(){
        Hand testHand = new Hand();
        Card testCard = new Card("Ace",11,Card.Suit.Heart);
        ArrayList<Card> testArray = new ArrayList<Card>();
        testArray.add(testCard);
        testHand.addToHand(testArray);
        assert(testHand.hand.size() == 1);
    }
    
    @Test
    public void testHandSort(){
        Hand testHand = new Hand();
        Card testCard = new Card("Ace",11,Card.Suit.Heart);
        Card testCard2 = new Card("One",1,Card.Suit.Heart);
        ArrayList<Card> testArray = new ArrayList<Card>();
        testArray.add(testCard);
        testArray.add(testCard2);
        testHand.addToHand(testArray);
        testHand.sortHand();
        assert(testHand.hand.get(1).name == "Ace");
    }
    
    @Test
    public void testSetRanking()throws InstantiationException,
    IllegalAccessException, ClassNotFoundException{
        Hand testhand = new Hand();
        DeckFactory df =  DeckFactory.getBuilder();
        
        String deckClass = "Poker";
        
        df.setClass(deckClass);
        Deck test = df.buildDeck();
        
        ArrayList<Card> checker = new ArrayList<Card>();
        for(int i = 0; i < 5; i++){
            checker.add(test.draw());
        }
        
        testhand.addToHand(checker);
        testhand.setRanking();
        assert(testhand.handRank == 19);
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
