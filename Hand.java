import java.util.*;
public class Hand{
    // instance variables - replace the example below with your own
    public int handRank;
    public ArrayList<Card> hand;
    public Hand(){
        // initialise instance variables
        hand = new ArrayList<Card>();
    }
    
    public void addToHand(ArrayList<Card> drawn){
        hand.clear();
        int test = drawn.size();
        for(int i = 0; i<test; i++){
            hand.add(drawn.get(i));
        }
        sortHand();
    }
    
    void sortHand(){
        for(int x = 0; x< hand.size(); x++){
            for(int y = 0; y < (hand.size()-1); y++){
                if (hand.get(y).value > hand.get(y+1).value
                || (hand.get(y).name =="Jack" && hand.get(y+1).name =="Ten")
                || (hand.get(y).name =="Queen" && hand.get(y+1).name =="Ten")
                || (hand.get(y).name =="King" && hand.get(y+1).name =="Ten")
                || (hand.get(y).name =="Queen" && hand.get(y+1).name =="Jack")
                || (hand.get(y).name =="King" && hand.get(y+1).name =="Jack")
                || (hand.get(y).name =="King" && hand.get(y+1).name =="Queen")
                ){
                    Collections.swap(hand, y, y+1);
                }
            }
        }
    }
    
    public void setRanking(){
        Ranker tester = new Ranker(hand);
        tester.totalRanking();
        handRank = tester.rank;
    }
    
    public void readThrough(){ //created only to test
        for(int i = 0; i < hand.size(); i++){
            System.out.println(hand.get(i).showPokercard());
        }
        System.out.println();
    }

    public void removeFromHand(int i){
        hand.remove(i);
    }
}
