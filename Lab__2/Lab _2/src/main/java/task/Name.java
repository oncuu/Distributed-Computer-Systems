package task;

import java.io.Serializable;

public class Name implements Serializable {
    String name;
//    transient int secretnumber;\
    double a = 1.553;
    double b = 8.7778;
    

    String operation;
    public int x1;
    public double result;

    public int getx1() {
        return x1;
    }
    public double geta() {
        return a;
    }
    public double getb() {
        return b;
    }
    public String getOperation(){
        return operation;
    }


}
