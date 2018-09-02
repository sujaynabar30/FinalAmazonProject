package com.psl.createfile;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Filesmethods {
	
	File file = new File("C:\\Users\\Sujay\\git\\FinalAmazonProject\\FinalAmazonProject\\Configs\\Configuation2.properties");
	static String fileName = "C:\\Users\\Sujay\\git\\FinalAmazonProject\\FinalAmazonProject\\TextFile.txt";
	
	public void createFile() {
		
		try {
			
			if(!file.exists()) {
				file.createNewFile();
				System.out.println("\nFile created");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void deleteFile(){
		
		if(file.delete()) {
			System.out.println("\n'"+file.getName()+"'"+ " is deleted");
		}
		else {
			System.out.println("Operation of Deletion failed");
		}
	}
	
    public static void clearTheFile() throws IOException {
    	PrintWriter writer = new PrintWriter(fileName);
    	writer.print("");
    	writer.close();
    }

	
/*	public static void main(String[] args) {
		
		Filesmethods nfile = new Filesmethods();
		nfile.createFile();
		nfile.deleteFile();
		
	}*/
}
