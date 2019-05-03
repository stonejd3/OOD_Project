import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class RankerTest{
    public RankerTest(){
    }
    @Test
    public void royalFlushIfCheck()throws InstantiationException,
    IllegalAccessException, ClassNotFoundException{
        Hand testhand = new Hand();
        DeckFactory df =  DeckFactory.getBuilder();
        String deckClass = "Poker";
        df.setClass(deckClass);
        Deck test = df.buildDeck();
        ArrayList<Card> checker = new ArrayList<Card>();
        checker.add(test.drawTester(0)); 
        checker.add(test.drawTester(8));
        checker.add(test.drawTester(8));
        checker.add(test.drawTester(8));
        checker.add(test.drawTester(8));
        Ranker rankCheck = new Ranker(checker);
        assert(rankCheck.rank == 20);
    }
    @Test
    public void straightFlushIfCheck()throws InstantiationException,
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
    @Test
    public void fourPairIfCheck()throws InstantiationException,
    IllegalAccessException, ClassNotFoundException{
        Hand testhand = new Hand();
        DeckFactory df =  DeckFactory.getBuilder();
        String deckClass = "Poker";
        df.setClass(deckClass);
        Deck test = df.buildDeck();
        
        ArrayList<Card> listOfCards = new ArrayList<Card>();
        listOfCards.add(test.drawTester(0)); 
        listOfCards.add(test.drawTester(12));
        listOfCards.add(test.drawTester(24));
        listOfCards.add(test.drawTester(36));
        listOfCards.add(test.drawTester(8));
        listOfCards.get(3).showPokercard();
        Ranker rankCheck = new Ranker(listOfCards);
        
        assert(rankCheck.rank == 18);
    }    
    @Test
    public void fullHouseIfCheck()throws InstantiationException,
    IllegalAccessException, ClassNotFoundException{
        Hand testhand = new Hand();
        DeckFactory df =  DeckFactory.getBuilder();
        String deckClass = "Poker";
        df.setClass(deckClass);
        Deck test = df.buildDeck();
        
        ArrayList<Card> listOfCards = new ArrayList<Card>();
        listOfCards.add(test.drawTester(0)); 
        listOfCards.add(test.drawTester(12));
        listOfCards.add(test.drawTester(24));
        listOfCards.add(test.drawTester(0));
        listOfCards.add(test.drawTester(11));
        listOfCards.get(3).showPokercard();
        Ranker rankCheck = new Ranker(listOfCards);
        
        assert(rankCheck.rank == 17);
    }    
    @Test
    public void flushIfCheck()throws InstantiationException,
    IllegalAccessException, ClassNotFoundException{
        Hand testhand = new Hand();
        DeckFactory df =  DeckFactory.getBuilder();
        String deckClass = "Poker";
        df.setClass(deckClass);
        Deck test = df.buildDeck();
        
        ArrayList<Card> listOfCards = new ArrayList<Card>();
        listOfCards.add(test.drawTester(0)); 
        listOfCards.add(test.drawTester(1));
        listOfCards.add(test.drawTester(2));
        listOfCards.add(test.drawTester(3));
        listOfCards.add(test.drawTester(4));
        
        Ranker rankCheck = new Ranker(listOfCards);
        
        assert(rankCheck.rank == 16);
    }    
    @Test
    public void threePairIfCheck()throws InstantiationException,
    IllegalAccessException, ClassNotFoundException{
        Hand testhand = new Hand();
        DeckFactory df =  DeckFactory.getBuilder();
        String deckClass = "Poker";
        df.setClass(deckClass);
        Deck test = df.buildDeck();
        
        ArrayList<Card> listOfCards = new ArrayList<Card>();
        listOfCards.add(test.drawTester(0)); 
        listOfCards.add(test.drawTester(12));
        listOfCards.add(test.drawTester(0));
        listOfCards.add(test.drawTester(11));
        listOfCards.add(test.drawTester(8));
        listOfCards.get(3).showPokercard();
        Ranker rankCheck = new Ranker(listOfCards);
        assert(rankCheck.rank == 13);
    }    
    @Test
    public void twoPairIfCheck()throws InstantiationException,
    IllegalAccessException, ClassNotFoundException{
        Hand testhand = new Hand();
        DeckFactory df =  DeckFactory.getBuilder();
        String deckClass = "Poker";
        df.setClass(deckClass);
        Deck test = df.buildDeck();
        
        ArrayList<Card> listOfCards = new ArrayList<Card>();
        listOfCards.add(test.drawTester(0)); 
        listOfCards.add(test.drawTester(12));
        listOfCards.add(test.drawTester(6));
        listOfCards.add(test.drawTester(11));
        listOfCards.add(test.drawTester(8));
        listOfCards.get(3).showPokercard();
        Ranker rankCheck = new Ranker(listOfCards);
        
        assert(rankCheck.rank == 12);
    }
    @Test
    public void highCardIfCheck()throws InstantiationException,
    IllegalAccessException, ClassNotFoundException{
        Hand testhand = new Hand();
        DeckFactory df =  DeckFactory.getBuilder();
        String deckClass = "Poker";
        df.setClass(deckClass);
        Deck test = df.buildDeck();
        
        ArrayList<Card> listOfCards = new ArrayList<Card>();
        listOfCards.add(test.drawTester(18)); 
        listOfCards.add(test.drawTester(6));
        listOfCards.add(test.drawTester(36));
        listOfCards.add(test.drawTester(13));
        listOfCards.add(test.drawTester(0));
        listOfCards.get(3).showPokercard();
        Ranker rankCheck = new Ranker(listOfCards);
        
        assert(rankCheck.rank == 11);
    }
    @Test
    public void doublePairIfCheck()throws InstantiationException,
    IllegalAccessException, ClassNotFoundException{
        Hand testhand = new Hand();
        DeckFactory df =  DeckFactory.getBuilder();
        String deckClass = "Poker";
        df.setClass(deckClass);
        Deck test = df.buildDeck();
        
        ArrayList<Card> listOfCards = new ArrayList<Card>();
        listOfCards.add(test.drawTester(0)); 
        listOfCards.add(test.drawTester(12));
        listOfCards.add(test.drawTester(24));
        listOfCards.add(test.drawTester(18));
        listOfCards.add(test.drawTester(8));
        listOfCards.get(3).showPokercard();
        Ranker rankCheck = new Ranker(listOfCards);
        
        assert(rankCheck.rank == 14);
    }
    
    @Test
    public void createMethodCheck()throws InstantiationException,
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
