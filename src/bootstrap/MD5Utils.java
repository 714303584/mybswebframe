package bootstrap;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Utils {

	private static MessageDigest messageDigest = null;

	static {
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public static String getMD5FromString(String value) {
		messageDigest.reset();
		messageDigest.update(value.getBytes());
		byte[] byt = messageDigest.digest();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < byt.length; i++) {
			sb.append(Integer.toHexString(byt[i] & 0xFF));
		}
		return sb.toString();
	}
	
	public static String getMD5FromFile(String path) throws IOException{
		StringBuilder sb = new StringBuilder();
		StringBuilder fileMD5 = new StringBuilder();
		
		File file = new File(path);
		FileInputStream inputStream = new FileInputStream(file);
		BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
		
		
		byte[] b = new byte[bufferedInputStream.available()];
		while (inputStream.read(b ,0, b.length) > -1) {
		}
		inputStream.close();
		
		messageDigest.reset();
		messageDigest.update(b);
		
		byte[] fileID = messageDigest.digest();
		for (int i = 0; i < fileID.length; i++) {
			sb.append(Integer.toHexString(fileID[i] & 0xFF));
		}
		return sb.toString();
	}
	
	public static String getMD5FromFile2(String path) throws IOException{
        FileInputStream fis = new FileInputStream(path);
 
        byte[] dataBytes = new byte[1];
 
        int nread = 0; 
        int y  = 0;
        while ((nread = fis.read(dataBytes)) != -1) {
          messageDigest.update(dataBytes, 0, nread);
          System.out.println(y++);
        };
        byte[] mdbytes = messageDigest.digest();
 
        //convert the byte to hex format method 1
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < mdbytes.length; i++) {
//          sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
//        }
// 
//        System.out.println("Digest(in hex format):: " + sb.toString());
// 
        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<mdbytes.length;i++) {
    		String hex=Integer.toHexString(0xff & mdbytes[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
		return hexString.toString();
	}

	public static void main(String[] args){
//		String zhuss = "1";
//		System.out.println(MD5Utils.getMD5FromString(zhuss));
		
		//748ee569cbca1b5a7a41958f7a21e690桌面
		//748ee569cbca1b5a7a41958f7a21e690

		//
		try {
			//b8fc96227c970abf25450fd10a7b51b
			//f541c380857f5e9472832a5cc37941a
			//37dd373c42bce7ae7f7736474ee2fdb
//			System.out.println(MD5Utils.getMD5FromFile("C:/Users/Administrator/Desktop/新建文本文档 (4).txt"));
			System.out.println(MD5Utils.getMD5FromFile2("C:/Users/Administrator/Desktop/新建文本文档 (4).txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
