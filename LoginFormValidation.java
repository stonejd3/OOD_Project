import javafx.scene.Scene;
import javafx.scene.control.*;
import java.util.ArrayList;
import java.util.Observable;

public class LoginFormValidation extends Observable implements FormValidation {

    String[] inputs = {"#p1Name","#p2Name","#p3Name","#p4Name","#p5Name"};
    String[] names = new String[6];

    ArrayList<TextField> textFields = new ArrayList<>();
	Button joinButton;
    Scene scene = null;
    TextField deckType;

    public void setChanged(){
        super.setChanged();
    }

    public void clearChanged(){
        super.clearChanged();
    }

    public LoginFormValidation(Scene s){
        this.scene = s;
        for(int i = 0; i < inputs.length; i++){
            try {
                textFields.add((TextField) s.lookup(inputs[i]));
                deckType = (TextField) s.lookup("#deckType");
            } catch(NullPointerException e){
                System.out.println("Wrong inputs specified");
                System.out.println(e.getMessage());
            }
        }
		
		joinButton = (Button) s.lookup("#joinButton");
		
    }

    public boolean validate(){
        int counter = 0;
        for(int i = 0; i < textFields.size(); i++){
            if(textFields.get(i).getText().equals("")){
                textFields.get(i).setStyle("-fx-control-inner-background: red;");
            } else {
                textFields.get(i).setStyle("-fx-control-inner-background: green;");
                names[i] = textFields.get(i).getText();
                counter++;
            }
        }

        if(counter >=2){

            if(deckType.getText().equals("")){

                deckType.setStyle("-fx-control-inner-background: red;");
                return false;

            } else if(deckType.getText().toLowerCase().contains("spanish")){

                names[5] = "Spanish";

            } else {

                names[5] = "Poker";

            }

            System.out.println(names[5]);

            this.setChanged();
            this.notifyObservers(names);
			joinButton.setDisable(true);

        }


        return counter >= 2;
    }

    public String get(String id){
        return ((TextField)this.scene.lookup(id)).getText();
    }

}