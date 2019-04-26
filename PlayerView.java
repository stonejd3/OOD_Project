import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class PlayerView {

    Scene loginScreen = null;
    Scene gameScreen = null;
    LoginFormValidation lfv;
    GameFormValidation gfv;

    ArrayList<ImageView> imageViews = new ArrayList<>();

    Button exitButton, joinButton, foldButton, callButton, betButton;

    boolean loadResources() throws Exception{

        // Load XML file for player login
        try {

            loginScreen = new Scene(FXMLLoader.load(getClass().getResource("resources/Login.fxml")));
            gameScreen = new Scene(FXMLLoader.load(getClass().getResource("resources/Game.fxml")));

            lfv = new LoginFormValidation(loginScreen);
            gfv = new GameFormValidation(gameScreen);
            String[] imageViewNames = {"card0View","card1View","card2View","card3View","card4View","card5View"};

            for(int i = 0; i < imageViewNames.length; i++){
                imageViews.add((ImageView) gameScreen.lookup("#"+imageViewNames[i]));
            }

            // Extract buttons from template
            exitButton = (Button) loginScreen.lookup("#exitButton");
            joinButton = (Button) loginScreen.lookup("#joinButton");
            betButton = (Button) gameScreen.lookup("#betButton");
            foldButton = (Button) gameScreen.lookup("#foldButton");
            callButton = (Button) gameScreen.lookup("#callButton");

            // Set up button handlers
            exitButton.setOnAction(e->System.exit(0));
            joinButton.setOnAction(e->lfv.validate());
            betButton.setOnAction(e->gfv.buttonPressed("bet"));
            foldButton.setOnAction(e->gfv.buttonPressed("fold"));
            callButton.setOnAction(e->gfv.buttonPressed("call"));


            return true;

        } catch(NullPointerException e){

            System.out.println("Invalid XML Filename!");
            System.out.println(e.getMessage());
            System.exit(1);

            return false;

        }

    }

    Scene getView(String viewName){
        return (viewName == "login")? loginScreen : gameScreen;
    }

    void setCards(Hand h){

        int i = 0;
        for(Card c : h.hand) {
            String str = "images/" + c.suit.toString().toUpperCase() + "_" + c.name.toUpperCase() + ".PNG";
            //ImageView temp = new ImageView();
            //temp.setImage(new Image(str));

            System.out.println(str);
            imageViews.get(i).setImage(new Image(str));
            i++;
        }

    }



}
