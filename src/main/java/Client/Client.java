package Client;

import javax.swing.*;
import java.util.Scanner;

public class Client {

    MultiClients clientThread;

    public static void main(String[] args){
        new Client();
    }

    public Client(){
        ChatInterface chatInterface = new ChatInterface();
        chatInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chatInterface.setSize(500,500);
        chatInterface.setVisible(true);
    }

    public void ListenForInput(){
        Scanner console = new Scanner(System.in);

        while(true){
            while(!console.hasNextLine()){
                try{
                    Thread.sleep(1);
                }catch(InterruptedException exception){
                    exception.printStackTrace();
                }
            }

            String input = console.nextLine();
            if(input.toLowerCase().equals("quit")){
                break;
            }
            if(input.toLowerCase().equals("change channel")){
                input = console.nextLine();
                clientThread.clientData.SetChannel(input);
            }else{
                clientThread.ClientOutServerIn(input);
            }
        }
        clientThread.CloseClient();
    }
}
