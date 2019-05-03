import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class PlayerTest{
    public PlayerTest(){
    }
    // if they call more than the amount of money that they currently have, set their account to zero
    @Test public void callTest() throws InstantiationException,
    IllegalAccessException, ClassNotFoundException {
        Player p = new Player();
        int callAmount = 506;
        p.a.setbetAmount(5);
        p.call(callAmount);
        assert(p.a.getBalance() == 0);;
    }
    @Test public void foldTest() throws InstantiationException,
    IllegalAccessException, ClassNotFoundException {
        Player p = new Player();
        p.fold();
        assert(p.playerHand.hand.size() == 0);
    }
    
}