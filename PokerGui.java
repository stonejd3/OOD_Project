import java.util.ArrayList;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class PokerGui extends Application {
    
    public static ArrayList<String> names = new ArrayList();
    public static String deckType;
    public static void main(String[] args) {
        
        for(int i = 0; i < args.length-1; i++){
            names.add(args[i]);
        }
        int i = (args.length-1);
        deckType = args[i];
        launch(args);
        
        
    }
    public int p = 0;   
    
    @Override
    public void start(Stage primaryStage)throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        
        Server test = new Server(names,deckType);
        test.processRound(test.player.get(p));  
        
        test.defaultWin = false;

        primaryStage.setTitle("GuiTest");
        Label label1 = new Label("Name: "+test.player.get(p).name);
        Label label2 = new Label("Turn: "+test.turn);
        Label label3 = new Label("Pot: "+test.pot);
        Label label4 = new Label("Account: "+test.player.get(p).a.getBalance());
        Button btn = new Button();
        btn.setText("Bet'");
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
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
 //---------------Bet Method------------------------------
            @Override
            public void handle(ActionEvent event) {
                if(test.gameover == false) {
                    if(test.player.size() == 1) {

                        test.turn = 5;
                        System.out.println("Game Over");
                    }

                    System.out.println("Bet");
                
                    test.playerBet(test.player.get(p));
                    if (p >= test.player.size()-1) {
                        p = 0;
                        test.turn++;
                    }else {
                        p++;    
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
                        }
                    }
                    try{
                    test.processRound(test.player.get(p));
                    } catch (Exception e) {}
                    label1.setText("Name: "+test.player.get(p).name);
                    label2.setText("Turn: "+test.turn);
                    label3.setText("Pot: "+test.pot);
                    label4.setText("Account: "+test.player.get(p).a.getBalance());
                }
                
               
            }
        });
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
//-------------------------Call Method---------------------------------------------------------------           
            
            
            public void handle(ActionEvent event) {
                if(test.gameover == false) {
                    if(test.player.size() == 1) {

                        test.turn = 5;
                        System.out.println("Game Over");
                    }
                    System.out.println("Call");
                
                    test.playerCall(test.player.get(p));
                    if (p >= test.player.size()-1) {
                        p =0;
                        test.turn++;
                    }else {
                        p++;    
                    }if(test.turn > 3) {
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
                        }
                    }
                    try{
                    test.processRound(test.player.get(p));
                    } catch (Exception e) {}
                    label1.setText("Name: "+test.player.get(p).name);
                    label2.setText("Turn: "+test.turn);
                    label3.setText("Pot: "+test.pot);
                    label4.setText("Account: "+test.player.get(p).a.getBalance());
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
        				}
        			}
        			try{
        			test.processRound(test.player.get(p));
        			} catch (Exception e) {}
        			label1.setText("Name: "+test.player.get(p).name);
        			label2.setText("Turn: "+test.turn);
        			label3.setText("Pot: "+test.pot);
        			label4.setText("Account: "+test.player.get(p).a.getBalance());
        		}
        	}
        });
        
        
        
        HBox hbox = new HBox(btn, btn2, btn3,label1,label2,label3,label4);
        hbox.setSpacing(10);

        Scene scene = new Scene(hbox, 500, 100);
        
        primaryStage.setScene(scene);
        primaryStage.show();
       // StackPane root = new StackPane();
      //  root.getChildren().add(btn);
      //  root.getChildren().add(btn2);
      //  root.getChildren().add(btn3);
      //  primaryStage.setScene(new Scene(root, 300, 250));
      //  primaryStage.show();
    }
}