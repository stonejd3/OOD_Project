import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class Server {

	//---------------------------------------Variables------------------------------------------------------------
    
	public ArrayList<Player> player = new ArrayList();
	   
	public int turn = 1;
	
	public int round = 1;
	   
	public int pot = 0;
	   
	public boolean defaultWin = false;
	   
	public int lastBet = 0;
	   
	public int foldCount = 0;
	
	public boolean gameover = false;
	   
	public Scanner s = new Scanner(System.in);
		
	public int currentPot = 0;
	
	public Deck deck;
	
	public String log = "";
	
	public int currentCallAmount = 0;
	
		
	//----------------------------------Individual Methods--------------------------------------------------------
		
		
		public Server(ArrayList<String> names) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
			
			DeckFactory df =  DeckFactory.getBuilder();
			String deckClass = "Poker";
			df.setClass(deckClass);
			deck = df.buildDeck();

			System.out.println("Initiated");
			boolean condition = true;
			deck.shuffle();
			int playerNum = 1;
	      
			for(String n: names){
	      		Player p1 = new Player();
	      		p1.name = n;
	      		player.add(p1);
				System.out.println("P"+playerNum+ " Created");
				playerNum++;
			}
			createHands();
			
			System.out.println("Cleared Decks");
			System.out.println("Created Player Hands");
			System.out.println();
			System.out.println("----------");
			System.out.println("Begin Game");
			updateLog("Begin Game");
			System.out.println("----------");
				
	      }
		public String getLog() {
			return log;
		}
			
		public void updateLog(String msg) {
			log = msg;
		}
//---------------Bet Method---------------------------		
		public void playerBet(Player p) {
			if(p.validBet == true) {
				p.raise(currentCallAmount);
				if(currentCallAmount == 0) {
					System.out.println("You bet $"+ 5);
				}else {
					System.out.println("You bet $"+ (5+currentCallAmount));
				}
				pot += 5+currentCallAmount;
				currentCallAmount = 5+currentCallAmount;
			}else {
				p.a.setBalance(0);
				pot += p.a.getBalance();
			}
			if(round < 3) {
				round++;
			}
			else {
				currentCallAmount = 0;
				round = 1;
			}
			System.out.println();
			System.out.println("--------------Next Player--------------");
			updateLog("Previous Player Bet");
			System.out.println();
		}
//---------------Call Method---------------------------
		public void playerCall(Player p) {
			if(currentCallAmount == 0) {
				System.out.println("You check");
				updateLog("Previous Player Checked");
				
			}else if(p.validBet == true) {
				p.call(currentCallAmount);
				pot += currentCallAmount;
				System.out.println("You call $"+ currentCallAmount);
				updateLog("Previous Player Called");
				
			}else {
				p.a.getBalance();
				pot += p.a.getBalance();
			}
			if(round < 3) {
				round++;
			}
			else {
				currentCallAmount = 0;
				round = 1;
			}
			System.out.println();
			System.out.println("--------------Next Player--------------");
			
			System.out.println();
		}
//---------------Fold Method---------------------------
		public void playerFold(Player p) {
			p.fold();
			p.isActive = false;
			System.out.println(p.name+"'s Folds");
			updateLog("Previous Player Folds");
			if(round < 3) {
				round++;
			}
			else {
				currentCallAmount = 0;
				round = 1;
			}
			System.out.println();
			System.out.println("--------------Next Player--------------");
			System.out.println();
		}

	//Process round for each player per turn
		public void processRound(Player p) {
			for(Player c: player) {
				if(c.isActive == false) {
					foldCount++;
				}
			}
			if(foldCount == player.size()-1 ) {
				defaultWin = true;
				defaultWinner();
			}
			foldCount = 0;

			if(p.isActive == true ) {
				
				
				System.out.println("Turn: "+ turn +"          Player: "+ p.name);
				System.out.println("Account: $"+ p.a.getBalance() + "      Pot: $"+ pot );

				System.out.println("                  CurrCall: $"+ currentCallAmount );
				System.out.println();
				System.out.println("Your cards:");
				p.playerHand.readThrough();
				if((turn == 1 && pot == 0)) {
					System.out.println("Options:(1)Bet  (3)Fold");
				}else if(round == 3) {
					System.out.println("Options:(2)Call  (3)Fold");
				}
				else {
					System.out.println("Options:(1)Bet  (2)Call  (3)Fold");
				}
				System.out.println();
			}
			//Check if any players folded one more time
			for(Player c: player) {
				if(c.isActive == false) {
					foldCount++;
				}
			}
			if(foldCount == player.size()-1) {
				defaultWin = true;
				defaultWinner();
			}
			foldCount = 0;
			
		}
		public void checkAccount() {
			int size = player.size();
			for (int i = size - 1; i >= 0; i--) {
			    if(player.get(i).a.getBalance() <= 0){
			    	
			    	System.out.println("Player " + player.get(i).name+" Left");
			    	updateLog("Player " + player.get(i).name+" Left");
			    	player.remove(i);
					
			    }
			}
		}
	// Checks the card ranks and determines the winner
		public void determineWinner(){
			int rank = 0;
			int loop = 1;
			String winner = "";
			for(Player p: player) {
				if(p.isActive) {
					p.playerHand.setRanking();
				}
			}

			for(Player p: player) {
				for(Player c: player) {
					if(c.playerHand.handRank >= p.playerHand.handRank && p.name != c.name) {
						c.isWinner = true;
						p.isWinner = false;
						
					}
				}
				
			}
			int winners= 0;
			for(Player p: player) {

				if(p.isWinner == true) {
					winners++;
				}
			p.fold();
		}
			int newpot = pot / winners;
			for(Player p: player) {

					if(p.isWinner == true) {
						System.out.println("-------------------");
						System.out.println("Winner is "+ p.name);
					    updateLog("Winner is "+ p.name+" ,"+ p.name+ " Wins $"+ newpot);
						System.out.println(p.name+ " Wins $"+ newpot);
						System.out.println("-------------------");
						p.a.setBalance(p.a.getBalance() + newpot);
					}
				p.fold();
			}

			pot = 0;
			
			
			turn = 1;
			for(Player p: player) {
				p.isActive = true;
				p.isWinner = false;
				
			}
			createHands();
			newDeck();
			foldCount = 0;
			defaultWin = false;
			System.out.println("--------");
			System.out.println("New Turn");
			System.out.println("--------");
		
		}
		
	//If all other players fold, the default winner wins the pot
		public void defaultWinner() {
			for(Player p: player) {
				for(Player c: player) {
					if(c.isActive == false && p.isActive == true ) {
						p.a.setBalance(p.a.getBalance() + pot);
						System.out.println(p.name + "**WON**");
						updateLog("Winner is "+ p.name);
						p.fold();
					}
				}
				
			}
		pot = 0;
		
		turn = 1;
		createHands();
		foldCount = 0;
		defaultWin = false;
		newDeck();
		System.out.println("--------");
		System.out.println("New Turn");
		System.out.println("--------");
		}
		
			
	// Creates a new deck for the game when cards run low
		public void newDeck() {
			deck = new PokerDeck();
			deck.shuffle();
		}
		public void createHands() {
			
			for(Player p: player) {	
				ArrayList<Card> cards = new ArrayList<Card>();
				int i = 0; 
				while(i<5) {
					cards.add(deck.draw());
					i++;
				}
				p.playerHand.addToHand(cards);
				p.isActive = true;
			}
		
		}



}

