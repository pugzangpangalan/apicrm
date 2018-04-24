package com.apicrm.service.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import com.sun.jersey.core.util.Base64;


import com.google.gson.Gson;

public class StringUtils {

	public  static void main(String[] args) {
		try {
			generateKeys();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static  String generateKeys () throws NoSuchAlgorithmException, NoSuchProviderException {
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

}
