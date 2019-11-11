package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

import sun.security.util.Resources;	

public class main {

	
	public static void main(String[] args) {
		String resource = "test/salt.properties";
		Properties properties = new Properties(); 
		try { 
			
			FileReader resources= new FileReader("C:"+File.separator+"salt.properties");
			properties.load(resources); 
		System.out.println(properties.getProperty("key"));
		
		} catch (Exception e) {
			e.printStackTrace(); }

		String key=properties.getProperty("key");
         
         


		String salt=AES.getSalt();
		System.out.println(salt);
		try {
			String encryptsalt=AES.Encrypt(salt, key);
			System.out.println(encryptsalt);
			String decryptsalt=AES.Decrypt(encryptsalt, key);
			System.out.println(decryptsalt);
			
			String password=Sha256.makesha256("53343");
			
			//해독된 salt + sha256넣을것
			String aa=AES.getPassword(password, decryptsalt);
			System.out.println(aa);
			//원래 salt +sha256
			System.out.println(AES.getPassword(password, salt));
			//Dpb2PML9mMGP9FK55l4s9zwkq8xWc9S1rLFe5RO60MQ
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
