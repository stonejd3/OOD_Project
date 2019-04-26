package a;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCase_Player {

	@Test
	void callTest() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		//regular call amount
		PokerDeck deck = new PokerDeck();
		Player p = new Player(deck);
		int currentPot = 100;
		p.call(currentPot);
		equals(p.a.getBalance() == 400);
		//fail("Not yet implemented");
		
	}
	
	@Test
	void callTest2() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		//a call that goes over the amount in the players account, returns that it is not a valid bet from the player
		PokerDeck deck = new PokerDeck();
		Player p = new Player(deck);
		boolean validBet = true;
		int currentPot = 501;
		p.call(currentPot);
		
		equals(p.a.getBalance() == 0);
		//fail("Not yet implemented");
		
	}

}
