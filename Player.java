import java.util.ArrayList;
import java.util.Observer;

public class Player  {
	String name;
	public PlayerObservable playerObserable;
	AccountFactory af = AccountFactory.getFactory();
	Account a = af.getAccount();

	String state;
	boolean isActive = true;
	Hand playerHand;

	//fix the hand maker/populate later
	public Player() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		DeckFactory df =  DeckFactory.getBuilder();
		String deckClass = "Poker";
		df.setClass(deckClass);
		Deck test = df.buildDeck();
		playerHand = new Hand();
		ArrayList<Card> checker = new ArrayList<Card>();
		for(int i = 0; i < 5; i++){
			checker.add(test.draw());
		}

		playerHand.addToHand(checker);

	}




//	public void Bet(int currentPot) {
//
//		int newBalance = a.getBalance() - currentPot;
//		a.setBalance(newBalance );
//	}

	public void raise(int currentPot,int raiseAmount) {
		int newPot;
		newPot = currentPot + raiseAmount;
		//add server.setBalance to the 'currentpot'
		int newBalance = a.getBalance() - newPot;
		if(newBalance < 0) {
			//make so that the player can still raise,call, or fold through the GUI
		}else {
			a.setBalance(newBalance );

		}
		//update part that updates the pot amount with the raise amount
	}

	public void call(int currentPot) {
		int newBalance = a.getBalance() - currentPot;
		a.setBalance(newBalance );
	}

	public void fold() {
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