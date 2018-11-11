
package authenticationlab2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Salliot
 */
public class PrintServant extends UnicastRemoteObject implements PrintService{

    public PrintServant() throws RemoteException {
        super();
    }

    @Override
    public String printerHash(String toHash) throws NoSuchAlgorithmException, FileNotFoundException, IOException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-1");           
        byte[] toHashBytes = new byte[1024]; 
        byte[] hash = md.digest(toHashBytes);
        
        StringBuffer sb = new StringBuffer();
        for (byte b : hash) 
        {
            //sb.append(Integer.toString((b & 0xff)+0x100, 16).substring(1));
            sb.append(String.format("%02X ", b));
        }
        String hash_string = sb.toString();
        
        return hash_string;
    }
    
    
    
    @Override
    public boolean initPrinter() throws RemoteException
    {
        PrintWriter writer;
        try {
            writer = new PrintWriter("passwords_file.txt", "UTF-8");
            writer.println("john1:"+printerHash("@bcdefghI1"));
            writer.println("john2:"+printerHash("@bcdefghI2"));
            writer.println("john3:"+printerHash("@bcdefghI3"));
            writer.close();
            return true;
        } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(PrintServant.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PrintServant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;        
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

    @Override
    public boolean logIn(String username, String hashed_password) throws RemoteException
    {    
        int index=0;
        boolean loggedin=false;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("passwords_file.txt"));
            String line = reader.readLine();
            while (line != null && !loggedin)
            {
                index = line.indexOf(":");
                if(line.substring(0,index) == username)
                {
                    if(line.substring(index) == hashed_password)
                    {
                        loggedin=true;
                    }
                }
                line = reader.readLine();
            }
            reader.close();
	} catch (FileNotFoundException ex) {
            Logger.getLogger(PrintServant.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PrintServant.class.getName()).log(Level.SEVERE, null, ex);
        }               
        return loggedin;
    }
   


   
}
