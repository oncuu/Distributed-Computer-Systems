import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.webserver.WebServer;

import java.io.IOException;

public class Server {

    public static void main(String[] args) throws XmlRpcException, IOException {
        System.out.println("Starting XML-RPC server...");
        int port = 8741;
        WebServer server = new WebServer(port);

        PropertyHandlerMapping mapper = new PropertyHandlerMapping();


        mapper.addHandler("SERVER",Server.class);

        server.getXmlRpcServer().setHandlerMapping(mapper);
        server.start();
    }


    public String echo(String s){
        System.out.println(s);
        return "PONG: " + s;
    }

    public double Echo(Double s, int a){
        System.out.println("Your result (double)");
        double s1= s + a;
        System.out.println(s1);
        return s1;
    }

    public String Echo1(String s, int a){
        System.out.println("Your number with String" + s + a);
        return s + a;

    }


}
