package authenticationlab2;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Salliot
 */
public interface PrintService extends Remote{
    
    public String echo(String input) throws RemoteException;
    
    public void print(String filename, String printer);   // prints file filename on the specified printer
    public void queue();   // lists the print queue on the user's display in lines of the form <job number>   <file name>
    public void topQueue(int job);   // moves job to the top of the queue
    public void start();   // starts the print server
    public void stop();   // stops the print server
    public void restart();   // stops the print server, clears the print queue and starts the print server again
    public void status();  // prints status of printer on the user's display
    public void readConfig(String parameter);   // prints the value of the parameter on the user's display
    public void setConfig(String parameter, String value);   // sets the parameter to value
}
