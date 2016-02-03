package org.squirrel.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class GameObject {
	
	public static int xPos = 0,yPos = 0; 
	public static ObjectId id;
	
	public GameObject(int xPos, int yPos, ObjectId id){
		this.xPos = xPos;
		this.yPos = yPos;
		this.id = id;
	}
	
	public abstract void draw(Graphics2D g2d);
	public abstract void update();
	
	public int getImgCenterX(BufferedImage img){
		int width = img.getWidth();
		
		int centerX = width / 2;
		
		return centerX;
	}
	
	public int getImgCenterY(BufferedImage img){
		int height = img.getHeight();
		
		int centerY = height / 2;
		
		return centerY;
	}
	
	public static int getxPos() {
		return xPos;
	}

	public static void setxPos(int xPos) {
		GameObject.xPos = xPos;
	}

	public static int getyPos() {
		return yPos;
	}

	public static void setyPos(int yPos) {
		GameObject.yPos = yPos;
	}

	public ObjectId getId() {
		return id;
	}
}
