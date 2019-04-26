import java.util.Observable;

public class ObservableAccount extends Observable{

    public void setChanged(){
        super.setChanged();
    }

    public void clearChanged(){
        super.clearChanged();
    }

}
