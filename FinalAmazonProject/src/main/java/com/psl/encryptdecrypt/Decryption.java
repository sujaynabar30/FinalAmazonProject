package com.psl.encryptdecrypt;

import com.github.windpapi4j.WinAPICallFailedException;
import com.github.windpapi4j.WinDPAPI;

import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Decryption {
	
	public static WinDPAPI winDPAPI;
	
	public static String decrypt(String encryptedString, WinDPAPI winDPAPI) throws WinAPICallFailedException {
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedString);
        return new String(winDPAPI.unprotectData(encryptedBytes), UTF_8);
    }
}
