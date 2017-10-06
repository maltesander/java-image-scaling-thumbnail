package com.tutorialacademy.img.imgscalr;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class App {
	
	// get maven resource path
	private static String getRelativeResourcePath( String resource ) {
		if( resource == null || resource.equals("") ) return null;
		
		return App.class.getClassLoader().getResource( resource ).getPath();
	}
	
	public static void main(String[] args) throws IOException {
		
		String fileName = "example.png";
		
		long startTime = System.currentTimeMillis();
		File f = new File( getRelativeResourcePath( fileName ) );
		
		// for input stream (we required this in the web application (REST - POST))
		//BufferedImage image = ImageIO.read( inputStream );
		
		BufferedImage image = ImageIO.read(f); // load image

		ImageScaler.scaleAll( image, fileName, "png" );

		System.out.println("Process duration : " + ( System.currentTimeMillis() - startTime ) );

	}
}
