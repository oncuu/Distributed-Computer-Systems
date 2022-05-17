package task;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        LocateRegistry.createRegistry(8888);
        Adder a = new AdderImplement();
        Naming.rebind("rmi://localhost:8888/adder", a);

        LocateRegistry.createRegistry(9999);
        Naming.rebind("rmi://localhost:9999/adder", a);
        LocateRegistry.createRegistry(7777);
        Naming.rebind("rmi://localhost:7777/adder", a);
    }
}
