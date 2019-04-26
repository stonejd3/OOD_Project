/*
import java.util.*;
public class UnoDeck implements deck
{
    //public ArrayList<cards2> deck = new ArrayList<cards2>();
    //public ArrayList<cards2.Color> colors = new ArrayList<cards2.Color>();
    public int[] values = new int[]{0,1,1,2,2,3,3,4,4,5,5,6,6,7,7,
        8,8,9,9,10,10,11,11};
    public String[] names = new String[]{"Zero","One","One","Two",
    "Two","Three","Three","Four","Four","Five","Five","Six","Six",
    "Seven","Seven","Eight","Nine","Ten","Jack","Queen","King"};
    public UnoDeck(){
        colors.add(cards2.Color.Red); colors.add(cards2.Color.Yellow);
        colors.add(cards2.Color.Green); colors.add(cards2.Color.Blue);
        //used arrays and arraylist so that it would be easier
        cards2.Color currentColor;
        cards2 currentCard;
        
        for(int i = 0; i<4; i++){
            currentColor = colors.get(i);
            for(int y = 0; y<13;y++){
                currentCard = new cards2(names[y],values[y],currentColor);
                deck.add(currentCard);
            }
        }
    }
    
    public void readThrough(){//created only to test
        for(int i = 0; i < 52; i++){
            System.out.println(deck.get(i).showPokercard());
        }
        System.out.println();
    }
    
    public void shuffle(){
        Collections.shuffle(deck);
    }
}
*/