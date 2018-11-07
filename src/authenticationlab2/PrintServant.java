
package authenticationlab2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Salliot
 */
public class PrintServant extends UnicastRemoteObject implements PrintService{

    public PrintServant() throws RemoteException {
        super();
    }

    @Override
    public String echo(String input) throws RemoteException {
        return "From server: "+input;
    }

    @Override
    public void print(String filename, String printer) throws RemoteException {
        System.out.println("[PrintServant] Call PRINT: "+ filename +" on "+ printer);
    }

    @Override
    public void queue() throws RemoteException{
        System.out.println("[PrintServant] Call QUEUE");
    }

    @Override
    public void topQueue(int job) throws RemoteException{
        System.out.println("[PrintServant] Call TOPQUEUE: "+ job);
    }

    @Override
    public void start() throws RemoteException{
        System.out.println("[PrintServant] Call START");
    }

    @Override
    public void stop() throws RemoteException{
        System.out.println("[PrintServant] Call STOP");
    }

    @Override
    public void restart() throws RemoteException{
        System.out.println("[PrintServant] Call RESTART");
    }

    @Override
    public void status() throws RemoteException{
        System.out.println("[PrintServant] Call STATUS");
    }

    @Override
    public void readConfig(String parameter) throws RemoteException{
        System.out.println("[PrintServant] Call READ CONFIG: "+ parameter);
    }

    @Override
    public void setConfig(String parameter, String value) throws RemoteException{
        System.out.println("[PrintServant] Call SET CONFIG: "+ parameter +" to "+ value);
    }
    
}
