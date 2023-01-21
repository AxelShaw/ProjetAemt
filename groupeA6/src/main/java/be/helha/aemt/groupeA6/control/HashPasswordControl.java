package be.helha.aemt.groupeA6.control;

import jakarta.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
 
class HashPasswordControl
{
    public static String hashPassword(String password) throws NoSuchAlgorithmException 
    {
        
 
        MessageDigest md;
		md = MessageDigest.getInstance("SHA-256");
	    byte[] digest = md.digest(password.getBytes(StandardCharsets.UTF_8));
	    String result = Base64.getEncoder().encodeToString(digest);
        return result;

    }
}