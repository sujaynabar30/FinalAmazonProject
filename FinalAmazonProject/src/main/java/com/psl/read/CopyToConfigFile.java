package com.psl.read;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * @author sujay_nabar
 *This class is used to copy contents to config file
 */

public class CopyToConfigFile {
	
	public void copyEncrypted(String propfile, String encrypted) throws IOException {
		// TODO Auto-generated method stub
		
		 PrintWriter out = new PrintWriter(new FileWriter(propfile));  				//write encrypted string to config file
	        out.print(encrypted);  
	        out.close(); 
	}
	
	public void copyDecrypted(String propfile2, String decrypted) throws IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = new PrintWriter(new FileWriter(propfile2));  				//write decrypted string to config2 file
		System.out.println("\nDecrypted String Copied");
        out.print(decrypted);  
        out.close(); 

	}
}
