

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PlayerViewTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PlayerViewWhiteBox{
    
    public PlayerViewWhiteBox()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }
    
    @Test
    public void callTest() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	Player p = new Player();
	int callAmount = 15;
	p.a.setbetAmount(5);
	p.call(callAmount);
	assert(p.a.getBalance() == 490);
    }
	// if they call more than the amount of money that they currently have, set their account to zero
    @Test
    public void callTest2() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Player p = new Player();
	int callAmount = 506;
	p.a.setbetAmount(5);
	p.call(callAmount);
	assert(p.a.getBalance() == 0);
    }
	
    @Test
    public void foldTest() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	Player p = new Player();
	p.fold();
	assert(p.playerHand.hand.size() == 0);

    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
