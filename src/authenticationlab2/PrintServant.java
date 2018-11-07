
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
    public String print(String filename, String printer) throws RemoteException {
        String toReturn = "[PrintServant] Call PRINT: "+ filename +" on "+ printer;
        System.out.println(toReturn);
        return toReturn;
    }

    @Override
    public String queue() throws RemoteException{
        String toReturn = "[PrintServant] Call QUEUE";
        System.out.println(toReturn);
        return toReturn;
    }

    @Override
    public String topQueue(int job) throws RemoteException{
        String toReturn = "[PrintServant] Call TOPQUEUE: "+ job;
        System.out.println(toReturn);
        return toReturn;
    }

    @Override
    public String start() throws RemoteException{
        String toReturn = "[PrintServant] Call START";
        System.out.println(toReturn);
        return toReturn;
    }

    @Override
    public String stop() throws RemoteException{
       String toReturn = "[PrintServant] Call STOP";
       System.out.println(toReturn);
       return toReturn;
    }

    @Override
    public String restart() throws RemoteException{
        String toReturn = "[PrintServant] Call RESTART";
        System.out.println(toReturn);
        return toReturn;
    }

    @Override
    public String status() throws RemoteException{
        String toReturn = "[PrintServant] Call STATUS";
        System.out.println(toReturn);
        return toReturn;
    }

    @Override
    public String readConfig(String parameter) throws RemoteException{
        String toReturn = "[PrintServant] Call READ CONFIG: "+ parameter;
        System.out.println(toReturn);
        return toReturn;
    }

    @Override
    public String setConfig(String parameter, String value) throws RemoteException{
        String toReturn = "[PrintServant] Call SET CONFIG: "+ parameter +" to "+ value;
        System.out.println(toReturn);
        return toReturn;
    }
    
}
