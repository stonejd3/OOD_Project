public class Card {
    public Card.Suit suit;
    private Card.Color color;
    public String name;
    public int value;
    
    private boolean drawn;
   public static enum Suit {
        Heart, Diamond, Spade, Club,
        Cup, Coin, Sword, SClub;
    }
    
    public Card(String newName, int newValue, Suit newSuit){
        name = newName;
        value = newValue;
        suit = newSuit;
    }
    
    public Card(String newName, int newValue, Color newColor){
        name = newName;
        value = newValue;
        color = newColor;
    }
    
    //the classes below are meant to test the creation of 
    //all the cards in a Deck
    public String showPokercard(){
        return name +" of " + suit + ", value: " + value; 
    }
    
}
