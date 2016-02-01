package org.squirrel.assets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AssetLoader{
	
	private static BufferedImage img;
	private static Clip clip; 
	public AssetLoader(){
		
	}
	
	public static BufferedImage loadImage(String path){
		img = null;
		try {
			//Try to read the image
			img = ImageIO.read(AssetLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return img;
	}
	
	public static BufferedImage getSprite(BufferedImage spriteSheet,int tileXPos, int tileYPos, int tileWidth, int tileHeight ){
		//Get the subimage of the spritesheet
		BufferedImage sprite = spriteSheet.getSubimage(tileXPos, tileYPos, tileWidth, tileHeight);
		return sprite;
	}
	
	public static Clip loadSound(String path){
		try{
			//Get the audio file as an input stream
			URL url = AssetLoader.class.getResource(path);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			//Open the clip
			
			clip = AudioSystem.getClip();
			clip.open(audioIn);	
		}catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
		return clip;
	}
	
}
