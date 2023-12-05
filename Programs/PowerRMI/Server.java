import java.rmi.*;
import java.rmi.registry.*;

public class Server {
    public static void main(String args[]) throws Exception {

        ProdC obj = new ProdC();
        

        Naming.rebind("POW", obj);
        

        System.out.println("This Server Started");
    }
}

