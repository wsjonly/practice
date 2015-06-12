package com.weng.image;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class RotateImage {
	
	public static final int MAX_IMAGE_SIZE = 1014 * 1024 * 10;  
	
	public static final int BUFFER_SIZE = 1024 *10;
	
	public static byte[] inputStream2ByteArray(InputStream inputStream) throws IOException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		FileOutputStream fos = new FileOutputStream("/test.jpg");
		byte[] data = new byte[BUFFER_SIZE];
		int length;
		while((length=inputStream.read(data, 0, BUFFER_SIZE)) > 0) {
			os.write(data, 0, length);
			fos.write(data, 0, length);
		}
		
//		BufferedWriter br = new BufferedWriter(new FileWriter(new File("/test.jpeg")));
//		fos.write(os.toByteArray(), 0, os.toByteArray().length);
		
		fos.close();
		return os.toByteArray();
	}
	
	
	

	public static void main(String[] args) throws IOException{
		File file = null;
		try {
			file = new File("/image.jpg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileInputStream is = new FileInputStream(file);
		
		byte[] b = new byte[MAX_IMAGE_SIZE];
		b = inputStream2ByteArray(is);
		
		BufferedImage image = ImageIO.read(file);
	}
}
