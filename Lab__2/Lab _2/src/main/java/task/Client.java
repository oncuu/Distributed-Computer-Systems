package task;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class Client {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        Adder stub = (Adder) Naming.lookup("rmi://localhost:8888/adder");


        Name n =new Name();
        n.name = " Oncu";
//        n.secretnumber = 11111;

        System.out.println(stub.add(8,7));
        System.out.println(stub.addPrefix(n).name);
        System.out.println(stub.add2(1.553,8.7778));



        Adder name1=(Adder) Naming.lookup("rmi://localhost:9999/adder");
        Adder name2=(Adder) Naming.lookup("rmi://localhost:7777/adder");
        Name obj1=new Name();
        Name obj2=new Name();

        obj1.operation="addition";
        obj2.operation="subtraction";
        obj2.x1=22333;

        System.out.println("addition of initial data "+ name1.calculation(obj1).result);
        System.out.println("subtraction of initial data"+  name2.calculation(obj2).result);
        obj2.operation="returnX";
        System.out.println("return X given in client "+  name2.calculation(obj2).result);
    }
}
