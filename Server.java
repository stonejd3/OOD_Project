
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class Server {

	//---------------------------------------Variables------------------------------------------------------------
    
	public static ArrayList<Player> player = new ArrayList();
	   
	public static int turn = 1;
	   
	public static int pot = 0;
	   
	public static boolean defaultWin = false;
	   
	public static int lastBet = 0;
	   
	public static int foldCount = 0;
	   
	public static Scanner s = new Scanner(System.in);
		
	public static int currentPot = 0;
	
	public static Deck deck;
		
	//----------------------------------Individual Methods--------------------------------------------------------
		
		
		public static void setup(ArrayList<String> names) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
			
			DeckFactory df =  DeckFactory.getBuilder();
			String deckClass = "Poker";
			df.setClass(deckClass);
			Deck deck = df.buildDeck();



			
			
			
			
			
			System.out.println("Initiated");
			boolean condition = true;
			deck.shuffle();
			int playerNum = 1;
	      
			for(String n: names){
	      		Player p1 = new Player(deck);
	      		p1.name = n;
	      		player.add(p1);
				System.out.println("P"+playerNum+ " Created");
				playerNum++;
			}
			
			System.out.println("Cleared Decks");
			System.out.println("Created Player Hands");
			System.out.println();
			System.out.println("----------");
			System.out.println("Begin Game");
			System.out.println("----------");
				
	      }

	//Process round for each player per turn
		public static void processRound(Player p) {
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
				System.out.println("Account: $"+ p.a.getBalance() + "                Pot: $"+ pot );
				System.out.println();
				System.out.println("Your cards:");
				p.playerHand.readThrough();
				if(turn == 1 && pot == 0) {
					System.out.println("Options:(1)Bet  (3)Fold");
				}else {
					System.out.println("Options:(1)Bet  (2)Call  (3)Fold");
				}
				int r = s.nextInt();
				switch(r) {
					case 1: 
						if(p.validBet == true) {
							p.raise(currentPot, 5);
							currentPot+=5;
							System.out.println("You bet $"+ 5);
							pot += currentPot;
						}
						break;
					
					case 2: 
						if(currentPot == 0) {
							System.out.println("You check");
							
						}else if(p.validBet == true) {
							p.call(currentPot);
							pot += 5;
							System.out.println("You call $"+ currentPot);
							currentPot += 5;
							
						}
						break;
						
					case 3: 
						p.fold();
						System.out.println("You Fold");
						break;
						
					default:

					}

				System.out.println();
			}
			//Check if any players folded one more time
			System.out.println("Test");
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

	// Checks the card ranks and determines the winner
		public static void determineWinner(){
			int rank = 0;
			int loop = 1;
			String winner = "";
			for(Player p: player) {
				if(p.isActive) {
					p.playerHand.setRanking();
				}
			}
			while(loop <= 2)
				for(Player p: player) {
					if(rank < p.playerHand.handRank && p.isActive) {
						winner = p.name;
						if(loop == 2 && winner == p.name) {
							p.a.setBalance(p.a.getBalance() + pot);
							System.out.println("Winner is ...");
						}
					}
				
					
			}
			pot = 0;
			
			
			turn = 1;
			for(Player p: player) {
				p.isActive = true;
				p.createHands(deck);
			}
			newDeck();
			foldCount = 0;
			defaultWin = false;
			System.out.println("--------");
			System.out.println("New Turn");
			System.out.println("--------");
		
		}
		
	//If all other players fold, the default winner wins the pot
		public static void defaultWinner() {
			for(Player p: player) {
				for(Player c: player) {
					if(c.isActive == false && p.isActive == true ) {
						p.a.setBalance(p.a.getBalance() + pot);
					}
				}
		}
		pot = 0;
		
		turn = 1;
		for(Player p: player) {
			p.createHands(deck);
		}
		foldCount = 0;
		defaultWin = false;
		newDeck();
		System.out.println("--------");
		System.out.println("New Turn");
		System.out.println("--------");
		}
		
	// Creates a new deck for the game when cards run low
		public static void newDeck() {
			deck = new PokerDeck();
			deck.shuffle();
		}
	
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        run();
    }

	private static void run() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		ArrayList<String> names = new ArrayList();
		boolean condition = true;
		
		names.add("John");
		names.add("James");
		names.add("Jane");
		
		setup(names);
		
		defaultWin = false;
		while(condition == true) {
			while(turn <= 3) {
				for(Player p: player) {
				//--------------If all other players fold, default winner-----------------------------
				// Start New Round	
					processRound(p);
					
				}
				currentPot = 0;
				turn++;	
				if(turn > 3 && defaultWin == false) {
				
					determineWinner();
					turn = 1;
				}else if(defaultWin == true) {
					defaultWinner();
				}
					
			}
		}
	}

	
	
	
	
	
	
	
	
	
	

	    

	

}
