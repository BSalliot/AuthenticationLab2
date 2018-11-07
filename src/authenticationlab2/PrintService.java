package authenticationlab2;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Salliot
 */
public interface PrintService extends Remote{
    
    public String echo(String input) throws RemoteException;
    
    public void print(String filename, String printer) throws RemoteException;   // prints file filename on the specified printer
    public void queue() throws RemoteException;   // lists the print queue on the user's display in lines of the form <job number>   <file name>
    public void topQueue(int job) throws RemoteException;   // moves job to the top of the queue
    public void start() throws RemoteException;   // starts the print server
    public void stop() throws RemoteException;   // stops the print server
    public void restart() throws RemoteException;   // stops the print server, clears the print queue and starts the print server again
    public void status() throws RemoteException;  // prints status of printer on the user's display
    public void readConfig(String parameter) throws RemoteException;   // prints the value of the parameter on the user's display
    public void setConfig(String parameter, String value) throws RemoteException;   // sets the parameter to value
}
