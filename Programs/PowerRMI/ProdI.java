import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ProdI extends Remote {


    public int pow(int x, int y) throws RemoteException;
}

