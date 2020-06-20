package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MultiClients extends Thread{
    Socket socket;
    DataInputStream dataIn;
    DataOutputStream dataOut;
    boolean test=false;
    public ClientData clientData;
    public ChatInterface chatInterface;

    public MultiClients(Socket multiSocket, ChatInterface chatInterface)
    {
        socket =multiSocket;
        clientData=new ClientData();
        this.chatInterface =chatInterface;
    }
    public void ClientOutServerIn(String Text)
    {
        try {
            if(Text.equals("change channel"))
            {
                System.out.print("sending changing channel: "+Text+"\n");
                dataOut.writeUTF(Text);
                dataOut.flush();
            }
            else if(Text.equals("new user"))
            {
                System.out.print("sending new user: "+ Text+"\n");
                dataOut.writeUTF(Text+":"+clientData.GetName()+"="+clientData.GetChannel());
                dataOut.flush();
            }
            else
            {
                dataOut.writeUTF(clientData.GetChannel()+"="+this.getName()+": "+Text);
                dataOut.flush();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    public void SetClient(String channel,String Name)
    {
        clientData.SetName(Name);
        clientData.SetChannel(channel);
    }
    public void run()
    {
        try {
            dataIn =new DataInputStream(socket.getInputStream());
            dataOut =new DataOutputStream(socket.getOutputStream());
            while(!test)
            {
                try {
                    while(dataIn.available()==0)
                    {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException exception) {
                            exception.printStackTrace();
                        }
                    }
                    String reply= dataIn.readUTF();
                    String Chan=ExtractChannel(reply);
                    String name=ExtractName(reply);

                    if(name.equals("new user"))
                    {
                        System.out.print("new user in body: "+reply+"\n");
                        setChannel(reply);
                    }
                    else
                    {
                        PrintReply(Chan,reply);
                    }
                } catch (IOException exception) {
                    exception.printStackTrace();
                    try {
                        dataIn.close();
                        dataOut.close();
                        socket.close();
                    } catch (IOException exceptionException) {
                        exceptionException.printStackTrace();
                    }
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
            try {
                dataIn.close();
                dataOut.close();
                socket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void CloseClient()
    {
        try {
            dataIn.close();
            dataOut.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String ExtractName(String x)
    {
        String[]Y=x.split(":");
        return Y[0];
    }
    public String ExtractChannel(String X)
    {
        String[]Y=X.split("=");
        return Y[0];
    }
    public void PrintReply(String Chan,String Rep)
    {
        if(clientData.GetChannel().equals(Chan))
        {
            String []Y=Rep.split("=");
            chatInterface.setDisplay(Y[1]);
        }

    }
    public void setChannel(String x)
    {
        String []Y=x.split(":");
        String []Z=Y[1].split("=");
        System.out.print("setting "+Z[0]+" channel to "+Z[1]+"\n");
        chatInterface.setUserInChannel(Z[0]);
    }
    public void setChangedChannel()
    {
        chatInterface.setUserInChannel(clientData.GetName()+": "+clientData.GetChannel());
    }
}
