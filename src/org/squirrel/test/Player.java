package org.squirrel.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import org.squirrel.assets.AssetLoader;
import org.squirrel.core.EwokInput;
import org.squirrel.enginecomponent.components.Collider;
import org.squirrel.enginecomponent.components.WASD;
import org.squirrel.objects.GameObject;
import org.squirrel.objects.ObjectId;

public class Player extends GameObject{
	
	public static BufferedImage playerImg = AssetLoader.loadImage("/Ewok face.png");
	private WASD move;
	public Collider col;
	
	public Player(int xPos, int yPos) {
		super(xPos, yPos, id);
		this.id = ObjectId.PlayerObject;
		move = new WASD(this, 5);
		col = new Collider(this, 133, 148);
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.drawImage(playerImg, getxPos(), getyPos(), null);
		g2d.draw(col.getBounds());
		g2d.setColor(Color.GREEN);
		g2d.drawString(Game.text, getxPos(), getyPos());
		
	}

	@Override
	public void update() {
		move.movePlayer(this, 5);
		col.update();
	}
}
