package TCP.NameServer;

public class PortAddr 
{
	String name;
	String hostname;
    int portnum;
    
    public PortAddr(String n, String s, int i)  {
    	name = new String(n);
        hostname = new String(s);
        portnum = i;
    }
    
    public String getName() {
    	return name;
    }
    
    public String getHostName() {
        return hostname;
    }
    
    public int getPort() {
        return portnum;
    }

}
