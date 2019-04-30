import java.util.*;
public class Facade2{
    // instance variables
    PlayerView pv;
    Server server;
    ArrayList<String> names = new ArrayList<String>();
    
    
    public Facade2(){
        //server = new Server();
    }
    public void create()throws InstantiationException, IllegalAccessException, ClassNotFoundException{
        System.out.println("Enter player names or END");
        Scanner s = new Scanner(System.in);
        String newPlayerName = s.nextLine();
        while(names.size() <= 5 || newPlayerName !="END"){
            names.add(newPlayerName);
            System.out.println("Enter next player name: ");
            newPlayerName = s.nextLine();
        }
        if(names.size()<2){
            //server.setup(names);
        } else{
            System.out.println("Not enough players ending");
            System.exit(0);
        }
    }
    
}
