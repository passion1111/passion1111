package test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Sha256 {
	 public static void main(String[] args) {
		 
	        String base = "p";
	 
	        try{
	 
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            byte[] hash = digest.digest(base.getBytes("UTF-8"));
	            System.out.println(hash.length);
	            StringBuffer hexString = new StringBuffer();
	 
	            for (int i = 0; i < hash.length; i++) {
	                String hex = Integer.toHexString(0xff & hash[i]);
	                if(hex.length() == 1) hexString.append('0');
	                hexString.append(hex);
	            }
	 
	            //Ãâ·Â
	            System.out.println(hexString.toString());
	 
	        } catch(Exception ex){
	            throw new RuntimeException(ex);
	        }
	 
	        String SHA = ""; 

	    	try{

	    		MessageDigest sh = MessageDigest.getInstance("SHA-256"); 

	    		sh.update(base.getBytes()); 

	    		byte byteData[] = sh.digest();

	    		StringBuffer sb = new StringBuffer(); 

	    		for(int i = 0 ; i < byteData.length ; i++){

	    			sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));

	    		}

	    		SHA = sb.toString();

	    		System.out.println(SHA);
	    		System.out.println(getSalt());

	    	}catch(NoSuchAlgorithmException e){

	    		e.printStackTrace(); 

	    		SHA = null; 

	    	}
	        
	    }
	 
	    public static String getSalt() {
	        String value = "";
	        try {

	            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
	            // Salt generation 128 bits long
	            byte[] salt = new byte[128];
	            secureRandom.nextBytes(salt);
	            value = salt.toString();
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	        return value;
	    }
	    
	    public static String  makesha256(String p) {
	    	
	    	  String SHA = ""; 

		    	try{

		    		MessageDigest sh = MessageDigest.getInstance("SHA-256"); 

		    		sh.update(p.getBytes()); 

		    		byte byteData[] = sh.digest();

		    		StringBuffer sb = new StringBuffer(); 

		    		for(int i = 0 ; i < byteData.length ; i++){

		    			sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));

		    		}

		    		SHA = sb.toString();

		    		System.out.println(SHA);

		    	}catch(NoSuchAlgorithmException e){

		    		e.printStackTrace(); 

		    		SHA = null; 

		    	}
		    	return SHA;
	    	
	    }
	 
}
