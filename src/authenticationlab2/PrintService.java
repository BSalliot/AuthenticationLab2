package authenticationlab2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author Salliot
 */
public interface PrintService extends Remote{
    
    
    
    public String echo(String input) throws RemoteException;
    
    public boolean initPrinter() throws RemoteException;
    
    public String print(String username, String filename, String printer) throws RemoteException;   // prints file filename on the specified printer
    public String queue(String username) throws RemoteException;   // lists the print queue on the user's display in lines of the form <job number>   <file name>
    public String topQueue(String username, int job) throws RemoteException;   // moves job to the top of the queue
    public String start(String username) throws RemoteException;   // starts the print server
    public String stop(String username) throws RemoteException;   // stops the print server
    public String restart(String username) throws RemoteException;   // stops the print server, clears the print queue and starts the print server again
    public String status(String username) throws RemoteException;  // prints status of printer on the user's display
    public String readConfig(String username, String parameter) throws RemoteException;   // prints the value of the parameter on the user's display
    public String setConfig(String username, String parameter, String value) throws RemoteException;   // sets the parameter to value
    
    public boolean logIn(String username, String hashed_password) throws RemoteException;
    
}
