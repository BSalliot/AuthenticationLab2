package authenticationlab2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Salliot
 */
public class ApplicationClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException, NoSuchAlgorithmException {
        PrintService service  = (PrintService) Naming.lookup("rmi://localhost:5099/printer");
        String test = service.print("test_print", "printer 1");
        System.out.println(test);
        
        boolean res_init = service.initPrinter();
        if (res_init) {
            System.out.println("init ok");
            boolean loggedIn = service.logIn("john1", clientHash("@bcdefghI1"));
            if (loggedIn) {
                System.out.println("logged in!");
            }
            else {
                System.out.println("log in failed");
            }
        }
    }
    
    public static String clientHash(String password) throws NoSuchAlgorithmException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-1");           
        byte[] toHashBytes = password.getBytes();
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
}
    

