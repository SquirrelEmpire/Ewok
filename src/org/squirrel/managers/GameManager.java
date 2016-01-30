package org.squirrel.managers;

import java.awt.Graphics2D;
import java.util.LinkedList;

import org.squirrel.objects.GameObject;
import org.squirrel.objects.ObjectTypes;

public class GameManager {
		
		public static LinkedList<GameObject> gameObjs = new LinkedList<GameObject>();
		GameObject TempObj;
		
		public GameManager() {
		}
		
		public void draw(Graphics2D g2d){
			for(int i = 0; i < gameObjs.size(); i++){
				TempObj = gameObjs.get(i);
				
				TempObj.draw(g2d);
			}
		}
		
		public void update(){
			for(int i = 0; i < gameObjs.size(); i++){
				TempObj = gameObjs.get(i);
				
				TempObj.update();
			}
		}
		
		public void addObject (GameObject object){
			gameObjs.add(object);
		}
		
		
		public void removeObject(GameObject object){
			gameObjs.remove(object);
		}
		
		public static LinkedList<GameObject> getGameObjectsBounds(){
			return gameObjs;
		}
}
