import java.util.*;
public class Ranker
{
    // instance variables - replace the example below with your own
    public ArrayList<Card> hand;
    public int rank;
    public int highPair;
    boolean flush=true; //assume there is a flush
    boolean royality=false;
    boolean fullHouse = false;
    boolean twoPair = false;
    boolean straight=true; //assume there is a straight
    public Ranker(ArrayList<Card> hand){
        this.hand = hand;
        royal();
        flush();
        straight();
        ofAKind();
        totalRanking();
    }
    
    void royal(){
        Card.Suit check = hand.get(1).suit;
        
        int royalTotal = 0;
        for (int x=0; x<5; x++){
            royalTotal= royalTotal+ hand.get(x).value;
        }
        if(royalTotal == 51){
            royality = true;
        }
    }
    
    void flush(){
        Card.Suit check = hand.get(1).suit;
        
        for (int x=0; x<4; x++){
            if( hand.get(x).suit != hand.get(x+1).suit ){
                flush=false;
            }
        }
        
    }
    
    void straight(){
        Card.Suit check = hand.get(1).suit;
        
        for (int x=0; x<4; x++){
            if( (hand.get(x).value + 1) != hand.get(x+1).value ){
                straight=false;
            } 
        }
        if(hand.get(4).value == 11 && hand.get(0).value ==2){
            straight=true;
            for (int x=1; x<3; x++){
                if( (hand.get(x).value + 1) != hand.get(x+1).value ){
                    straight=false;
                } 
            }
        }
    }
    
    void ofAKind(){
        int highestPair = 0;
        int currentPair = 0;
        Card checkCard = hand.get(0);
        for(int x=0; x<5; x++){
            if( checkCard.name.equals(hand.get(x).name) ){
                currentPair++;
                //System.out.println(checkCard.name+ " matches " + hand.get(x).name);
                //System.out.println(currentPair);
            } else {
                //System.out.println(currentPair + " was the last pair");
                if(currentPair > highestPair){
                    //System.out.println(currentPair + " is new highest pair");
                    highestPair = currentPair;
                    //highPair = highestPair;
                    //System.out.println(highPair + " is now high pair");
                }
                currentPair = 1;
                checkCard= hand.get(x);
            }
        }
        // If last element is most frequent 
        if (currentPair > highestPair) 
        { 
            //System.out.println(currentPair + " is new highest pair");
            //highestPair = currentPair;
            highPair = highestPair;
            //System.out.println(highPair + " is now high pair"); 
        } 
        if( (hand.get(0).name == hand.get(1).name && hand.get(2).name == hand.get(3).name) ||
        (hand.get(1).name == hand.get(2).name && hand.get(3).name == hand.get(4).name)){
            twoPair = true;
        }
        
        if( ((hand.get(0).name == hand.get(1).name && hand.get(0).name == hand.get(2).name) && (hand.get(3).name == hand.get(4).name))  ||
        ((hand.get(0).name == hand.get(1).name) && (hand.get(2).name == hand.get(3).name && hand.get(2).name == hand.get(4).name)) ){
            fullHouse = true;
        }
        
        highPair = highestPair;
    }
    
    int mostFrequent(int arr[], int n) 
    { 
          
        // Sort the array 
        Arrays.sort(arr); 
        int highestPair = 1;
        int currentPair = 1;
        Card checkCard = hand.get(0);
        // find the max frequency using linear 
        // traversal 
        int max_count = 1, res = arr[0]; 
        int curr_count = 1; 
          
        for (int i = 1; i < n; i++) 
        { 
            if (arr[i] == arr[i - 1]) 
                curr_count++; 
            else 
            { 
                if (curr_count > max_count) 
                { 
                    max_count = curr_count; 
                    res = arr[i - 1]; 
                } 
                curr_count = 1; 
            } 
        } 
      
        // If last element is most frequent 
        if (curr_count > max_count) 
        { 
            max_count = curr_count; 
            res = arr[n - 1]; 
        } 
      
        return res; 
    } 
    
    void totalRanking(){
        if(royality && flush){
            rank = 20;
        } else if (straight && flush){
            rank = 19;
        } else if (highPair == 4){
            rank = 18;
        } else if (fullHouse == true){
            rank = 17;
        } else if (flush == true){
            rank = 16;
        } else if (straight == true){
            rank = 15;
        } else if (highPair == 3){
            rank = 14;
        } else if (twoPair == true){
            rank = 13;
        } else if (highPair == 2){
            rank = 12;
        } else {
            rank = hand.get(4).value;
        }
    
    }
    
}
