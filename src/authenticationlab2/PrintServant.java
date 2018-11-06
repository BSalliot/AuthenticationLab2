
package authenticationlab2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author EliteBook
 */
public class PrintServant extends UnicastRemoteObject implements PrintService{

    public PrintServant() throws RemoteException {
        super();
    }

    
    public String echo(String input) throws RemoteException {
        return "From server: "+input;
    }
    
}
