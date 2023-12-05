
// Java program to implement the Search interface
import java.rmi.*;
import java.rmi.server.*;
public class SearchQuery extends UnicastRemoteObject
                         implements search
{
    // Default constructor to throw RemoteException
    // from its parent constructor
    SearchQuery() throws RemoteException
    {
        super();
    }
 
    // Implementation of the ans interface
    
    
    public int ans(int a, int b) throws RemoteException {
        int i = 0;
        int answer = 1;
        for(i = 0;i<b;i++){
        	answer*=a;
        }
        return answer;
    }
}

