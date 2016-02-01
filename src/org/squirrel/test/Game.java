package org.squirrel.test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

import org.squirrel.assets.AssetLoader;
import org.squirrel.core.Ewok;
import org.squirrel.core.EwokGame;
import org.squirrel.core.EwokInput;
import org.squirrel.core.EwokWindow;

public class Game extends EwokGame{
	
	private static final long serialVersionUID = -511946696911819575L;
	public BufferedImage bob;
	public BufferedImage testSprite;
	public Clip fart;
	public int test = 200;
	public int test2 = 200;
	public Ewok ew;
	public Game(){
		setFocusable(true);
		bob = AssetLoader.loadImage("/Ewok face.png");
		fart = AssetLoader.loadSound("/fart.wav");
		testSprite = AssetLoader.getSprite(bob, 15, 42, 86, 82);
	}
	
	@Override
	public void update(Ewok ew, float dt) {
		if(EwokInput.isKey(KeyEvent.VK_D)){
			test += 5;
		}
		if(EwokInput.isKey(KeyEvent.VK_A)){
			test -= 5;
		}
		if(EwokInput.isKey(KeyEvent.VK_W)){
			test2 -= 5;
		}
		if(EwokInput.isKey(KeyEvent.VK_S)){
			test2 += 5;
		}
		if(EwokInput.isKey(KeyEvent.VK_F)){
			fart.start();

		}
		if(EwokInput.isKey(KeyEvent.VK_ESCAPE)){
			System.exit(1);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bob, 0, 0, null);
		g2d.drawImage(testSprite, test, test2, null);
		g2d.setColor(Color.black);
		g2d.drawString("Hello World!", 200, 200);
		Rectangle s = new Rectangle(200, 300, 50, 50);
		g2d.fill(s);
	}

	
	public static void main(String[] args) {
		Ewok ew = new Ewok(new Game());
		ew.setWidth(800);
		ew.setHeight(600);
		ew.setShowDebugInfo(true);
		ew.start();
	}
}
