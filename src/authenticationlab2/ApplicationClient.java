package authenticationlab2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Salliot
 */
public class ApplicationClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        PrintService service  = (PrintService) Naming.lookup("rmi://localhost:5099/printer");
        String test = service.print("test_print", "printer 1");
        System.out.println(test);
    }
    
    public String getHash(String password)
    {
        return password;
    }
    
}
