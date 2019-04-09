package crips;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.spec.KeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DES {
    
    private static final String UNICODE_FORMAT = "UTF8";
    public static final String DES_ENCRYPTION_SCHEME = "DES";
    private KeySpec myKeySpec;
    private SecretKeyFactory mySecretKeyFactory;
    private Cipher cipher;
    byte[] keyAsBytes;
    private String myEncryptionKey;
    private String myEncryptionScheme;
    SecretKey key;
    
    DES(String myEncKey) throws Exception 
    {
        myEncryptionKey = myEncKey;
        myEncryptionScheme = DES_ENCRYPTION_SCHEME;
        keyAsBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
        myKeySpec = new DESKeySpec(keyAsBytes);
        mySecretKeyFactory = SecretKeyFactory.getInstance(myEncryptionScheme);
        cipher = Cipher.getInstance(myEncryptionScheme);
        key = mySecretKeyFactory.generateSecret(myKeySpec);
    }
    
    public String encrypt(String data) 
    {
        String encryptedData = null;
        try 
        {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainText = data.getBytes(UNICODE_FORMAT);
            byte[] encryptedText = cipher.doFinal(plainText);
            BASE64Encoder base64encoder = new BASE64Encoder();
            encryptedData = base64encoder.encode(encryptedText);
        }
        catch(InvalidKeyException | UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException e)
        {
          e.printStackTrace();  
        }
        return encryptedData;
    }
    
    public String decrypt(String data) 
    {
        String decryptedData = null;
        try 
        {
            cipher.init(Cipher.DECRYPT_MODE, key);
            BASE64Decoder base64decoder = new BASE64Decoder();
            byte[] encryptedText = base64decoder.decodeBuffer(data);
            byte[] plainText = cipher.doFinal(encryptedText);
            decryptedData = bytes2String(plainText);
        }
        catch(InvalidKeyException | IOException | IllegalBlockSizeException | BadPaddingException e)
        {
          e.printStackTrace();  
        }
        return decryptedData;
    }

    public String bytes2String(byte[] bytes) 
    {
       StringBuilder stringBuffer = new StringBuilder();
       for (int i=0; i<bytes.length; i++)
       {
           stringBuffer.append((char) bytes[i]);
       }
       return stringBuffer.toString();
    }
}

