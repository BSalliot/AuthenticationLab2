
package authenticationlab2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author EliteBook
 */
public class HelloServant extends UnicastRemoteObject implements HelloService{

    public HelloServant() throws RemoteException {
        super();
    }

    
    public String echo(String input) throws RemoteException {
        return "From server: "+input;
    }
    
}
