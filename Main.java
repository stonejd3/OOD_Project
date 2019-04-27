import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Main extends Application implements Observer {

    PlayerView pv;
    Server server;
    ArrayList<String> names = new ArrayList<>();

    public void update(Observable observable, Object o){
        if(observable instanceof LoginFormValidation) {
            if (o instanceof String[]) {
                String[] s = (String[]) o;
                for (int i = 0; i < s.length; i++)
                    if(s[i] != null){
                        names.add(s[i]);
                    }
                try {
                    server = new Server(names);
                    server.run();
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

}
