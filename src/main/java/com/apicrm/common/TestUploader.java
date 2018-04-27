package com.apicrm.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import javax.xml.bind.DatatypeConverter;

public class TestUploader {

	// FOR TESTING ONLY
	/*public static void main(String[] args) throws IOException{
		String imagePath = "C:\\temp\\ucg2test.csv";
		System.out.println("=================Encoder Image to Base 64!=================");
		String base64ImageString = encoder(imagePath);
		System.out.println("Base64ImageString = " + base64ImageString);
 
	
		System.out.println("DONE!");
 
	}*/


 	@SuppressWarnings("resource")
	public static String encoder(String imagePath)throws IOException {
		String base64Image = "";
		File file = new File(imagePath);
		try {
			FileInputStream imageInFile = new FileInputStream(file);
			// Reading a Image file from file system
			byte imageData[] = new byte[(int) file.length()];
			imageInFile.read(imageData);
			base64Image = Base64.getEncoder().encodeToString(imageData);
			toExcel(base64Image);
		} catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the Image " + ioe);
		}
		return base64Image;
	}
	
	public static void toExcel(String value)throws IOException {
		Files.write(Paths.get("temp.csv"), DatatypeConverter.parseBase64Binary(value));
		
	}

}
