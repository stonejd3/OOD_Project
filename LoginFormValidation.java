import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class LoginFormValidation implements FormValidation {

    String[] inputs = {"#p1Name","#p2Name","#p3Name","#p4Name","#p5Name"};
    String[] names = new String[5];

    ArrayList<TextField> textFields = new ArrayList<>();
    Scene scene = null;

    public LoginFormValidation(Scene s){
        this.scene = s;
        for(int i = 0; i < inputs.length; i++){
            try {
                textFields.add((TextField) s.lookup(inputs[i]));
            } catch(NullPointerException e){
                System.out.println("Wrong inputs specified");
                System.out.println(e.getMessage());
            }
        }
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
        return counter >= 2;
    }

    public String get(String id){
        return ((TextField)this.scene.lookup(id)).getText();
    }

}
