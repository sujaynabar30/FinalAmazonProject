package com.psl.read;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author sujay_nabar
 * This file is used to read the config file and create methods to get specific data
 */

public class ReadConfigfile {

	private static Properties properties;
	private static String propertyFilePath= "C:\\Users\\Sujay\\git\\FinalAmazonProject\\FinalAmazonProject\\Configs\\Configuation2.properties";
 
	
	public ReadConfigfile(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration2.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getUrl()
	{
		String url = properties.getProperty("url");
		System.out.println("\nUrl is :"+url);
		if(url!= null) return url;
		else throw new RuntimeException("url not specified in the Configuration2.properties file.");	
	}
	
	public String getBrowser()
	{
		String browser = properties.getProperty("browser");
		System.out.println("Browser is :"+browser);
		if(browser!= null) return browser;
		else throw new RuntimeException("browser not specified in the Configuration2.properties file.");	
	}
	
	public String getEmailId(){
		String emailid = properties.getProperty("emailid");
		System.out.println("Email id is :"+emailid);
		if(emailid!= null) return emailid;
		else throw new RuntimeException("emailid not specified in the Configuration2.properties file.");		
	}
	
	public String getPassword()
	{
		String password = properties.getProperty("password");
		System.out.println("Password is :"+password);
		if(password!= null) return password;
		else throw new RuntimeException("password not specified in the Configuration2.properties file.");	
	}
	
	
}
