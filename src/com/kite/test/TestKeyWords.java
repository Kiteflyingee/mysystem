package com.kite.test;

import org.junit.Test;

import com.kite.util.MD5Utils;

public class TestKeyWords {

	@Test
	public void getKeyWords() {
		String str = "123456";
		System.out.println(MD5Utils.encrypt(str));
	}
}
