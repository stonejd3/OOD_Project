import java.util.ArrayList;
import java.util.Observer;

public class Player  {
	String name;
	AccountFactory af = AccountFactory.getFactory();
	Account a = af.getAccount();

	boolean validBet = true;
	String state;
	boolean isActive = true;
	Hand playerHand;

	//fix the hand maker/populate later
	public Player() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		playerHand = new Hand();
		//createHands(deck);
	}

	public void raise(int currentPot,int raiseAmount) {
		int newPot;
		newPot = currentPot + raiseAmount;

		int newBalance = a.getBalance() - newPot;
		if(newBalance < 0) {
			validBet= false;

		} else {
			a.setBalance(newBalance );

		}

	}

	public void call(int currentPot) {

		int newBalance = a.getBalance() - currentPot;

		if(newBalance < 0) {
			newBalance = 0;
			a.setBalance(newBalance);
		} else {
			a.setBalance(newBalance);

		}
	}

	public void fold() {
		//isActive = false;
		playerHand.hand.clear();
		//empty out hand
	}

	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}



}