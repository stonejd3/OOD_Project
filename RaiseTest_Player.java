package a;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RaiseTest_Player {

	@Test
	void raiseTest() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		PokerDeck deck = new PokerDeck();
		Player p = new Player(deck);
		int raise = 50;
		int currentPot = 100;
		p.raise(currentPot, raise);
		p.a.getBalance();
		equals(p.a.getBalance() == 350);
		//fail("Not yet implemented");
	}
	
	@Test
	void raiseTest2() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		//cannot pace a bet that exceeds the amount of money in the account
		PokerDeck deck = new PokerDeck();
		Player p = new Player(deck);
		int raise = 50;
		int currentPot = 500;
		boolean validBet = true;
		p.raise(currentPot, raise);
		p.a.getBalance();
		equals(validBet = false);
		//fail("Not yet implemented");
	}
	

}
