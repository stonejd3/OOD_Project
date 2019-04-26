import javafx.scene.Scene;

import java.util.Observable;

public class GameFormValidation extends Observable implements FormValidation {

    Scene scene;

    public GameFormValidation(Scene s){
        this.scene = s;
    }

    public String get(String id){
        return "";
    }

    public boolean validate(){
        return true;
    }

    public void buttonPressed(String button){
        this.setChanged();
        this.notifyObservers(button);
    }

    public void setChanged(){
        super.setChanged();
    }

    public void clearChanged(){
        super.clearChanged();
    }

}

