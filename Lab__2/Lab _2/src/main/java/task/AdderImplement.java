package task;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AdderImplement extends UnicastRemoteObject implements Adder {

    int acc = 0;

    protected AdderImplement() throws RemoteException {
        super();
    }

    @Override
    public int add(int x, int y) throws RemoteException {
        acc = acc + x;
        return acc + x + y;
        //        System.out.println(n.secretnumber);
    }

    @Override
    public Name addPrefix(Name n) throws RemoteException {
        n.name = "Kaan" + n.name;
        return n;
    }

    @Override
    public double add2(double x, double y) throws RemoteException {
        return x + y;
    }
    @Override
    public Name calculation(Name obj) throws RemoteException{

        switch (obj.getOperation()) {
            case "addition" :
            obj.result=obj.geta()+obj.getb();
            break;
            case "subtraction" :
            obj.result=obj.geta()-obj.getb();
            break;

            case "returnX":
            obj.result=obj.getx1();
            break;
            }
            return obj;
    }
   
 }


