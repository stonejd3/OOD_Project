
import java.util.ArrayList;
import java.util.Observer;

public class Player  {
	String name;
	public PlayerObservable playerObserable;
	AccountFactory af = AccountFactory.getFactory();
	Account a = af.getAccount();
	
	boolean validBet = true;
	String state;
	static boolean isActive = true;
	static Hand playerHand;

	//fix the hand maker/populate later
	public Player(Deck deck) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		playerHand = new Hand();
		createHands(deck);
	}
	public static Deck createHands(Deck deck) {
		
		//if(playerHand.hand.size() != 0) {
		//	fold();
		//}
		ArrayList<Card> cards = new ArrayList<Card>();
		int i = 0; 
		while(i<5) {
			cards.add(deck.draw());
			i++;
		}
		playerHand.addToHand(cards);
		isActive = true;
		
		return deck;
	}


	public void raise(int currentPot,int raiseAmount) {
		int newPot;
		newPot = currentPot + raiseAmount;
		
		int newBalance = a.getBalance() - newPot;
		if(newBalance < 0) {
			validBet= false;
			
		}else {
			a.setBalance(newBalance );

		}
		
	}

	public void call(int currentPot) {
		int newBalance = a.getBalance() - currentPot;
		if(newBalance < 0) {
			newBalance = 0;
			a.setBalance(newBalance);
		}else {
			a.setBalance(newBalance);

		}
	}

	public static void fold() {
		isActive = false;
		playerHand.hand.clear();
		//empty out hand
	}
	//------------------------------------------------------------

	public void addObserver(Observer o){
		playerObserable.addObserver(o);
		// Give the new observer current state
		playerObserable.setChanged();
		//fix later
		playerObserable.notifyObservers(state); //the state of the player whether they folded, raised, or called
	}

	public void deleteObserver(Observer o){
		playerObserable.deleteObserver(o);
	}

	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}



}
