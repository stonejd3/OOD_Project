import java.util.Observer;

public class Account {

    private int id;
    private int balance;
    public ObservableAccount observableAccount;

    public Account(int id, int balance){
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String toString(){
        return "Account ID: " + this.getId() + "\t Balance: " + this.getBalance();
    }

    public void addObserver(Observer o){
        observableAccount.addObserver(o);
        // Give the new observer current state
        observableAccount.setChanged();
        observableAccount.notifyObservers(this.getBalance());
    }

    public void deleteObserver(Observer o){
        observableAccount.deleteObserver(o);
    }
}
