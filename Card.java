public class Card{
    public Card.Suit suit;
    public String name;
    public int value;
    
    private boolean drawn;
    public static enum Suit {
        Heart, Diamond, Spade, Club,
        Cup, Coin, Sword, SClub;
    }
    
    public Card(String newName, int newValue,Suit newSuit){
        name = newName;
        value = newValue;
        suit = newSuit;
    }
    
    //the classes below are meant to test the creation of 
    //all the cards in a deck
    public String showPokercard(){
        return name +" of " + suit + ", value: " + value; 
    }
    
}
