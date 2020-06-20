package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server {

    ServerSocket serverSocket;
    boolean test=false;
    ArrayList<MultiServerConnection> domainsConnection=new ArrayList<MultiServerConnection>();

    public static void main(String[] args) {
        new Server();
    }

    public Server() {
        try{
            serverSocket=new ServerSocket(1111);
            while(!test){
                Socket socket=serverSocket.accept();
                MultiServerConnection connection = new MultiServerConnection(socket,this);
                connection.start();
                domainsConnection.add(connection);
            }
        } catch(IOException exception){
            exception.printStackTrace();
        }
    }
}
