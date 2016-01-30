package org.squirrel.objects;

import java.awt.Graphics2D;

public class GameObject {
	
	public static int posX = 0;
	public static int posY = 0;
	public ObjectTypes type;
	
	public GameObject(int xPos, int yPos,ObjectTypes objectType){
		this.posX = xPos;
		this.posY = yPos;
		this.type = objectType;
	}
	public void update() {
		
	}
	public void draw(Graphics2D g2d) {
		
	}
}
