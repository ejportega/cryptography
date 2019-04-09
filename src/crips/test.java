/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crips;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;



/**
 *
 * @author EJ
 */
public class test {
    static KeyPair buildKeyPair() throws NoSuchAlgorithmException {
        final int keySize = 2048;
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(keySize);      
        return keyPairGenerator.genKeyPair();
    }
    public static void main(String args[]) throws Exception {
        
        
//        DES des = new DES("471c3$pUb71ck3y");
//        String s = "Hello, World";
//        String e = des.encrypt(s);
//        String d = des.decrypt(e);
//        System.out.println(e);
//        System.out.println(d);
//        
//        AES aes = new AES("B0b$pUb71ck3y123");
//        String s2 = "Hello, World";
//        String e2 = aes.encrypt(s2);
//        String d2 = aes.decrypt(e2);
//        System.out.println(e2);
//        System.out.println(d2);
        
//        Blowfish fish = new Blowfish("B0b$pUb71ck3y123");
//        String s3 = "Hello, World";
//        String e3 = fish.encrypt(s3);
//        String d3 = fish.decrypt(e3);
//        System.out.println(e3);
//        System.out.println(d3);
         KeyPair keyPair = buildKeyPair();
        PublicKey pubKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        RSA rsa = new RSA();
        String s3 = "Hello, Worljvvdaslkd;lksal;dkasl;kdl;askdl;ask;ldkasl;dka;lskdl;asjfcjkxhjkcjxchkjvhj;lxdjhfgiuxjv,jxgcvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvd";
        String e3 = rsa.encrypt(privateKey,s3);
        String d3 = rsa.decrypt(pubKey, e3);
        System.out.println(e3);
        System.out.println(d3);

//        TripleDES aes = new TripleDES();
//        String s2 = "Hello, dasdkjljdjsllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllWorlddddddddddddddewqeqweqweqwdasdzxcxcasdasfeeeeeeeeeeeeeedddddddd";
//        byte[] e2 =aes.encrypt(s2);
//        System.out.println(aes.encrypt(s2));
//        System.out.println(aes.decrypt(e2));
    }
}
