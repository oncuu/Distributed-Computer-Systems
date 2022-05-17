package task;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Adder extends Remote{
    int add(int x, int y) throws RemoteException;
    Name addPrefix(Name n) throws RemoteException;
    double add2(double x, double y) throws RemoteException;

    public Name calculation(Name obj) throws RemoteException;

}
