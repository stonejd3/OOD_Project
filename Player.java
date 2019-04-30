import java.util.ArrayList;
import java.util.Observer;

public class Player  {
	String name;
	static int currentBetAmountP = 0 ;
	static int moneyIntoPot = 0;
	public PlayerObservable playerObserable;
	AccountFactory af = AccountFactory.getFactory();
	Account a = af.getAccount();
	
	boolean validBet = true;
	String state;
	boolean isActive = true;
	boolean isWinner = false;
	Hand playerHand;

	//fix the hand maker/populate later
	public Player() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		playerHand = new Hand();
		//createHands(deck);
	}
	/*public static Deck createHands(Deck deck) {
		
		//if(playerHand.hand.size() != 0) {
			fold();
		//}
		ArrayList<Card> cards = new ArrayList<Card>();
		int i = 0; 
		while(i<5) {
			cards.add(deck.draw());
			i++;
		}
		playerHand.addToHand(cards);
		//isActive = true;
		
		return deck;
	}
*/

	public void raise(int raiseAmount) {
		//int newPot;
		a.setbetAmount(raiseAmount + 5); 
		//newPot = currentPot + currentBetAmountP;
		
		int newBalance = a.getBalance() - (a.getbetAmount());
		if(newBalance < 0) {
			validBet= false;
		}else {
			a.setBalance(newBalance );

		}
		
	}

	public void call(int callAmount) { // call(int currentPot, int moneyIntoPot)
		int newBalance = a.getBalance() - (callAmount-a.getbetAmount());
		
		if(newBalance < 0) {
			newBalance = 0;
			a.setBalance(newBalance);
		}else {
	//		moneyIntoPot = currentCallAmount - currentBetAmount;
			a.setBalance(newBalance);
			
		//	currentBetAmount = 0;
		}
		
	}
	
	public int returnCallDifference(int callAmount) {
		int difference = (callAmount-a.getbetAmount());
		a.setbetAmount(callAmount);
		return difference;
	}

	public void fold() {
		//isActive = false;
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