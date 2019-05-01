public class DeckFactory
{
    // instance variables - replace the example below with your own
    static DeckFactory df;
    Deck d;
    private DeckFactory(){
        System.setProperty("DeckType", "PokerDeck");
    }
    public static synchronized DeckFactory getBuilder(){
        if(df == null){
            df = new DeckFactory();
        }
        return df;
    }
    public synchronized  void setClass(String chosen){
        System.setProperty("DeckType", chosen + "Deck");
    }
    
    public synchronized  Deck buildDeck() throws InstantiationException,
    IllegalAccessException, ClassNotFoundException{
        String pc = System.getProperty("DeckType");
        d = (Deck) Class.forName(pc).newInstance();
        return d;
    }
}
