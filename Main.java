import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.util.*;
import javafx.scene.image.*;
import javafx.scene.control.*;
import javafx.event.*;



public class Main extends Application implements Observer {

    PlayerView pv;
    public static Server server;
    public static ArrayList<String> names = new ArrayList<>();
    public static String deckType = "poker";
    public static int p = 0;    


    public void update(Observable observable, Object o){
        if(observable instanceof LoginFormValidation) {
            if (o instanceof String[]) {
                String[] s = (String[]) o;
                for (int i = 0; i < 5; i++)
                    if(s[i] != null){
                        names.add(s[i]);
                    }
                try {
                    deckType = s[5];
                    startGame(new Stage());

                } catch(Exception e){
                    System.out.println(e.getMessage());
                }


                System.out.print("\n");
            }
        } else if(observable instanceof GameFormValidation){
            if (o instanceof String) {
                String s = (String) o;
                System.out.print(s);
                System.out.print("\n");
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        pv = new PlayerView();
        pv.loadResources();
        pv.lfv.addObserver(this);
        pv.gfv.addObserver(this);


        // Set up the stage
        primaryStage.getIcons().add(new Image("images/icon.png"));
        primaryStage.setTitle("Game Login");
        primaryStage.setScene(pv.getView("login"));

        primaryStage.show();
    }
    
    public static void startGame(Stage primaryStage) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    
        Server test = new Server(names, deckType);
        test.processRound(test.player.get(p));  
        
        test.defaultWin = false;

        primaryStage.setTitle("GuiTest");
    HBox hbox2 = new HBox();
        Label label1 = new Label("Name: "+test.player.get(p).name);
        Label label2 = new Label("Turn: "+test.turn);
        Label label3 = new Label("Pot: $"+test.pot);
        Label label4 = new Label("Account: $"+test.player.get(p).a.getBalance());
        
        Label log = new Label("Game Started");
        
        hbox2.getChildren().clear();
        hbox2.getChildren().addAll(setCards(test.player.get(p)));           
        Button btn = new Button();
        btn.setText("Bet");
        btn.setLayoutX(100);
        btn.setLayoutY(10);
        
        Button btn2 = new Button();
        btn2.setText("Call");
        btn2.setLayoutX(300);
        btn2.setLayoutY(30);
        
        Button btn3 = new Button();
        btn3.setText("Fold");
        btn3.setLayoutX(250);
        btn3.setLayoutY(50);
        
        btn2.setVisible(false);
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
 //---------------Bet Method------------------------------
            @Override
            public void handle(ActionEvent event) {
                if(test.gameover == false) {
                    if(test.player.size() == 1) {

                        test.turn = 5;
                        System.out.println("Game Over");
                        test.updateLog("Game Over");
                        log.setText(test.getLog());
                    }

                    System.out.println("Bet");
                
                    test.playerBet(test.player.get(p));
                    if (p >= test.player.size()-1) {
                        p = 0;
                        test.turn++;
                    }else {
                        p++;    
                    }
                    if(test.player.get(p).isActive == false) {
                        p++;
                        if (p >= test.player.size()-1) {
                            p = 0;
                            test.turn++;
                        }
                    }
                    if(test.turn >3) {
                        try{
                        test.determineWinner();
                        } catch (Exception e) {}
                        test.checkAccount();
                        test.turn = 1;
                        if(test.player.size() == 1) {

                            test.turn = 5;
                            System.out.println("Game Over");
                            btn.setVisible(false);
                            btn2.setVisible(false);
                            btn3.setVisible(false);
                            test.gameover = true;
                            test.updateLog("Game Over");
                            log.setText(test.getLog());
                        }
                    }
                    if(test.currentCallAmount == 0|| test.pot == 0) {
                        btn2.setVisible(false);
                    }else {
                        btn2.setVisible(true);
                    }
                    try {
                    test.processRound(test.player.get(p));
            } catch (Exception e) {}
                    label1.setText("Name: "+test.player.get(p).name);
                    label2.setText("Turn: "+test.turn);
                    label3.setText("Pot: $"+test.pot);
                    label4.setText("Account: $"+test.player.get(p).a.getBalance());
                    log.setText(test.getLog());
                
                    hbox2.getChildren().clear();
                    hbox2.getChildren().addAll(setCards(test.player.get(p)));                   
                }
                
               
            }
        });
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
//-------------------------Call Method---------------------------------------------------------------           
            
            
            public void handle(ActionEvent event)  {
                if(test.gameover == false) {
                    if(test.player.size() == 1) {

                        test.turn = 5;
                        System.out.println("Game Over");
                        test.updateLog("Game Over");
                        log.setText(test.getLog());
                    }
                    System.out.println("Call");
                
                    test.playerCall(test.player.get(p));
                    if (p >= test.player.size()-1) {
                        p =0;
                        test.turn++;
                    }else {
                        p++;    
                    }
                    if(test.player.get(p).isActive == false) {
                        p++;
                        if (p >= test.player.size()-1) {
                            p = 0;
                            test.turn++;
                        }
                    }
                    if(test.turn > 3) {
                        try{
                        test.determineWinner();
                        } catch (Exception e) {}
                        test.turn = 1;
                        test.checkAccount();
                        if(test.player.size() == 1) {

                            test.turn = 5;
                            System.out.println("Game Over");
                            btn.setVisible(false);
                            btn2.setVisible(false);
                            btn3.setVisible(false);
                            test.gameover = true;
                            test.updateLog("Game Over");
                            log.setText(test.getLog());
                        }
                    }
                    if(test.currentCallAmount == 0|| test.pot == 0) {
                        btn2.setVisible(false);
                    }else {
                        btn2.setVisible(true);
                    }
                    try{
                    test.processRound(test.player.get(p));
                    } catch (Exception e) {}
                    label1.setText("Name: "+test.player.get(p).name);
                    label2.setText("Turn: "+test.turn);
                    label3.setText("Pot: $"+test.pot);
                    label4.setText("Account: $"+test.player.get(p).a.getBalance());
                    log.setText(test.getLog());
                    
                    hbox2.getChildren().clear();
                    hbox2.getChildren().addAll(setCards(test.player.get(p)));   
                    
                }
            }
        });
        
        
        
        

        btn3.setOnAction(new EventHandler<ActionEvent>() {
 //-------------------Fold Method---------------------------------------        
            
            
            public void handle(ActionEvent event) {
                if(test.gameover == false) {
                    if(test.player.size() == 1) {

                        test.turn = 5;
                        System.out.println("Game Over");
                    }
                    System.out.println("Fold");
                
        			test.playerFold(test.player.get(p));
                
        			if (p >= test.player.size()-1) {
        				p =0;
        				test.turn++;
        			}else {
        				p++;	
        			}
        			if(test.player.get(p).isActive == false) {
            			p++;
            			if (p >= test.player.size()-1) {
                			p = 0;
                			test.turn++;
            			}
            		}
        			if(test.turn > 3) {
        			        try{
        				test.determineWinner();
        				} catch (Exception e) {}
        				test.turn = 1;
        				test.checkAccount();
        				if(test.player.size() == 1) {

        					test.turn = 5;
        					System.out.println("Game Over");
            				btn.setVisible(false);
            				btn2.setVisible(false);
            				btn3.setVisible(false);
            				test.gameover = true;
            				test.updateLog("Game Over");
                			log.setText(test.getLog());
        				}
        			}
        			if(test.currentCallAmount == 0 || test.pot == 0) {
            			btn2.setVisible(false);
            		}else {
            			btn2.setVisible(true);
            		}
        			try{
            		        test.processRound(test.player.get(p));
            		        } catch (Exception e) {}
        			label1.setText("Name: "+test.player.get(p).name);
        			label2.setText("Turn: "+test.turn);
        			label3.setText("Pot: $"+test.pot);
        			label4.setText("Account: $"+test.player.get(p).a.getBalance());
        			log.setText(test.getLog());
					
					hbox2.getChildren().clear();
					hbox2.getChildren().addAll(setCards(test.player.get(p)));	
					
					
        		}
        	}
        });
        
        label1.setFont(Font.font ("Verdana", 20));
        label2.setFont(Font.font ("Verdana", 20));
        label3.setFont(Font.font ("Verdana", 20));
        label4.setFont(Font.font ("Verdana", 20));
        log.setFont(Font.font ("Verdana", 20));
        
        HBox hbox = new HBox(btn, btn2, btn3,label1,label2,label3,label4);
        hbox.setSpacing(10);
		
        HBox hbox3 = new HBox(log);
		
		VBox vbox = new VBox(hbox2, hbox, hbox3);
		vbox.setSpacing(10);
		
		
        Scene scene = new Scene(vbox, 955, 350);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }	

	    public static ArrayList<ImageView> setCards(Player p){

		ArrayList<ImageView> imageViews = new ArrayList<>();
        for(Card c : p.playerHand.hand) {
            String str = "images/" + c.suit.toString().toUpperCase() + "_" + c.name.toUpperCase() + ".PNG";
            imageViews.add(new ImageView(new Image(str)));
        }
		return imageViews;
    }
	
}
