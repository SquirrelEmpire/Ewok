package org.squirrel.objects;

import java.awt.Graphics2D;

public abstract class GameObject {
	
	public static int xPos = 0,yPos = 0; 
	
	public GameObject(int xPos, int yPos){
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public abstract void draw(Graphics2D g2d);
	public abstract void update();
	
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
}
