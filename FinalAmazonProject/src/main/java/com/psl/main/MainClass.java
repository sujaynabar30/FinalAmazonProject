package com.psl.main;

import com.github.windpapi4j.InitializationFailedException;
import com.github.windpapi4j.WinAPICallFailedException;
import com.github.windpapi4j.WinDPAPI;
import com.github.windpapi4j.WinDPAPI.CryptProtectFlag;
import com.psl.createfile.Filesmethods;
import com.psl.encryptdecrypt.Decryption;
import com.psl.encryptdecrypt.Encryption;
import com.psl.read.CopyToConfigFile;
import com.psl.read.ReadConfigfile;
import com.psl.read.ReadFromConfigFile;

import java.io.IOException;


public class MainClass {
	
	public static WinDPAPI winDPAPI;
	static CopyToConfigFile c = new CopyToConfigFile();
	static ReadConfigfile r = new ReadConfigfile();
	
	static String fileName = "C:\\Users\\Sujay\\git\\FinalAmazonProject\\FinalAmazonProject\\TextFile.txt";
	static String propfile = "C:\\Users\\Sujay\\git\\FinalAmazonProject\\FinalAmazonProject\\Configs\\Configuation.properties";
	static String propfile2 = "C:\\Users\\Sujay\\git\\FinalAmazonProject\\FinalAmazonProject\\Configs\\Configuation2.properties";
	
	
	public static void security() throws InitializationFailedException, WinAPICallFailedException, IOException {
		
		String plaintext = ReadFromConfigFile.readUsingFiles(fileName);
		
        if (!WinDPAPI.isPlatformSupported()) {
            System.err.println("The Windows Data Protection API (DPAPI) is not available on " + System.getProperty("os.name") + ".");
            return;
        }
        
        winDPAPI = WinDPAPI.newInstance(CryptProtectFlag.CRYPTPROTECT_UI_FORBIDDEN);
        
        boolean empty = plaintext.length() == 0;
        
        if(!empty) {
        
        System.out.println("Plain text:       \n" + plaintext);
        
        String encrypted = Encryption.encrypt(plaintext,winDPAPI);
        System.out.println("\nEncrypted String: \n" + encrypted);
        
        c.copyEncrypted(propfile,encrypted);
        
        Filesmethods.clearTheFile();
        }
        
        String encrypted = ReadFromConfigFile.readUsingFiles(propfile);	//this is used to read encripted string from config1 file
        
        String decrypted = Decryption.decrypt(encrypted,winDPAPI);
        System.out.println("\nDecrypted String: \n" + decrypted);
    	
    	c.copyDecrypted(propfile2, decrypted);
    	
    	r.getUrl();
    	r.getBrowser();
    	r.getEmailId();
    	r.getPassword();
    	
    	//credel.deleteFile();

    }
}

