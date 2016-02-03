package org.squirrel.objects;

import org.squirrel.core.EwokGame;

public class Camera {
	
	private float x, y;
	
	public Camera(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public void update(GameObject player, EwokGame eg, int scale){
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
