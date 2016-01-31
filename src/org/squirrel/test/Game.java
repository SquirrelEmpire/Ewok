package org.squirrel.test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import org.squirrel.core.Ewok;
import org.squirrel.core.EwokGame;
import org.squirrel.core.EwokInput;
import org.squirrel.core.EwokWindow;
import org.squirrel.image.AssetLoader;

public class Game extends EwokGame{
	
	private static final long serialVersionUID = -511946696911819575L;
	BufferedImage bob;
	public int test = 200;
	public int test2 = 200;
	
	public Game(){
		setFocusable(true);
	}
	
	@Override
	public void update(Ewok ew) {
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
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawString("Fisk", test, 200);
		g2d.drawRect(test, test2,50, 50);
		g2d.setColor(Color.red);
		g.drawString("Hej", 300, 200);
	}

	
	public static void main(String[] args) {
		Ewok ew = new Ewok(new Game());
		ew.setWidth(800);
		ew.setHeight(600);
		ew.setShowDebugInfo(true);
		ew.start();
	}
}
