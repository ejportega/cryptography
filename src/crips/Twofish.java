//package crips;
//
//import java.security.Key;
//import javafx.scene.chart.PieChart.Data;
//import javax.crypto.Cipher;
//import javax.crypto.spec.SecretKeySpec;
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
//
//public class Twofish {
//    
//    private static final String ALGO = "Twofish";
//    private byte[] keyValue;
//    
//    public Twofish(String key)
//    {
//        this.keyValue = key.getBytes();
//    }
//    
//    public String encrypt(String data) throws Exception
//    {
//        Key key = generateKey();
//        Cipher c = Cipher.getInstance(ALGO);
//        c.init(Cipher.ENCRYPT_MODE, key);
//        byte[] encVal = c.doFinal(data.getBytes());
//        String encryptedData = new BASE64Encoder().encode(encVal);
//        return encryptedData;
//    }
//    
//    public String decrypt(String data) throws Exception
//    {
//        Key key = generateKey();
//        Cipher c = Cipher.getInstance(ALGO);
//        c.init(Cipher.DECRYPT_MODE, key);
//        byte[] decordedValue = new BASE64Decoder().decodeBuffer(data);
//        byte[] decValue = c.doFinal(decordedValue);
//        String decryptedValue = new String(decValue);
//        return decryptedValue;
//    }
//    
//    private Key generateKey()
//    {
//        Key key = new SecretKeySpec(this.keyValue, ALGO);
//        return key;
//    }
//    
//}