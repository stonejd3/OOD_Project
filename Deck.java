import java.util.*;
public interface Deck {
    public ArrayList<Card> deck= null;
    void readThrough();
    void shuffle();
    Card draw();
}
