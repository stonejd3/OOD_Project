//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.stage.*;
//import javafx.scene.*;
//import javafx.scene.image.Image;
//import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class Server /*extends Application*/ {

	//---------------------------------------Variables------------------------------------------------------------
    
	   public static ArrayList<Player> player = new ArrayList();
	   
	   public static int turn = 1;
	   
	   public static int pot = 0;
	   
	   public static boolean defaultWin = false;
	   
	   public static int lastBet = 0;
	   
	   public static int foldCount = 0;
	   
	   public static PokerDeck deck = new PokerDeck();
	   
		public static Scanner s = new Scanner(System.in);
		
		public static int currentPot = 0;
		
	//----------------------------------Individual Methods--------------------------------------------------------
		
		
		public static void setup(ArrayList<String> names) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
			System.out.println("Initiated");
			boolean condition = true;
			deck.shuffle();
			int playerNum = 1;
	      
			for(String n: names){
	      		Player p1 = new Player();
	      		p1.name = "Player 1:"+ n;
	      		player.add(p1);
	      		p1.fold();
				System.out.println("P"+playerNum+ " Created");
				playerNum++;
			}
	      	for(Player p: player) {
				p.isActive = true;
			}
			createHands();
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

			if(p.isActive == true && defaultWin == false) {
				
				
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

	// Checks the card ranks and determines the winner
		public static void determineWinner(){
			int rank = 0;
			int loop = 1;
			String winner = "";
			for(Player p: player) {
				p.playerHand.setRanking();
			}
			while(loop <= 2)
				for(Player p: player) {
					if(rank < p.playerHand.handRank) {
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
			}
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
		
		createHands();
		foldCount = 0;
		defaultWin = false;
		System.out.println("--------");
		System.out.println("New Turn");
		System.out.println("--------");
		}
		
	// Creates a new deck for the game when cards run low
		public static void newDeck() {
			deck = new PokerDeck();
			deck.shuffle();
		}
		
	// Creates hands for the list of players
		public static void createHands() {
			for(Player p: player) {
			
				p.fold();
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    //Parent loginScreen = null;
    LoginFormValidation loginFormValidation = null;

    //@Override
    /*public void start(Stage primaryStage) throws Exception {

        // Load XML file for player login
        try {
            loginScreen = FXMLLoader.load(getClass().getResource("resources/Login.fxml"));
        } catch(NullPointerException e){

            System.out.println("Invalid XML Filename!");
            System.out.println(e.getMessage());
            System.exit(1);
        }

        // Set up the stage
        primaryStage.getIcons().add(new Image("images/icon.png"));
        primaryStage.setTitle("Game Login");
        primaryStage.setScene(new Scene(loginScreen));

        // Grab the button objects (since generated through xml)
        Button exitButton = (Button) primaryStage.getScene().lookup("#exitButton");
        Button joinButton = (Button) primaryStage.getScene().lookup("#joinButton");

        // Join Button Handler
            joinButton.setOnAction(e->  {
            loginFormValidation = new LoginFormValidation(primaryStage.getScene());
            if(loginFormValidation.validate()){
                for(int i = 0; i < 5; i++){
                    System.out.print(loginFormValidation.names[i] + "\t");
                }
                System.out.print("\n");
                primaryStage.hide();

            }
        });

        // Exit Button Handler
        exitButton.setOnAction(e->System.exit(0));

        // Show Stage
        primaryStage.show();

    }*/


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
