package org.squirrel.enginecomponent.components;

import java.awt.Rectangle;

import org.squirrel.enginecomponent.EngineComponent;
import org.squirrel.objects.GameObject;

public class Collider extends  EngineComponent{
	
	private int boundsXPos;
	private int boundsYPos;
	private int boundsWidth;
	private int boundsHeight;
	private GameObject object;
	
	public Collider(GameObject object, int width, int height){
		this.boundsXPos = object.getxPos();
		this.boundsYPos = object.getyPos();
		this.boundsWidth = width;
		this.boundsHeight = height;
		this.object = object;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(boundsXPos, boundsYPos, boundsWidth, boundsHeight);
	}
	
	public void update(){
		this.boundsXPos = object.getxPos();
		this.boundsYPos = object.getyPos();
	}
}
