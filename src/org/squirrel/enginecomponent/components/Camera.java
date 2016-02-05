package org.squirrel.enginecomponent.components;

import org.squirrel.core.EwokGame;
import org.squirrel.enginecomponent.EngineComponent;
import org.squirrel.objects.GameObject;

public class Camera extends EngineComponent{
	
	private float x, y;
	private GameObject player;
	private EwokGame eg;
	private int scale;
	
	public Camera(float x, float y){
		this.x = x;
		this.y = y;
		this.setComponentName("Camera");

	}
	
	
	public void updateCamera(GameObject player, EwokGame eg, int scale){
		x = -player.getxPos() + eg.getWidth() / scale; //  - 133
		y = -player.getyPos() + eg.getHeight() / scale; // - 148;
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
}
