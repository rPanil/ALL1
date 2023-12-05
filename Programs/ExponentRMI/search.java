import java.rmi.*;
public interface search extends Remote
{
    // Declaring the method prototype
   // public String query(String search) throws RemoteException;
    public int ans(int a, int b) throws RemoteException;
}
