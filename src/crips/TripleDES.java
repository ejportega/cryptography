package crips;

import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
class TripleDES
{
 public KeyGenerator keygenerator;
 public SecretKey myDesKey;
 Cipher c;
 public IvParameterSpec iv;
 public TripleDES() throws Exception
 { 
 

               // Genrate the Key
  keygenerator = KeyGenerator.getInstance("DESede");
  keygenerator.init(new SecureRandom());
  myDesKey = keygenerator.generateKey();

  // Create the cipher
  c = Cipher.getInstance("DESede/CBC/PKCS5Padding");
  
  iv = new IvParameterSpec(new byte[8]);
 }
 public byte[] encrypt(String s) throws Exception
 {
      // Initialize the cipher for encryption
      c.init(Cipher.ENCRYPT_MODE, myDesKey,iv);

      //sensitive information
      byte[] text = s.getBytes();
 
   // Encrypt the text
      byte[] textEncrypted = c.doFinal(text);
   return(textEncrypted);
       
 }
 public String decrypt(byte[] s)throws Exception
 {
 
      // Initialize the same cipher for decryption
      c.init(Cipher.DECRYPT_MODE, myDesKey,iv);
   
   // Decrypt the text
      byte[] textDecrypted = c.doFinal(s);
 
   return(new String(textDecrypted));
 }
}