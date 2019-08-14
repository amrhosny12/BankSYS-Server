package com.OnlineBanking.services;

import java.security.Key;
import java.security.MessageDigest;
import java.util.Base64;

import javax.crypto.spec.SecretKeySpec;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class SecurityUtil {
	
	public String encodeText(String text) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(text.getBytes("UTF-8"));
			byte[] pwDigest = md.digest();
			return new String(Base64.getEncoder().encode(pwDigest));
		
		}catch (Exception e) {
			throw new RuntimeException("Exception at encoding", e);
		}
	}
	
	public Key generateKey(String KeyString) {
		return new SecretKeySpec(KeyString.getBytes(), 0, KeyString.getBytes().length, "DES");
	}
	
}

