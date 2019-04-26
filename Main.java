import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.image.Image;
import java.util.ArrayList;

public class Main extends Application {
    PlayerView pv;
    LoginFormValidation loginFormValidation = null;
    Hand hand;

    @Override
    public void start(Stage primaryStage) throws Exception {
        pv = new PlayerView();
        pv.loadResources();

        // Set up the stage
        primaryStage.getIcons().add(new Image("images/icon.png"));
        primaryStage.setTitle("Game Login");
        primaryStage.setScene(pv.getView("game"));

        // Create a hand
        ArrayList<Card> list = new ArrayList<>();
        list.add(new Card("Ace",11,Card.Suit.Heart));
        list.add(new Card("Two",2,Card.Suit.Club));
        list.add(new Card("Three",3,Card.Suit.Spade));
        list.add(new Card("Four",4,Card.Suit.Club));
        list.add(new Card("Five",5,Card.Suit.Diamond));

        hand = new Hand();
        hand.addToHand(list);

        // Pass hand to the GUI
        pv.setCards(hand);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
