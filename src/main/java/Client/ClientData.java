package Client;

public class ClientData {
    public String clientName;
    public String channel;

    public void SetChannel(String channel) {
        this.channel=channel;
    }
    public void SetName(String clientName) {
        this.clientName=clientName;
    }
    public String GetChannel() {
        return channel;
    }
    public String GetName() {
        return clientName;
    }
}
