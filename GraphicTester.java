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
 
public class GraphicTester /*extends Application*/ {
    /*public static void main(String[] args) {
        launch(args);
    }
    public int p = 0;	
    @Override
    public void start(Stage primaryStage)throws InstantiationException, IllegalAccessException, ClassNotFoundException {

    	ArrayList<String> names = new ArrayList();
    	boolean condition = true;
    	
    	names.add("John");
    	names.add("James");
    	names.add("Jane");
    	
    	Server test = new Server(names);
    	System.out.println(test.player.size()-1);
    	test.processRound(test.player.get(p));	
    	
    	test.defaultWin = false;

        primaryStage.setTitle("GuiTest");
        Label label1 = new Label("Name:"+test.player.get(p).name);
        Label label2 = new Label("Turn"+test.turn);
        Label label3 = new Label("Pot"+test.pot);
        Button btn = new Button("Account"+test.player.get(p).a);
        btn.setText("Bet'");
        btn.setLayoutX(100);
        btn.setLayoutY(10);
        btn.setOnAction(new EventHandler<ActionEvent>() {
 //---------------Bet Method------------------------------
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Bet");
                
                test.playerBet(test.player.get(p));
                if (p >= test.player.size()-1) {
                	p = 0;
                	test.turn++;
                }else {
                	p++;	
                }
                if(test.turn >=3) {
                	test.determineWinner();
                	test.turn = 1;
                }
                test.processRound(test.player.get(p));
                label1.setText("Name:"+test.player.get(p).name);
                label2.setText("Turn"+test.turn);
                label3.setText("Pot"+test.pot);
                
               
            }
        });
        Button btn2 = new Button();
        btn2.setText("Call");
        btn2.setLayoutX(300);
        btn2.setLayoutY(30);
        btn2.setOnAction(new EventHandler<ActionEvent>() {
//-------------------------Call Method---------------------------------------------------------------       	
        	
        	
        	public void handle(ActionEvent event) {
                System.out.println("Call");
                
                	test.playerCall(test.player.get(p));
                if (p >= test.player.size()-1) {
                	p =0;
                	test.turn++;
                }else {
                	p++;	
                }if(test.turn >=3) {
                	test.determineWinner();
                	test.turn = 1;
                }
                test.processRound(test.player.get(p));
                label1.setText("Name:"+test.player.get(p).name);
                label2.setText("Turn"+test.turn);
                label3.setText("Pot"+test.pot);
            }
        });
        
        
        
        
        Button btn3 = new Button();
        btn3.setText("Fold");
        btn3.setLayoutX(250);
        btn3.setLayoutY(50);
        btn3.setOnAction(new EventHandler<ActionEvent>() {
 //-------------------Fold Method---------------------------------------      	
        	
        	
        	public void handle(ActionEvent event) {
                System.out.println("Fold");
                
                test.player.get(p).fold();
                
                if (p >= test.player.size()-1) {
                	p =0;
                	test.turn++;
                }else {
                	p++;	
                }
                if(test.turn >=3) {
                	test.determineWinner();
                	test.turn = 1;
                }
                test.processRound(test.player.get(p));
                label1.setText("Name:"+test.player.get(p).name);
                label2.setText("Turn"+test.turn);
                label3.setText("Pot"+test.pot);
            }
        });
        
        
        
        HBox hbox = new HBox(btn, btn2, btn3,label1,label2,label3);
        hbox.setSpacing(10);

        Scene scene = new Scene(hbox, 400, 100);
        
        primaryStage.setScene(scene);
        primaryStage.show();
       // StackPane root = new StackPane();
      //  root.getChildren().add(btn);
      //  root.getChildren().add(btn2);
      //  root.getChildren().add(btn3);
      //  primaryStage.setScene(new Scene(root, 300, 250));
      //  primaryStage.show();
    }*/
}