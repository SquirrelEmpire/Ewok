package org.squirrel.test;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import org.squirrel.core.Ewok;
import org.squirrel.core.EwokGame;
import org.squirrel.core.EwokInput;
import org.squirrel.core.EwokWindow;
import org.squirrel.image.Image;

public class Game extends EwokGame{
	
	private static final long serialVersionUID = -511946696911819575L;
	BufferedImage bob;
	
	public Game(){
		bob = Image("/weed.png");
	}
	
	@Override
	public void update(Ewok ew) {
		if(EwokInput.isKey(KeyEvent.VK_D)){
			System.out.println("Fisk");
		}
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g.drawString("Fisk", 200, 200);
		g.drawImage(bob, 400, 200, null);
	}

	
	public static void main(String[] args) {
		EwokWindow window = new EwokWindow(800, 600, "Test", new Game());
		Ewok ew = new Ewok(new Game(), window);
		ew.setShowDebugInfo(true);
		ew.start();
	}
}
