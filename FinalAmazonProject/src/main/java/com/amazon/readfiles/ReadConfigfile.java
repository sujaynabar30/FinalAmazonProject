package com.amazon.readfiles;

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

	private Properties properties;
	private final String propertyFilePath= "C:\\Users\\sujay_nabar\\git\\FinalAmazonProject\\FinalAmazonProject\\Configs\\Configuation.properties";
 
	
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
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getUrl()
	{
		String url = properties.getProperty("url");
		if(url!= null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");	
	}
	
	public String getBrowser()
	{
		String browser = properties.getProperty("browser");
		if(browser!= null) return browser;
		else throw new RuntimeException("browser not specified in the Configuration.properties file.");	
	}
	
	public String getEmailId(){
		String emailid = properties.getProperty("emailid");
		if(emailid!= null) return emailid;
		else throw new RuntimeException("emailid not specified in the Configuration.properties file.");		
	}
	
	public String getPassword()
	{
		String password = properties.getProperty("password");
		if(password!= null) return password;
		else throw new RuntimeException("password not specified in the Configuration.properties file.");	
	}
	
	
}
