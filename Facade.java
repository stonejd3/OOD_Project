import java.util.*;
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.image.Image;

import java.util.Observable;
import java.util.Observer;
import java.util.*;
public class Facade extends Application implements Observer{
    // instance variables
    PlayerView pv;
    Server server;
    ArrayList<String> names = new ArrayList<String>();
    
    /**
     * Constructor for objects of class Facade
     */
    public Facade(){
        
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
    
    public void createServer(Observable observable, Object o){
        
    }
    
    public void update(Observable observable, Object o){
        if(observable instanceof LoginFormValidation) {
            if (o instanceof String[]) {
                String[] s = (String[]) o;
                for (int i = 0; i < s.length; i++)
                    if(s[i] != null){
                        names.add(s[i]);
                    }
                try {
                    //server = new Server();
                    //server.setup(names);
                    //server.run();
                } catch(Exception e){
                    System.out.println(e.getMessage());
                }
                
            }
         }
    }
}
