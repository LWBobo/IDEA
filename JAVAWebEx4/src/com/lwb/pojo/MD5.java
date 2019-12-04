package com.lwb.pojo;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

	public String gernerateMD5(String text) throws NoSuchAlgorithmException {
		MessageDigest md5= MessageDigest.getInstance("MD5");
		md5.update(text.getBytes());
		byte[] hashcode = md5.digest();
		StringBuffer md5_str = new StringBuffer(hashcode.length<<1);
		for(int i=0; i<hashcode.length; i++){
			md5_str.append(Character.forDigit((hashcode[i]>>4)&0xf, 16));
		}
		return md5_str.toString();
	}
}