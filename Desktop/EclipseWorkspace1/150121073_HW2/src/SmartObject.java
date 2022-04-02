//Name: Yigit;
//Surname: Tuncer;
//Student Id: 150121073;

public abstract class SmartObject {
    private String alias;
    private String macId;
    private String IP;
    private boolean connectionStatus;


    public SmartObject() {

    }

    public boolean connect(String IP) {
        setIP(IP);
        System.out.println(alias + " connection established");
        this.connectionStatus = true;
        return true;
    }

    public boolean disconnect() {
        this.connectionStatus = false;
        return true;
    }

    public void smartObjectToString() {
        //This following part is to get the class of the object.
        String className = this. getClass(). getSimpleName();

        System.out.println("This is " + className  + " device "+ alias);
        System.out.println("\tMacId: " + macId);
        System.out.println("\tIP: " + getIP());

    }

    public boolean controlConnection() {
        if (!connectionStatus) {
            System.out.println("This device is not connected. "); // This is not complete.
            return false;
        }
        return true;
    }

    public abstract boolean testObject();

    public abstract boolean shutDownObject();

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getMacId() {
        return macId;
    }

    public void setMacId(String macId) {
        this.macId = macId;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public boolean isConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(boolean connectionStatus) {
        this.connectionStatus = connectionStatus;
    }
}
