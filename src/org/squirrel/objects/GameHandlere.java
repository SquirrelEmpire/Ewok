package org.squirrel.objects;

import java.awt.Graphics2D;
import java.util.LinkedList;

public class GameHandlere {
	
	public static LinkedList<GameObject> gameObjects = new LinkedList<GameObject>();
	public GameObject tempObject;
	public ObjectId tempId;
	
	public GameHandlere(){
		
	}
	
	public void draw(Graphics2D g2d){
		for(int i = 0; i < gameObjects.size(); i++){
			tempObject = gameObjects.get(i);
			tempObject.draw(g2d);
		}
	}
	
	public void update(){
		for(int i = 0; i < gameObjects.size(); i++){
			tempObject = gameObjects.get(i);
			tempObject.update();
		}
	}
	
	public void addGameObject(GameObject object){
		gameObjects.add(object);
	}
	
	public void removeGameObject(GameObject object){
		gameObjects.remove(object);
	}
	
	public ObjectId getId(){
		for(int i = 0; i < gameObjects.size(); i++){
			tempObject = gameObjects.get(i);
			tempId = tempObject.getId();
		}
		return tempId;
	}
}
