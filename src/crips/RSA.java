package crips;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class RSA {
    
    private static final String ALGO = "RSA";
    
    public String encrypt(PrivateKey privateKey, String data) throws Exception {
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] encVal = c.doFinal(data.getBytes());
        String encryptedData = new BASE64Encoder().encode(encVal);
        return encryptedData;
    }
    
    public String decrypt(PublicKey publicKey, String data) throws Exception {
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(data);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
}