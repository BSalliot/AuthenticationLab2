
package authenticationlab2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Salliot
 */
public class HashService {
    public static String hash(String username, String clearPassword) throws NoSuchAlgorithmException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-1");           
        byte[] toHashBytes = clearPassword.getBytes();
        byte[] userBytes = username.getBytes();
        
        //Salt the password
        for (int i = 0; i < minLength(toHashBytes.length, userBytes.length); i++) {
            toHashBytes[i] = (byte)(toHashBytes[i] & userBytes[i]); 
        }
        
        //Hash
        byte[] hash = md.digest(toHashBytes);
        
        //Salt the result
        for (int i = 0; i < minLength(hash.length, userBytes.length); i++) {
            hash[i] = (byte)(hash[i] & userBytes[i]); 
        }
        
        //Return the result as a string
        StringBuffer sb = new StringBuffer();
        for (byte b : hash) 
        {
            //sb.append(Integer.toString((b & 0xff)+0x100, 16).substring(1));
            sb.append(String.format("%02X ", b));
        }
        String hash_string = sb.toString();
        
        return hash_string;
    }

    
    private static int minLength (int l1, int l2)
    {
        if(l1 < l2)
            return l1;
        else
            return l2;

    }
}

