package authenticationlab2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

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
        String test = service.print("john1", "test_print", "printer 1");
        System.out.println(test);
        
        boolean res_init = service.initPrinter();
        if (res_init) {
            System.out.println("init ok");
            
            //Log in
            Scanner sc = new Scanner(System.in);
            System.out.println("For the purpose of this test, try USERNAME : john1, PASSWORD : @bcdefghI1.");
            System.out.println("Username: ");
            String username = sc.nextLine();
            
            System.out.println("Password: ");
            String password = sc.nextLine();
            
            boolean loggedIn = service.logIn(username, HashService.hash(username,password));
            if (loggedIn) {
                System.out.println("logged in!");
            }
            else {
                System.out.println("log in failed");
            }
            
            test = service.print("john1", "test_print", "printer 1");
            System.out.println(test);
        }
    }
    
}
    

