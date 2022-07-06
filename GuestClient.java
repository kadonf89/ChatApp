package ChatApp;

import java.util.ArrayList;


public class GuestClient
{
    public String name;
    public ArrayList<String> msgs;
    public ChatWindow cb;

    public GuestClient(String name)
    {
        this.name = name;
        msgs = new ArrayList<String>();
        cb = new ChatWindow(this);

        send(" has now joined.");

    }

    public void send(String text)
    {

        msgs.add(name + ": " + text +"\n");

    }

    public boolean hasMessage()
    {
        if (msgs.size() > 0)
        {
            return true;
        }else
            return false;
    }

    public String getMessage()
    {
        String ret = msgs.get(0);
        msgs.remove(0);
        msgs.trimToSize();
        return ret;
    }

    public void display(String msg)
    {

        cb.writeBox(msg);
    }

}
