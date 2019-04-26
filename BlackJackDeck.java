/*
 * only exists as poker ace can be high or low
 * done so that a deck can be choosen at the begining
 * of the game. That is that it would be better than
 * having to choose it during creation
*/
import java.util.*;
public class BlackJackDeck implements Deck {
    public ArrayList<Card> deck = new ArrayList<Card>();
    public ArrayList<Card.Suit> suits = new ArrayList<Card.Suit>();
    public int[] values = new int[]{1,2,3,4,5,6,7,8,9,10,10,10,10};
    public String[] names = new String[]{"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
    public BlackJackDeck(){
        suits.add(Card.Suit.Heart); suits.add(Card.Suit.Diamond);
        suits.add(Card.Suit.Spade); suits.add(Card.Suit.Club);
        //used arrays and arraylist so that it would be easier
        Card.Suit currentSuit;
        Card currentCard;
        //do this twice
        for (int z = 0; z<2; z++){
            for(int i = 0; i<4; i++){
                currentSuit = suits.get(i);
                for(int y = 0; y<13;y++){
                    currentCard = new Card(names[y],values[y],currentSuit);
                    deck.add(currentCard);
                }
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
}
