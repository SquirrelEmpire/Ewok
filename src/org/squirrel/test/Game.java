package org.squirrel.test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JOptionPane;

import org.squirrel.assets.AssetLoader;
import org.squirrel.core.Ewok;
import org.squirrel.core.EwokGame;
import org.squirrel.core.EwokInput;
import org.squirrel.core.EwokWindow;
import org.squirrel.enginecomponent.components.Camera;
import org.squirrel.objects.GameHandlere;
import org.squirrel.objects.GameObject;
import org.squirrel.objects.ObjectId;
import org.squirrel.utils.Debugger;
import org.squirrel.utils.TextUtils;

public class Game extends EwokGame{
	
	private static final long serialVersionUID = -511946696911819575L;
	public Clip fart;
	public int test = 200;
	public int test2 = 200;
	public Ewok ew;
	public GameHandlere handler;
	public Camera cam1;
	public String score;
	public String name;
	public static String text;
	
	public Game(){
		setFocusable(true);
		//Init Game Comp
		handler = new GameHandlere();
		fart = AssetLoader.loadSound("/fart.wav");
		handler.addGameObject(new Player(0,0));
		cam1 = new Camera(0, 0);
		
		name = JOptionPane.showInputDialog("What your name", null);
		
		try {
			TextUtils.writeProp("score.properties", "score", "10");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			TextUtils.writeProp("score.properties", "userName", name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			text = TextUtils.readProp("score.properties", "userName");
			System.out.println("Name:"+text);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			score = TextUtils.readProp("score.properties", "score");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void update(Ewok ew, float dt) {

		if(EwokInput.isKey(KeyEvent.VK_F)){
			fart.start();

		}
		if(EwokInput.isKey(KeyEvent.VK_ESCAPE)){
			System.exit(1);
		}
		handler.update();
		
		//Camera
		for(int i = 0; i < handler.gameObjects.size(); i++){
			// If the object has the id of a player then update the camera
			
			if(handler.gameObjects.get(i).getId() == ObjectId.PlayerObject){
				cam1.updateCamera(handler.gameObjects.get(i), this, 2);
			}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		// camera
		///////////////////////////////////////
		g2d.translate(cam1.getX(), cam1.getY());
		

		g2d.setColor(Color.black);
		g2d.drawString("Hello World!", 200, 200);
		Rectangle s = new Rectangle(200, 300, 50, 50);
		g2d.fill(s);
		handler.draw(g2d);
		
		g2d.translate(-cam1.getX(), -cam1.getY());
		////////////////////////////////////////
		g2d.setColor(Color.black);
		g2d.drawString("PlayerScore: "+score, 20, 20);
	}

	
	public static void main(String[] args) {
		Ewok ew = new Ewok(new Game());
		ew.setWidth(800);
		ew.setHeight(600);
		Debugger.enableDebugger();
		ew.start();
	}
}
