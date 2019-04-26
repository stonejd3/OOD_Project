import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Main extends Application implements Observer {

    PlayerView pv;
    ArrayList<String> names = new ArrayList<>();

    public void update(Observable observable, Object o){
        if(observable instanceof LoginFormValidation) {
            if (o instanceof String[]) {
                String[] s = (String[]) o;
                for (int i = 0; i < s.length; i++)
                        names.add(s[i]);

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
        primaryStage.setScene(pv.getView("game"));
        primaryStage.show();
    }

}
