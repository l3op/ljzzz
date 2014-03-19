package com.yy.game.ljzzz.common;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * HMacSHA1.java
 * 2013-3-14 上午10:08:34
 *
 * @author <a href="mailto:chenming@yy.com">chenming</a>
 * 源码来自充值组com.duowan.pay.util.HMacSHA1
 *
 */
public class HMacSHA1 {

	private static final String HMAC_SHA1 = "HmacSHA1";

	private static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}
		return hs.toLowerCase();
	}

	/**
	 * 生成签名数据
	 * 
	 * @param data
	 *            待加密的数据
	 * @param key
	 *            加密使用的key
	 * @return 加密后的字符串，纯小写
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 */
	public static String signature(byte[] data, byte[] key)
			throws InvalidKeyException, NoSuchAlgorithmException {
		SecretKeySpec signingKey = new SecretKeySpec(key, HMAC_SHA1);
		Mac mac = Mac.getInstance(HMAC_SHA1);
		mac.init(signingKey);
		byte[] rawHmac = mac.doFinal(data);
		return byte2hex(rawHmac);
	}
	
	/**
	 * 加密
	 * @param str - 待加密的数据
	 * @param key - 加密使用的key
	 * @return 正常情况下返回加密后的字符串，纯小写；如果出错，返回null
	 */
	public static String signature(String str, String key) {
		String result = null;
		try {
			byte[] data = str.getBytes("UTF-8");
			byte[] keyData = key.getBytes("UTF-8");
			result = signature(data, keyData);
		} catch (UnsupportedEncodingException e) {
		} catch (Exception e) {
		}
		return result;
	}
}
