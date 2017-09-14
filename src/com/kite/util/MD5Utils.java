package com.kite.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public class MD5Utils {

	// 对于密码进行md5和base64编码
	public static String encrypt(String str) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("md5");
			// 获得 使用指定的 byte 数组对摘要进行最后更新，然后完成摘要计算
			byte[] md = md5.digest(str.getBytes());
			// base64进行编码
			String base64str = Base64.encodeBase64String(md);
			return base64str;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
