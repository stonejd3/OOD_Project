import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class PlayerView {

    Scene loginScreen = null;
    Scene gameScreen = null;
    ArrayList<ImageView> imageViews = new ArrayList<>();

    boolean loadResources() throws Exception{

        // Load XML file for player login
        try {

            loginScreen = new Scene(FXMLLoader.load(getClass().getResource("resources/Login.fxml")));
            gameScreen = new Scene(FXMLLoader.load(getClass().getResource("resources/Game.fxml")));

            String[] imageViewNames = {"card0View","card1View","card2View","card3View","card4View","card5View"};

            for(int i = 0; i < imageViewNames.length; i++){
                imageViews.add((ImageView) gameScreen.lookup("#"+imageViewNames[i]));
            }

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
