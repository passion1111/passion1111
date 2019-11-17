package test;

 
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
 
public class SHA256util {
 
    /**
     * SHA-256 ��ȣȭ ��
     * @param source ����
     * @param salt(String) SALT ��
     * @return
     */
    public static String getEncrypt(String source, String salt) {
        return getEncrypt(source, salt.getBytes());
    }
     
    /**
     * SHA-256 ��ȣȭ ��
     * @param source ����
     * @param salt(byte[]) SALT ��
     * @return
     */
    public static String getEncrypt(String source, byte[] salt) {
         
        String result = "";
         
        byte[] a = source.getBytes();
        byte[] bytes = new byte[a.length + salt.length];
         
        System.arraycopy(a, 0, bytes, 0, a.length);
        System.arraycopy(salt, 0, bytes, a.length, salt.length);
         
        try {
            // ��ȣȭ ��� ���� �޼ҵ�
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(bytes);
             
            byte[] byteData = md.digest();
             
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xFF) + 256, 16).substring(1));
            }
             
            result = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
         
        return result;
    }
     
    /**
     * SALT�� ���´�.
     * @return
     */
    public static String generateSalt() {
        Random random = new Random();
         
        byte[] salt = new byte[8];
        random.nextBytes(salt);
         
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < salt.length; i++) {
            // byte ���� Hex ������ �ٲٱ�.
            sb.append(String.format("%02x",salt[i]));
        }
         
        return sb.toString();
    }
     
}