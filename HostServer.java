package ChatApp;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HostServer
{
    ArrayList<GuestClient> clients;


    /* We need to be able to access this class with having record which can
     * be done by using static variables.  Here it is declared. */

    public HostServer() //Constructor
    {
        clients = new ArrayList<>();

        HostServer instance = this;
    }

    public void connect(GuestClient c)
    {
        clients.add(c);
    }

    public void run()
    {
        while(true)
        {
            //loop clients - check if they have messages - get messages - send messages
            if(clients.get(0).hasMessage())
            {
                System.out.println(" client 0 got a message");
                broadcast(clients.get(0).getMessage());
            }
            if(clients.get(1).hasMessage()){
                System.out.println(" client 1 got a message");
                broadcast(clients.get(1).getMessage());
            }
            if(clients.get(2).hasMessage()){
                System.out.println(" client 2 got a message");
                broadcast(clients.get(2).getMessage());
            }

            /* Ensures messages are displayed and not disregarded */
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HostServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void broadcast(String text)
    {
        for(int i = 0; i < clients.size(); i++)
            clients.get(i).display(text);
    }
}
