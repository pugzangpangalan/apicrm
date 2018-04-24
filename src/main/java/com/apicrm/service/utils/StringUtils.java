package com.apicrm.service.utils;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;

import com.sun.jersey.core.util.Base64;

public class StringUtils {

	public  static void main(String[] args) {
		try {
			generateKeys();
			generateToken("jay");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static String generateKeys () throws NoSuchAlgorithmException, NoSuchProviderException {
		String key = "";
		String keyAlgorithm ="DSA";
		int numBits = 1024;
		
		try {
            // Get the public/private key pair
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance(keyAlgorithm);
            keyGen.initialize(numBits);
            KeyPair keyPair = keyGen.genKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            
            // Get the bytes of the public and private keys
            byte[] privateKeyBytes = privateKey.getEncoded();
            key = Base64.encode(String.valueOf(privateKeyBytes)).toString();
       
       } catch (NoSuchAlgorithmException e) {
            System.out.println("Exception");
            System.out.println("No such algorithm: " + keyAlgorithm);
       }

		return key;
	} 
	
	public static String generateToken( String username ) {
		SecureRandom random = new SecureRandom();
		
        long longToken = Math.abs( random.nextLong() );
        String token = Long.toString( longToken, 16 ).toUpperCase();
        return ( username + ":" + token );
	}

}
