package org.squirrel.image;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class AssetLoader{
	
	private BufferedImage img;
	public AssetLoader(){
		
	}
	
	public BufferedImage loadImage(String path){
		try {
			img = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
}
