package org.squirrel.enginecomponent.components;

import java.awt.event.KeyEvent;

import org.squirrel.core.EwokInput;
import org.squirrel.enginecomponent.EngineComponent;
import org.squirrel.objects.GameObject;

public class WASD extends EngineComponent{

	private GameObject player;
	public int speed = 0;
	
	public WASD(GameObject player, int speed){
		this.setComponentName("WASD");
		this.player = player;
		this.speed = speed;
	}
	
	@Override
	public void update() {
		movePlayer(player, speed);
	}
	
	private void movePlayer(GameObject player, int speed){
		if(EwokInput.isKey(KeyEvent.VK_D)){
			player.setxPos(player.xPos + speed); 
		}
		if(EwokInput.isKey(KeyEvent.VK_A)){
			player.setxPos(player.xPos - speed);
		}
		if(EwokInput.isKey(KeyEvent.VK_W)){
			player.setyPos(player.yPos - speed);
		}
		if(EwokInput.isKey(KeyEvent.VK_S)){
			player.setyPos(player.yPos + speed);
		}
	}
}
