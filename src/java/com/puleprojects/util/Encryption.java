package com.puleprojects.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PULE
 */
public class Encryption {

    public static String GenerateHash(String input){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Encryption.class.getName()).log(Level.SEVERE, null, ex);
        }

        byte[] messageDigest = md.digest(input.getBytes());
        
        BigInteger bigInt = new BigInteger(1,messageDigest);
        
        return bigInt.toString(16);
    }
    public static void main(String[] args) {
        System.out.println(GenerateHash("1234"));
    }
}

