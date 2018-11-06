package authenticationlab2;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author EliteBook
 */
public interface PrintService extends Remote{
    
    public String echo(String input) throws RemoteException;
}
