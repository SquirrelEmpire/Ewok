package org.squirrel.test;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import org.squirrel.assets.AssetLoader;
import org.squirrel.core.EwokInput;
import org.squirrel.enginecomponent.components.WASD;
import org.squirrel.objects.GameObject;
import org.squirrel.objects.ObjectId;

public class Player extends GameObject{
	
	public static BufferedImage playerImg = AssetLoader.loadImage("/Ewok face.png");
	private WASD move;
	
	public Player(int xPos, int yPos) {
		super(xPos, yPos, id);
		this.id = ObjectId.Player;
		move = new WASD(this, 5);
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.drawImage(playerImg, getxPos(), getyPos(), null);
		
	}

	@Override
	public void update() {
		move.movePlayer(this, 5);
	}
}
