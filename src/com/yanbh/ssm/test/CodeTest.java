package com.yanbh.ssm.test;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class CodeTest {

	BASE64Encoder encoder = new BASE64Encoder();
	BASE64Decoder decoder = new BASE64Decoder();

	public static void main(String args[]){
		try {
			String data = "Hello，World";
			CodeTest test = new CodeTest();
			
			//测试base64的编码和解码
			String result = test.base64Encoder(data.getBytes());
			System.out.println(result);
			byte[] decoderResult = test.base64Decoder(result);
			System.out.println(new String(decoderResult));
			
			//测试md5加密
			byte[] md5Result = test.md5Encoder(data);
			String md5Base64EncoderResult = test.base64Encoder(md5Result);
			System.out.println(md5Base64EncoderResult);
			
			//测试SHA加密
			byte[] shaResult = test.shaEncoder(data);
			String shaBase64EncoderResult = test.base64Encoder(shaResult);
			System.out.println(shaBase64EncoderResult);
		} catch (Exception e) {
			
		}
	}

	/**
	 * 使用BASE64进行加密
	 * @param data
	 * @return
	 */
	public String base64Encoder(byte[] data) {
		return encoder.encode(data);
	}

	/**
	 * 使用BASE64进行解密
	 * @param data
	 * @return
	 * @throws IOException
	 */
	public byte[] base64Decoder(String data) throws IOException {
		return decoder.decodeBuffer(data);
	}

	/**
	 * 对数据进行MD5加密
	 * 不可逆的
	 * @param data
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public byte[] md5Encoder(String data) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		return md5.digest(data.getBytes());
	}
	
	/**
	 * 对数据进行SHA(安全散列算法)加密
	 * 不可逆
	 * @param data
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public byte[] shaEncoder(String data) throws NoSuchAlgorithmException {
		MessageDigest sha = MessageDigest.getInstance("sha");
		return sha.digest(data.getBytes());
	}

}
