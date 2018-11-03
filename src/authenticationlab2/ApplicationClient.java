package authenticationlab2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author EliteBook
 */
public class ApplicationClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        HelloService service  = (HelloService) Naming.lookup("rmi://localhost:5099/hello");
        System.out.println("--- " + service.echo("Hey server") + " " + service.getClass().getName());
    }
    
}
