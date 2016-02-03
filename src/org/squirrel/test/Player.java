package org.squirrel.test;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import org.squirrel.assets.AssetLoader;
import org.squirrel.core.EwokInput;
import org.squirrel.objects.GameObject;
import org.squirrel.objects.ObjectId;

public class Player extends GameObject{
	
	public static BufferedImage playerImg = AssetLoader.loadImage("/Ewok face.png");
	
	public Player(int xPos, int yPos) {
		super(xPos, yPos, id);
		this.id = ObjectId.Player;
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.drawImage(playerImg, getxPos(), getyPos(), null);
		
	}

	@Override
	public void update() {
		
		if(EwokInput.isKey(KeyEvent.VK_D)){
			setxPos(xPos + 5); 
		}
		if(EwokInput.isKey(KeyEvent.VK_A)){
			setxPos(xPos - 5);
		}
		if(EwokInput.isKey(KeyEvent.VK_W)){
			setyPos(yPos - 5);
		}
		if(EwokInput.isKey(KeyEvent.VK_S)){
			setyPos(yPos + 5);
		}
	}
}
