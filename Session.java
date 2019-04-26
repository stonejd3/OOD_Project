public class Session {
    String name, serverIp, localIp;

    public Session(String name, String serverIp, String localIp){
        this.name = name;
        this.serverIp = serverIp;
        this.localIp = localIp;
    }

    public String getName() {
        return name;
    }

    public String getServerIp() {
        return serverIp;
    }

    public String getLocalIp() {
        return localIp;
    }

    @Override
    public String toString(){
        return this.getName() + "\n" + this.serverIp + "\n" + this.getLocalIp();
    }

}
