
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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Salliot
 */
public class PrintServant extends UnicastRemoteObject implements PrintService{

    private ArrayList<String> usersLoggedIn = new ArrayList<String>();
    
    public PrintServant() throws RemoteException {
        super();
    }
    
    
    
    @Override
    public boolean initPrinter() throws RemoteException
    {
        PrintWriter writer;
        try {
            writer = new PrintWriter("passwords_file.txt", "UTF-8");
            writer.println("john1:"+HashService.hash("john1","@bcdefghI1"));
            writer.println("john2:"+HashService.hash("john2","@bcdefghI2"));
            writer.println("john3:"+HashService.hash("john3","@bcdefghI3"));
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
    public String print(String username, String filename, String printer) throws RemoteException {
        String toReturn;
        if (checkLoggedIn(username)) 
        {
            toReturn = "[PrintServant] Call PRINT: "+ filename +" on "+ printer; 
        }
        else
        {
            toReturn = "[PrintServant] Please log in before using this function";
        }
        
        System.out.println(toReturn);
        return toReturn;
    }

    @Override
    public String queue(String username) throws RemoteException{
        String toReturn;
        if (checkLoggedIn(username)) 
        {
            toReturn = "[PrintServant] Call QUEUE";
        }
        else
        {
            toReturn = "[PrintServant] Please log in before using this function";
        }
        System.out.println(toReturn);
        return toReturn;
    }

    @Override
    public String topQueue(String username, int job) throws RemoteException{
        String toReturn;
        if (checkLoggedIn(username)) 
        {
            toReturn = "[PrintServant] Call TOPQUEUE: "+ job;
        }
        else
        {
            toReturn = "[PrintServant] Please log in before using this function";
        }
        System.out.println(toReturn);
        return toReturn;
    }

    @Override
    public String start(String username) throws RemoteException{
        String toReturn;
        if (checkLoggedIn(username)) 
        {
            toReturn = "[PrintServant] Call START";        
        }
        else
        {
            toReturn = "[PrintServant] Please log in before using this function";
        } 
        System.out.println(toReturn);
        return toReturn;
    }

    @Override
    public String stop(String username) throws RemoteException{
        String toReturn;
        if (checkLoggedIn(username)) 
        {
            toReturn = "[PrintServant] Call STOP";        
        }
        else
        {
            toReturn = "[PrintServant] Please log in before using this function";
        }
       System.out.println(toReturn);
       return toReturn;
    }

    @Override
    public String restart(String username) throws RemoteException{
        String toReturn;
        if (checkLoggedIn(username)) 
        {
            toReturn = "[PrintServant] Call RESTART";        
        }
        else
        {
            toReturn = "[PrintServant] Please log in before using this function";
        } 
        
        System.out.println(toReturn);
        return toReturn;
    }

    @Override
    public String status(String username) throws RemoteException{
        String toReturn;
        if (checkLoggedIn(username)) 
        {
            toReturn = "[PrintServant] Call STATUS";        
        }
        else
        {
            toReturn = "[PrintServant] Please log in before using this function";
        } 
        
        System.out.println(toReturn);
        return toReturn;
    }

    @Override
    public String readConfig(String username, String parameter) throws RemoteException{
        String toReturn;
        if (checkLoggedIn(username)) 
        {
            toReturn = "[PrintServant] Call READ CONFIG: "+ parameter;      
        }
        else
        {
            toReturn = "[PrintServant] Please log in before using this function";
        } 
        System.out.println(toReturn);
        return toReturn;
    }

    @Override
    public String setConfig(String username, String parameter, String value) throws RemoteException{
        String toReturn;
        if (checkLoggedIn(username)) 
        {
            toReturn = "[PrintServant] Call SET CONFIG: "+ parameter +" to "+ value;     
        }
        else
        {
            toReturn = "[PrintServant] Please log in before using this function";
        }  
        System.out.println(toReturn);
        return toReturn;
    }

    @Override
    public boolean logIn(String username, String hashed_password) throws RemoteException
    {    
        int index=0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("passwords_file.txt"));
            String line = reader.readLine();
            while (line != null)
            {
                index = line.indexOf(":");
                if(line.substring(0,index).equals(username))
                {
                    if(line.substring(index+1).equals(hashed_password))
                    {
                        usersLoggedIn.add(username);
                        return true;
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
        return false;
    }
    
    private boolean checkLoggedIn(String username)
    {
        if (usersLoggedIn.isEmpty()) 
        {
            return false;
        }
        return usersLoggedIn.contains(username);
    }
   


   
}
