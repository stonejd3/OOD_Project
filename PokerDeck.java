/*
 * the basic deck, it uses high ace
 * this was done for no other reason
 * than just being the main deck
 */
import java.util.*;
public class PokerDeck implements Deck
{
    public ArrayList<Card> deck = new ArrayList<Card>();
    public ArrayList<Card.Suit> suits = new ArrayList<Card.Suit>();
    public int[] values = new int[]{11,2,3,4,5,6,7,8,9,10,10,10,10};
    public String[] names = new String[]{"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
    public PokerDeck(){
        suits.add(Card.Suit.Heart); suits.add(Card.Suit.Diamond);
        suits.add(Card.Suit.Spade); suits.add(Card.Suit.Club);
        //used arrays and arraylist so that it would be easier
        Card.Suit currentSuit;
        Card currentCard;
        
        for(int i = 0; i<4; i++){
            currentSuit = suits.get(i);
            for(int y = 0; y<13;y++){
                currentCard = new Card(names[y],values[y],currentSuit);
                deck.add(currentCard);
            }
        }
    }
    
    public void readThrough(){//created only to test
        for(int i = 0; i < deck.size(); i++){
            System.out.println(deck.get(i).showPokercard());
        }
        System.out.println();
    }
    
    public void shuffle(){
        Collections.shuffle(deck);
    }
    
    public Card draw(){
        return deck.remove(0);
    }
    
    public Card drawTester(int i){
        return deck.remove(i);
    }
}
