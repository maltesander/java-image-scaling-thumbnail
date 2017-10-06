package com.tutorialacademy.img.imgscalr;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;
import org.imgscalr.Scalr.Mode;

public class ImageScaler {
	
	public static void scaleAll( BufferedImage image, String imageName, String imageType ) throws IOException {
		for ( ImageSize size : ImageSize.values() ) { 
		    scale( image, size, imageName, imageType );
		}
	}
	
	public static void scale( BufferedImage image, ImageSize size, String imageName, String imageType ) throws IOException {
		
		ImageResolution res = size.toImageResolution();
		
		BufferedImage scaledImage = null;
		
		// pixel
		if( res.getPixel() > 0 ) {
			scaledImage = Scalr.resize( image, Method.QUALITY, Mode.AUTOMATIC, res.getPixel(), Scalr.OP_ANTIALIAS );
		}
		// width x height
		else if( res.getWidth() > 0 && res.getHeigth() > 0 ) {
			scaledImage = Scalr.resize( image, Method.QUALITY, Mode.AUTOMATIC, res.getWidth(), res.getHeigth(), Scalr.OP_ANTIALIAS );
		}
		// source
		else if( res.getWidth() < 0 && res.getHeigth() < 0 && res.getPixel() < 0 ) {
			scaledImage = image;
		}
		
		File file = new File( size.toString() + "_" + imageName );

		ImageIO.write( scaledImage, imageType, file );
	}
	
}
