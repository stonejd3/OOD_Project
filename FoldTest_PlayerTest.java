package a;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FoldTest_PlayerTest {
	@Test
	void foldTest() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		PokerDeck deck = new PokerDeck();
		Player p = new Player(deck);
	
		p.fold();
		equals(p.playerHand.hand.size()== 0  );
		
		//fail("Not yet implemented");
	}
	
	@Test
	void foldTest2() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		PokerDeck deck = new PokerDeck();
		Player p = new Player(deck);
		boolean isActive = true;
		p.fold();
		equals(p.playerHand.hand.size()== 0 && isActive == false );
		
		//fail("Not yet implemented");
	}


}
