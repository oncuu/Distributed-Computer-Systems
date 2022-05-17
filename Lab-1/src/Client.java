import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

// 1. at least 2 exposed methods
// 2. each method has at least 2 parameters
// 3. each method returns a value
// 4. there are at least two types of parameters (e.g. String and Int)
// 5. at least one type of parameter or return value is a Serializable custom class

public class Client {
    public static void main(String[] args) throws XmlRpcException, MalformedURLException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        //ip address suppose to come as a url address with port(ip:port)
        //but for any case check it again
        //or maybe localhost
        config.setServerURL(new URL("http://localhost:8741"));

        //check this part
        XmlRpcClient Rclient = new XmlRpcClient();
        Rclient.setConfig(config);

//        for(int i = 0; i < 50; i++){
//            AsyncCallback ac = new AsyncCallback() {
//                @Override
//                public void handleResult(XmlRpcRequest xmlRpcRequest, Object o) {
//                    System.out.println((String) o);
//                }
//
//                @Override
//                public void handleError(XmlRpcRequest xmlRpcRequest, Throwable throwable) {
//                    System.out.println(throwable.getMessage());
//                }
//            };
//            Rclient.executeAsync("SERVER.echo", Collections.singletonList("Hello XMLRPC!" + i), ac);
//        }

//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        String res = (String)Rclient.execute("SERVER.echo", Collections.singletonList("Hello XMLRPC!"));
//        System.out.println(res);




//      Second Task


//      Double

//        System.out.println("Write number for adding our value.");
//        Scanner sc = new Scanner(System.in);
//        Object[] objects = new Object[2];
//        double d = 11.99;
//        objects[0] = d;
//        while (sc.hasNextLine()){
//            int num = sc.nextInt();
//                objects[1] = num;
//                Object result = Rclient.execute("SERVER.Echo", objects);
//                String st = String.valueOf(result);
//                System.out.println("Result is " + st);
//        }
//        sc.close();


//        String
//
        System.out.println("Write anything to get additional number: ");
        Scanner sc1 = new Scanner(System.in);
        Object[] objects1 = new Object[2];
        int rand = 1111;
        objects1[1] = rand;
        while(sc1.hasNextLine()){
            String string = sc1.nextLine();
            objects1[0]= (String)string;
            System.out.println(objects1[0]);
            System.out.println(objects1[1]);
            Object result = Rclient.execute("SERVER.Echo1", objects1);
            String something = ((String) result).toString();
            System.out.println(something);
            if (Objects.equals(string.toLowerCase(), "end")){
                break;
            }
        }
        sc1.close();

    }
}
