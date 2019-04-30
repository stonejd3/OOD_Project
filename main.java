import java.util.*;
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.image.Image;

import java.util.Observable;
import java.util.Observer;
import java.util.*;
public class Main extends Application implements Observer{
    static Facade testFacade = new Facade();
    PlayerView pv;
    Server server;
    ArrayList<String> names = new ArrayList<String>();
    public void main(String[] args)throws InstantiationException,
    IllegalAccessException, ClassNotFoundException, RuntimeException{
        launch(args);
        
    }
    
    public void update(Observable observable, Object o){
        testFacade.createServer(observable, o);
        testFacade.update(observable, o);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        testFacade.start(primaryStage);
    }
    
}
