package ChatApp;

public class Main
{
    public static void main(String[] args)
    {
        HostServer s = new HostServer();
        GuestClient a = new GuestClient("Kadon");
        s.connect(a);
        GuestClient p = new GuestClient("Tarah");
        s.connect(p);
        GuestClient d = new GuestClient("Greg");
        s.connect(d);
        s.run();

    }

}
