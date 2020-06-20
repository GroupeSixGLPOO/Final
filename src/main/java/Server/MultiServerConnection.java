package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MultiServerConnection extends Thread {
    Socket socket;
    DataInputStream dataIn;
    DataOutputStream dataOut;
    Server server;
    boolean test=false;

    public MultiServerConnection(Socket socket,Server server){
        super("MultiServerConnection");
        this.socket=socket;
        this.server=server;
    }

    public void ServerOutClientIn(String outText){
        try {
            long threadID = this.getId();
            dataOut.writeUTF(outText);
            dataOut.flush();
        }catch(IOException exception) {
            exception.printStackTrace();
        }
    }

    public void ServerOutAllClientIn(String outText){
        for(int i=0;i<server.domainsConnection.size();i++){
            MultiServerConnection connection=server.domainsConnection.get(i);
            connection.ServerOutClientIn(outText);
        }
    }

    public void run(){
        try{
            dataIn=new DataInputStream(socket.getInputStream());
            dataOut=new DataOutputStream(socket.getOutputStream());

            while(!test){
                while(dataIn.available()==0){
                    try{
                        Thread.sleep(1);
                    }catch(InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
                String comingText=dataIn.readUTF();
                ServerOutAllClientIn(comingText);
            }
            dataIn.close();
            dataOut.close();
            socket.close();
        }catch(IOException exception){
            exception.printStackTrace();
        }
    }
}
