package test;

import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class AES {

	

       public AES()

        {

                  try

                  { 

                 String originalText = getSalt();

                 String key = "key";

                 String en = Encrypt( originalText, key);

                 String de = Decrypt( en, key);

                

                 System.out.println( "Original Text is " + originalText);

                         System.out.println( "Encrypted Text is " + en );

                         System.out.println( "Decrypted Text is " + de );

                  }

                  catch (Exception ex)

                  {

                             System.out.println("¿À·ù");

                  }



      	        System.out.println(SHA256util.getEncrypt("123", getSalt()));
                 

        }



        public static String Decrypt(String text, String key) throws Exception

        {

                  Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

                  byte[] keyBytes= new byte[16];

                  byte[] b= key.getBytes("UTF-8");

                  int len= b.length;

                  if (len > keyBytes.length) len = keyBytes.length;

                  System.arraycopy(b, 0, keyBytes, 0, len);

                  SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

                  IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);

                  cipher.init(Cipher.DECRYPT_MODE,keySpec,ivSpec);



                  BASE64Decoder decoder = new BASE64Decoder();

                  byte [] results = cipher.doFinal(decoder.decodeBuffer(text));

                  return new String(results,"UTF-8");

        }



        public static String Encrypt(String text, String key) throws Exception

        {

                  Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

                  byte[] keyBytes= new byte[16];

                  byte[] b= key.getBytes("UTF-8");

                  int len= b.length;

                  if (len > keyBytes.length) len = keyBytes.length;

                  System.arraycopy(b, 0, keyBytes, 0, len);

                  SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

                  IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);

                  cipher.init(Cipher.ENCRYPT_MODE,keySpec,ivSpec);



                  byte[] results = cipher.doFinal(text.getBytes("UTF-8"));

                  BASE64Encoder encoder = new BASE64Encoder();

                  return encoder.encode(results);

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
        
        
        public static String getPassword(String password, String salt) {
            String encriptPassword = "";
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                digest.reset();
                digest.update(salt.getBytes());
                byte[] input = digest.digest(password.getBytes("UTF-8"));
                for (int i = 0; i < 1000; i++) {
                    digest.reset();
                    input = digest.digest(input);
                }
               
                BASE64Encoder endecoder = new BASE64Encoder();
                encriptPassword = endecoder.encode(input);
            } catch(Exception e) {
                e.printStackTrace();
            }
            return encriptPassword;
        }


}
