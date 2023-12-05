import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ProdC extends UnicastRemoteObject implements ProdI {
    protected ProdC() throws RemoteException {
        super();
    }

    public int pow(int x, int y) {

        return (int) Math.pow(x, y);
    }
}

