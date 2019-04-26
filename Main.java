import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.control.*;

import java.util.Observable;
import java.util.Observer;

public class Main extends Application {


    Parent loginScreen = null;
    LoginFormValidation loginFormValidation = null;

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Load XML file for player login
        try {
            loginScreen = FXMLLoader.load(getClass().getResource("resources/Login.fxml"));
        } catch(NullPointerException e){

            System.out.println("Invalid XML Filename!");
            System.out.println(e.getMessage());
            System.exit(1);
        }

        // Set up the stage
        primaryStage.getIcons().add(new Image("images/icon.png"));
        primaryStage.setTitle("Game Login");
        primaryStage.setScene(new Scene(loginScreen));

        // Grab the button objects (since generated through xml)
        Button exitButton = (Button) primaryStage.getScene().lookup("#exitButton");
        Button joinButton = (Button) primaryStage.getScene().lookup("#joinButton");

        // Join Button Handler
            joinButton.setOnAction(e->  {
            loginFormValidation = new LoginFormValidation(primaryStage.getScene());
            if(loginFormValidation.validate()){
                for(int i = 0; i < 5; i++){
                    System.out.print(loginFormValidation.names[i] + "\t");
                }
                System.out.print("\n");
                primaryStage.hide();

            }
        });

        // Exit Button Handler
        exitButton.setOnAction(e->System.exit(0));

        // Show Stage
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

}
