import java.util.*;
public class SpanishDeck implements Deck{
    public ArrayList<Card> deck = new ArrayList<Card>();
    public ArrayList<Card.Suit> suits = new ArrayList<Card.Suit>();
    public int[] values = new int[]{1,2,3,4,5,6,7,8,9,10,10,10,10};
    public String[] names = new String[]{"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
    public SpanishDeck(){
        suits.add(Card.Suit.Cup); suits.add(Card.Suit.Coin);
        suits.add(Card.Suit.SClub); suits.add(Card.Suit.Sword);
        //used arrays and arraylist so that it would be easier
        Card.Suit currentSuit;
        Card currentCard;
        //do this twice
        
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
